package example.boot.magic.servicetest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import example.boot.magic.MagicApplication;
import example.boot.magic.entity.Color;
import example.boot.magic.service.ColorRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MagicApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class ColorRepositoryTest {
	
	@Value("${local.server.port}")
	private int port;
	
	@Autowired
	ColorRepository repo;
	
	@Test
	public void testColor() {
		Iterable<Color> colors = repo.findAll();
		assertNotNull(colors);
	}

}
