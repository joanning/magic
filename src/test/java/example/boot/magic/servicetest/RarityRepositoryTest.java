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
import example.boot.magic.entity.Rarity;
import example.boot.magic.service.RarityRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MagicApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class RarityRepositoryTest {
	
	@Value("${local.server.port}")
	private int port;
	
	@Autowired
	RarityRepository repo;
	
	@Test
	public void testRarity() {
		Iterable<Rarity> rarities = repo.findAll();
		assertNotNull(rarities);
	}

}
