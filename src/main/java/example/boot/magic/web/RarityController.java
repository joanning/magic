package example.boot.magic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.Rarity;
import example.boot.magic.service.RarityRepository;

@Controller
@RequestMapping(value="rarities")
public class RarityController {
	@Autowired
	RarityRepository repo;
	
	@RequestMapping("")
	public @ResponseBody List<Rarity> getAllRarity() {
		List<Rarity> rarities = new ArrayList<Rarity>();
		Iterable<Rarity> results = repo.findAll();
		for (Rarity rarity : results) {
			rarities.add(rarity);
		}
		return rarities;
	}

}
