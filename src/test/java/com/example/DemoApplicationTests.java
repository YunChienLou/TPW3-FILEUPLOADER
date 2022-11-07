package com.example;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import tirc.tpw3.fileupload.Utils;

class DemoApplicationTests {

	Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

	private static String folder = "C:\\data\\TPW3_test_data\\[tpw3Test] 2022_11_4_11_29_00";
	private static String ACTION_QUEUE = "queue#action";

	static Jedis jedis = null;

	@BeforeAll
	static void init() {
		jedis = new Jedis();
	}

	@AfterAll
	static void finish() {
		if (null != jedis) {
			jedis.close();
		}
	}

	@Test
	void sendActions() throws IOException, InterruptedException {
		File f = new File(folder);
		File[] files = f.listFiles((dir, name) -> {
			return name.startsWith("Action_");
		});
		// 找出所有 action files
		int count = 0;
		for (File file : files) {
			String s = Utils.file2String(file);
			jedis.lpush(ACTION_QUEUE, s);
			// TimeUnit.SECONDS.sleep(10);
			count += 1;
		}
		log.info("count: {}", count);
	}

//	static String MINIO_URL =  "http://127.0.0.1:9000";
//	static String MINIO_USER = "minioadmin";
//	static String MINIO_SECRET = "minioadmin";
//	static String MINIO_BUCKET = "file";
//	
//	//@Test
//	void minioTest() throws InvalidKeyException, ErrorResponseException, InsufficientDataException, InternalException, InvalidResponseException, NoSuchAlgorithmException, ServerException, XmlParserException, IllegalArgumentException, IOException {
//		MinioClient minioClient = MinioClient.builder()
//                .endpoint(MINIO_URL)
//                .credentials(MINIO_USER, MINIO_SECRET)
//                .build();
//		
//		boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(MINIO_BUCKET).build());
//		
//		System.out.println("Bucket Found: "+found);
//		
//		minioClient.makeBucket(MakeBucketArgs.builder().bucket(MINIO_BUCKET).build());
//		
//	}

//	void minioNotify() {
//		MinioClient minioClient = MinioClient.builder()
//                .endpoint(MINIO_URL)
//                .credentials(MINIO_USER, MINIO_SECRET)
//                .build();
//		
//		minioClient.setBucketNotification(args);
//	}

}
