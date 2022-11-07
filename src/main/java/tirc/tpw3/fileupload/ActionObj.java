package tirc.tpw3.fileupload;

// Ryan Lou
public class ActionObj {
	private CameraInfoForActionObj cameraInfo;

	public CameraInfoForActionObj getCameraInfoForActionObj() {
		return cameraInfo;
	}

	public void setCameraInfoForActionObj(CameraInfoForActionObj cameraInfoForActionObj) {
		this.cameraInfo = cameraInfoForActionObj;
	}

	@Override
	public String toString() {
		return "ActionObj [cameraInfoForActionObj=" + cameraInfo + "]";
	}
	
	
}
