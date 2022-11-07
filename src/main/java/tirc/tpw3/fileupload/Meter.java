package tirc.tpw3.fileupload;

import java.util.List;



import org.springframework.stereotype.Component;

@Component
public class Meter {
	
	private int id;

	private String main_number;

	private List<String> meter_number;

	private String task;

	private String image;
	
	public Meter() {}

	public Meter(String main_number, List<String> meter_number, String task, String image) {
		super();
		this.main_number = main_number;
		this.meter_number = meter_number;
		this.task = task;
		this.image = image;
	}

	public String getMain_number() {
		return main_number;
	}

	public void setMain_number(String main_number) {
		this.main_number = main_number;
	}

	public List<String> getMeter_number() {
		return meter_number;
	}

	public void setMeter_number(List<String> meter_number) {
		this.meter_number = meter_number;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Meter [id=" + id + ", main_number=" + main_number + ", meter_number=" + meter_number + ", task=" + task
				+ ", image=" + image + "]";
	}
	
}


