package tirc.tpw3.fileupload;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRequestService {
	Logger log = LoggerFactory.getLogger(MinioService.class);

	private static final int TIMEOUT = 500;
	private final RestTemplate restTemplate;

	public HttpRequestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(TIMEOUT))
				.setReadTimeout(Duration.ofSeconds(TIMEOUT)).build();
	};

	public String metersPost(final String url, final Meter meter) {

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);

		// build the request
		HttpEntity<Meter> entity = new HttpEntity<>(meter, headers);

		try {
			String rs = this.restTemplate.postForObject(url, entity, String.class);
			return rs; // Customization your response format
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String unknownRequest() {
		try {
			String url = "https://jsonplaceholder.typicode.com/404";
			return this.restTemplate.getForObject(url, String.class);
		} catch (HttpStatusCodeException ex) {
			// raw http status code e.g `404`
			System.out.println(ex.getRawStatusCode());
			// http status code e.g. `404 NOT_FOUND`
			System.out.println(ex.getStatusCode().toString());
			// get response body
			System.out.println(ex.getResponseBodyAsString());
			// get http headers
			HttpHeaders headers = ex.getResponseHeaders();
			System.out.println(headers.get("Content-Type"));
			System.out.println(headers.get("Server"));
		}

		return null;
	}
}
