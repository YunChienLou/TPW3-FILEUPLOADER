package tirc.tpw3.fileupload;

import java.time.Duration;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import tirc.tpw3.json.ServerSetting;

@Service
public class HttpRequestService {

	Logger log = LoggerFactory.getLogger(HttpRequestService.class);

	private int TIMEOUT;
	private RestTemplate restTemplate;

	@Autowired
	private ServerSetting serverSetting;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Autowired
	public HttpRequestService() {
		log.info("restTemplateBuilder : " + restTemplateBuilder);

	};

	@PostConstruct
	private void initHttpRequestService() {
		this.TIMEOUT = serverSetting.getTimeOut();
		this.restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(TIMEOUT))
				.setReadTimeout(Duration.ofSeconds(TIMEOUT)).build();
	}

	public Meter metersPost(final String url, final Meter meter) {

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);

		// build the request
		HttpEntity<Meter> entity = new HttpEntity<>(meter, headers);

		try {
			ResponseEntity<Meter> response = this.restTemplate.postForEntity(url, entity, Meter.class);
			log.info("HTTP POST SUCCESS , StatusCode :" + response.getStatusCode() + ", responseBody : " + response.getBody());
			return response.getBody(); // Customization your response format
		} catch (IllegalArgumentException e) {
			log.error("http post error {}", e);
			e.printStackTrace();
			return null;
		}
	}
}
