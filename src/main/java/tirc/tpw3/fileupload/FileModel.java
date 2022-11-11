package tirc.tpw3.fileupload;

public class FileModel {
	private String saveTime;
	private String rgbImagePath;
	private String thermalImagePath;
	private int actionIdx;

	// Ryan Lou

	private IdNameForActionObj idName;
	private ActionObj action;
	private String taskName;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public ActionObj getActionObj() {
		return action;
	}

	public void setActionObj(ActionObj actionObj) {
		this.action = actionObj;
	}
	

	public IdNameForActionObj getIdName() {
		return idName;
	}

	public void setIdName(IdNameForActionObj idName) {
		this.idName = idName;
	}

	// Ryan Lou


	public String getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}

	public String getRgbImagePath() {
		return rgbImagePath;
	}

	public void setRgbImagePath(String rgbImagePath) {
		this.rgbImagePath = rgbImagePath;
	}

	public String getThermalImagePath() {
		return thermalImagePath;
	}

	public void setThermalImagePath(String thermalImagePath) {
		this.thermalImagePath = thermalImagePath;
	}

	public int getActionIdx() {
		return actionIdx;
	}

	public void setActionIdx(int actionIdx) {
		this.actionIdx = actionIdx;
	}

	@Override
	public String toString() {
		return "Action [saveTime=" + saveTime + ", rgbImagePath=" + rgbImagePath + ", thermalImagePath="
				+ thermalImagePath + ", actionIdx=" + actionIdx + ", idName=" + idName + ", actionObj=" + action
				+ "]";
	}

}
