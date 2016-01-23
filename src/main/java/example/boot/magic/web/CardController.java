package example.boot.magic.web;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.Card;
import example.boot.magic.service.CardRepository;

@Controller
@RequestMapping(value="cards")
public class CardController {
	@Autowired
	CardRepository repo;
	
	
	@RequestMapping("")
	public @ResponseBody List<Card> getAllCard() {
		List<Card> cards = new ArrayList<Card>();
		Iterable<Card> results = repo.findAll();
		for (Card card : results) {
			cards.add(card);
		}
		return cards;
	}
	
}