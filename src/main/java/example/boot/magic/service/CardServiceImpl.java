package example.boot.magic.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.boot.magic.entity.Card;
import example.boot.magic.entity.CardColor;
import example.boot.magic.entity.CardSubType;
import example.boot.magic.entity.CardType;

@Service


public class CardServiceImpl implements CardService {
	@Autowired
	CardPagingRepository cardRepo;
	

	@Override
	public Long count() {
		return cardRepo.count();
	}
	

	@Override
	public List<Card> findBy(String cardName, String cardConvertedManaCost,
			String cardPower, String cardToughness, String cardColor,
			String cardType, String cardSubType, String dir, String sort,
			Integer start, Integer limit, Integer page) {
		
		cardName = "%"+(cardName==null?"":cardName)+"%";
		cardConvertedManaCost = "%"+(cardConvertedManaCost==null?"":cardConvertedManaCost)+"%";
		cardPower = "%"+(cardPower==null?"":cardPower)+"%";
		cardToughness="%"+(cardToughness==null?"":cardToughness)+"%";
		
		
		
		
		List<Card> cards = new ArrayList<Card>();
		List<Card> allcards = cardRepo.findByCardNameLikeAndCardConvertedManaCostLikeAndCardPowerLikeAndCardToughnessLikeAllIgnoreCase(
				cardName, cardConvertedManaCost, cardPower, cardToughness);//, pageable
		
		
		boolean ascending = "ASC".equalsIgnoreCase(dir);
		
		Comparator<Card> comparator = getComparator(ascending ,sort);
		Collections.sort(allcards,comparator);
		
		for(Card card:allcards){ //filters by color
			if(cards.size()== limit){
				break;
			}
			
			if((hasCardColor(card,cardColor) || cardColor == "") && 
					(hasCardType(card,cardType) || cardType == "") && 
					(hasCardSubType(card,cardSubType) || cardSubType == "")){
				cards.add(card);
			}
		}
		

		return cards;
	}


	//write test case for this
	private boolean hasCardColor(Card card, String cardColorSearch) {
		for (CardColor cardColor:card.getCardColors()){
			if(cardColor.getColorDesc().equals(cardColorSearch)){
				return true;
			}
		}
		return false;
	}

	//write test case for this
	private boolean hasCardType(Card card, String cardTypeSearch) {
		for (CardType cardType:card.getCardTypes()){
			if(cardType.getTypeDesc().equals(cardTypeSearch)){
				return true;
			}
		}
		return false;
	}
	
	//write test case for this
	private boolean hasCardSubType(Card card, String cardSubTypeSearch) {
		for (CardSubType cardSubType:card.getCardSubTypes()){
			if(cardSubType.getSubTypeDesc().equals(cardSubTypeSearch)){
				return true;
			}
		}
		return false;
	}

	private Comparator<Card> getComparator(boolean ascending, final String sort) {
		
		return new Comparator<Card>(){

			@Override
			public int compare(Card o1, Card o2) {
				
				if(sort.equals("cardName")){
					return compareStrings(o1.getCardName(),o2.getCardName());
				}
				
				if(sort.equals("cardConvertedManaCost")){
					return compareStrings(o1.getCardConvertedManaCost(),o2.getCardConvertedManaCost());
				}
				
				if(sort.equals("cardPower")){
					return compareStrings(o1.getCardPower(),o2.getCardPower());
				}
				
				if(sort.equals("cardToughness")){
					return compareStrings(o1.getCardToughness(),o2.getCardToughness());
				}
				
				return 0;
			}
			
		};
	}
	
	public static int compareStrings(String string1, String string2) {
	    String compare1 = string1==null?"":string1;
	    String compare2 = string2==null?"":string2;
	    return compare1.compareTo(compare2);
	}
	
	
	/*private Pageable constructPageSpecification(int pageIndex, String dir, String sortField, int limit) {
    	//PageRequest is starting at zero
    	--pageIndex;
    	Sort sort = new Sort("ASC".equalsIgnoreCase(dir)?Sort.Direction.ASC:Sort.Direction.DESC, sortField);
        Pageable pageSpecification = new PageRequest(pageIndex, limit, sort);
        return pageSpecification;
    }*/

}
