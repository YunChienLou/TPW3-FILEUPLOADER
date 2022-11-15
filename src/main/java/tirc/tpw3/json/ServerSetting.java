package tirc.tpw3.json;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tirc.tpw3.fileupload.Utils;

@Slf4j
@Component
public class ServerSetting {
	private transient File file;
	
	private int timeOut = 1500;
	private String appName = "tpw3_fileupload";
	private String uploadUrl = "http://localhost:8080/meters";
	
	public ServerSetting() {
		String path = appName + File.separator + "setting.json";
		file = new File(FileUtils.getUserDirectory(), path);
	}
	
	@PostConstruct
	public void load() {
		try {
			// 檔案不存在
			if (!file.exists()) {
				String content = Utils.getGson().toJson(this);
				Utils.string2File(file, content);
			} else {
				String content = Utils.file2String(file);
				ServerSetting settings = Utils.getGson().fromJson(content, ServerSetting.class);
				this.update(settings);
			}
		} catch (IOException e) {
			log.error("failed to load the setting.", e);
			throw new RuntimeException("failed to load the setting.", e);
		}
	}

	/**
	 * 複製欄位，若有新增的欄位必需實作
	 * 
	 */
	public void update(ServerSetting another) {
		this.setUploadUrl(another.getUploadUrl());
		this.setTimeOut(another.getTimeOut());
	}

//	public void save() {
//		try {
//			String content = Utils.getGson().toJson(this);
//			Utils.string2File(file, content);
//		} catch (Exception e) {
//			log.error("failed to save the setting.", e);
//			throw new RuntimeException("failed to save the setting.", e);
//		}
//	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

}
