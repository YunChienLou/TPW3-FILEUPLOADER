package tirc.tpw3.fileupload;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;

//@Service
public class MinioService {
	 Logger log = LoggerFactory.getLogger(MinioService.class);
	
	private final String bucket;
    private final MinioClient minioClient;

    public MinioService(@Value("${minio.url}") String url,
                        @Value("${minio.access}") String access,
                        @Value("${minio.secret}") String secret,
                        @Value("${minio.bucket}") String bucket) throws Exception {
        this.bucket = bucket;
        minioClient = MinioClient.builder()
                .endpoint(url)
                .credentials(access, secret)
                .build();
        // 初始化Bucket
        initBucket();
    }

    private void initBucket() throws Exception {
        // 應用啟動時檢測Bucket是否存在
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        // 如果Bucket不存在，則建立Bucket
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            log.info("成功建立 Bucket [{}]", bucket);
        }
    }

    /**
     * 上傳檔案
     * @param is 輸入流
     * @param object 物件（檔案）名
     * @param contentType 檔案型別
     */
    public void putObject(InputStream is, String object, String contentType) throws Exception {
        long start = System.currentTimeMillis();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucket)
                .object(object)
                .contentType(contentType)
                .stream(is, -1, 1024 * 1024 * 10) 
                .build());
        log.info("成功上傳檔案至雲端 [{}]，耗時 [{} ms]", object, System.currentTimeMillis() - start);
    }

    /**
     * 獲取檔案流
     * @param object 物件（檔案）名
     * @return 檔案流
     */
    public GetObjectResponse getObject(String object) throws Exception {
        long start = System.currentTimeMillis();
        GetObjectResponse response = minioClient.getObject(GetObjectArgs.builder()
                .bucket(bucket)
                .object(object)
                .build());
        log.info("成功獲取 Object [{}]，耗時 [{} ms]", object, System.currentTimeMillis() - start);
        return response;
    }

    /**
     * 刪除物件（檔案）
     * @param object 物件（檔名）
     */
    public void removeObject(String object) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(bucket)
                .object(object)
                .build());
        log.info("成功刪除 Object [{}]", object);
    }	
	
}
