package tirc.tpw3.fileupload;

import java.util.List;

public class CameraInfoForActionObj {

	private String recogType; // 主變編號
	private List<String> measureMeters; // 表頭

	public String getRecogType() {
		return recogType;
	}

	public void setRecogType(String recogType) {
		this.recogType = recogType;
	}

	public List<String> getMeasureMeters() {
		return measureMeters;
	}

	public void setMeasureMeters(List<String> measureMeters) {
		this.measureMeters = measureMeters;
	}

}
