package tirc.tpw3.fileupload;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRequestService {

	private static final int TIMEOUT = 500;
	private final RestTemplate restTemplate;

	public HttpRequestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(TIMEOUT))
				.setReadTimeout(Duration.ofSeconds(TIMEOUT)).build();
	};

	public Meter metersPost(final String url, final Meter meter) {

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);

		// build the request
		HttpEntity<Meter> entity = new HttpEntity<>(meter, headers);

		try {
			Meter rs = this.restTemplate.postForObject(url, entity, Meter.class);
			return rs; // Customization your response format
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}
}
