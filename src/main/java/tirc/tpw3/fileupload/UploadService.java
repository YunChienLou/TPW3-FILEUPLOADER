package tirc.tpw3.fileupload;

import java.io.File;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import tirc.tpw3.json.ServerSetting;

@Service
public class UploadService {
	Logger log = LoggerFactory.getLogger(UploadService.class);
	
	// Ryan Lou
//	private static String folder = "C:\\data\\TPW3_test_data\\[tpw1Test] 2020_11_12_15_38_00";
	
	private static String ACTION_QUEUE = "queue#action";
	private ServerSetting serverSetting = new ServerSetting("tpw3_fileupload");
	
//	@Autowired
//	private MinioService minioService;
	// Ryan Lou
	
	@Autowired
	private HttpRequestService httpRequestService;

	@Scheduled(fixedRate = 1000)
	public void schedule() {

		Jedis jedis = null;

		try {

			jedis = new Jedis();
			long len = jedis.llen(ACTION_QUEUE);
			log.info("目前已收到待處理資料數: {}", len);
			// =========================================
			// queue not empty
			// 1. get the last item
			// 2. upload
			// 3. if success, remove the last item
			while (len > 0) {
				log.info("目前剩餘資料數: {}", len);
				String sz = jedis.lindex(ACTION_QUEUE, -1); // 取得列表中最後一個action file
				
				// Ryan Lou
				
				FileModel fileModel = Utils.getGson().fromJson(sz, FileModel.class);
				// json 轉換成 java 物件
				
				// Ryan Lou
				
				String rgbImagePath = fileModel.getRgbImagePath();

				if (null != rgbImagePath) {
					System.out.println("----------------");

//					String parent = FilenameUtils.getName(FilenameUtils.getPathNoEndSeparator(rgbImagePath));
//					String filename = FilenameUtils.getName(rgbImagePath);
//					log.debug("folder:{}", parent);
					
					// Ryan Lou
					
					CameraInfoForActionObj cameraInfo = fileModel.getActionObj().getCameraInfoForActionObj();
					IdNameForActionObj idName = fileModel.getIdName();
					
					String filename = FilenameUtils.getName(rgbImagePath).replaceAll("[^0-9_]","");
					// 只留下檔名的數字部分 (.jpg 去掉)
					
					String task = fileModel.getTaskName();
					String main_number = cameraInfo.getRecogType();
					List<String> meter_number = cameraInfo.getMeasureMeters();
					
					byte[] RGBImageContent = FileUtils.readFileToByteArray(new File(rgbImagePath));
					String RGBImageBase64String = Base64.getEncoder().encodeToString(RGBImageContent);

					Meter meterReq = new Meter(main_number, meter_number, task, RGBImageBase64String);
					System.out.print(meterReq);
					try {
						Meter meter = httpRequestService.metersPost(serverSetting.getUploadUrl(), meterReq);
						log.info("httpRequestService success , Task : " + meter.getTask() + " Id : " + meter.getId()) ;
					} catch (Exception ex) {
						log.error("httpRequestService fail " + " request body : "+ meterReq);
//						pressEnterToContinue();
					}

					// upload image
//					File f = new File(folder, filename);
//					minioService.putObject(new FileInputStream(f), parent+"/"+filename, "image/jpeg");

					// upload action
//					fileModel.setRgbImagePath(filename); // 修正檔名
//					minioService.putObject(IOUtils.toInputStream(Utils.getGson().toJson(action), StandardCharsets.UTF_8),
//							parent+"/Action_"+action.getActionIdx(), "application/json");
					
					// Ryan Lou
				}

				jedis.rpop(ACTION_QUEUE);

				len = jedis.llen(ACTION_QUEUE);

			}

		} catch (Exception ex) {
			log.error("UploadService error: " + ex.getMessage());
		} finally {
			if (null != jedis)
				jedis.close();
		}

	}
}
