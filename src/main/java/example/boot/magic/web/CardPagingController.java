package example.boot.magic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.Card;
import example.boot.magic.service.CardService;
import example.boot.magic.service.ResultsPage;

@Controller
@RequestMapping(value="cards/paged")
public class CardPagingController {

	@Autowired
	//CardPagingRepository cardRepo;
	CardService cardService;
	
	//protected static final int NUMBER_OF_CARDS_PER_PAGE = 20;
	
	@RequestMapping( value="", method= { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultsPage<Card> getCards(
			@RequestParam(required = false) String cardName,
			@RequestParam(required = false) String cardConvertedManaCost,
			@RequestParam(required = false) String cardPower,
			@RequestParam(required = false) String cardToughness,
			@RequestParam(required = false) String cardColor,
			@RequestParam(required = false) String cardType,
			@RequestParam(required = false) String cardSubType,
			@RequestParam(required = false) String dir,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false) Integer start,
			@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer page) {
			//int pageIndex = (int)start/NUMBER_OF_CARDS_PER_PAGE;
			Long totalCount=cardService.count();
			sort=sort==null?"cardName":sort;
			
			//List<Card> cards = cardRepo.findByCardNameLikeAndCardManaCostLikeAndCardPowerLikeAndCardToughnessLikeAllIgnoreCase
			List<Card> cards = cardService.findBy(
					cardName, cardConvertedManaCost, cardPower, 
					cardToughness, cardColor, cardType,
					cardSubType, dir, sort, start, limit, page);

			return new ResultsPage<Card>(cards,totalCount.intValue());
	}
}
