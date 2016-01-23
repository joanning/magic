package example.boot.magic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.Artist;
import example.boot.magic.service.ArtistRepository;

@Controller
@RequestMapping(value="artists")
public class ArtistController {
	@Autowired
	ArtistRepository repo;
	
	@RequestMapping("")
	public @ResponseBody List<Artist> getAllArtist() {
		List<Artist> artists = new ArrayList<Artist>();
		Iterable<Artist> results = repo.findAll();
		for (Artist artist : results) {
			artists.add(artist);
		}
		return artists;
	}

}
