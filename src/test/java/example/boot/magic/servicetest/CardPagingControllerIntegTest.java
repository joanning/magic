package example.boot.magic.servicetest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import example.boot.magic.MagicApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MagicApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class CardPagingControllerIntegTest {
	
	@Value("${local.server.port}")
	private int port;
	
	@Test
	public void testController() {

	MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
	parts.add("cardName", "KIN");
	parts.add("cardManaCost", "");
	parts.add("cardPower", "");
	parts.add("cardToughness", "");
	parts.add("dir", "DESC");
	parts.add("sort", "cardName");
	parts.add("start", 1);
	parts.add("limit", 20);
	
	ResponseEntity<String> entity = new TestRestTemplate().postForEntity("http://localhost:8080/magic/cards/paged",
			parts,String.class);
	
	assertNotNull(entity.getBody());	
	}
}
