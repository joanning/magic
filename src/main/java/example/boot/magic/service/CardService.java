package example.boot.magic.service;

import java.util.List;

import example.boot.magic.entity.Card;



public interface CardService {

	Long count();

	List<Card> findBy(String cardName, String cardConvertedManaCost, String cardPower,
			String cardToughness, String cardColor, String cardType,
			String cardSubType, String dir, String sort, Integer start,
			Integer limit, Integer page);
}