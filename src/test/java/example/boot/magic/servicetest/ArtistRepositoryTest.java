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
import example.boot.magic.entity.Artist;
import example.boot.magic.service.ArtistRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MagicApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class ArtistRepositoryTest {
	
	@Value("${local.server.port}")
	private int port;
	
	@Autowired
	ArtistRepository repo;
	
	@Test
	public void testArtist() {
		Iterable<Artist> artists = repo.findAll();
		assertNotNull(artists);
	}

}
