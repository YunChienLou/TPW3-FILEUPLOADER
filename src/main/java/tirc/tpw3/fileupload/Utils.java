package tirc.tpw3.fileupload;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {

	private static Gson gson = new GsonBuilder()
	        .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)
	        .setPrettyPrinting()
	        .create();
		
	
	public static Gson getGson() {
		return gson;
	}
	
	public static void string2File(File file, String content) throws IOException {
		FileUtils.write(file, content, StandardCharsets.UTF_8);
	}
	
	public static String file2String(File file) throws IOException {
		return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	}
	
	
	public static SimpleTriggerContext newTriggerContext(Date from) {
		
		if (null == from) from = new Date();
		
		SimpleTriggerContext triggerContext = new SimpleTriggerContext();
		triggerContext.update(null, null, from);
		
		return triggerContext;		
	}
	
	public static Date nextExecutionTime(TriggerContext triggerContext, String crontabStr) {
		CronTrigger trigger = new CronTrigger(crontabStr);
		Date fireAt = trigger.nextExecutionTime(triggerContext);
		return fireAt;
	}
	
	
	public static byte[] file2ByteArray(File file) throws IOException {
		return FileUtils.readFileToByteArray(file);
	}
	

	static DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static String date2String(Date date) {
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDateTime();
		return localDateTime.format(datePattern);
	}

	public static String date2String(LocalDate date) {
		return date.format(datePattern);
	}

	public static LocalDateTime parseDateString(String s) {
		return LocalDateTime.parse(s);
	}
	
}
