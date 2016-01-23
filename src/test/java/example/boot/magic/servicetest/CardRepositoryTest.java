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
import example.boot.magic.entity.Card;
import example.boot.magic.entity.CardColor;
import example.boot.magic.entity.CardSubType;
import example.boot.magic.entity.CardType;
import example.boot.magic.service.CardRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MagicApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class CardRepositoryTest {
	
	@Value("${local.server.port}")
	private int port;
	
	@Autowired
	CardRepository repo;
	
	@Test
	public void testCard() {
		Iterable<Card> cards = repo.findAll();
		assertNotNull(cards);
		CardColor cardColor = cards.iterator().next().getCardColors().get(0);
		assertNotNull(cardColor);
		
		cards = repo.findAll();
		assertNotNull(cards);
		CardType cardType = cards.iterator().next().getCardTypes().get(0);
		assertNotNull(cardType);
		
		cards = repo.findAll();
		assertNotNull(cards);
		CardSubType cardSubType = cards.iterator().next().getCardSubTypes().get(0);
		assertNotNull(cardSubType);
	}
	
	@Test
	public void saveCard() {
		/*
		Iterable<Card> cards = repo.findAll();
		assertNotNull(cards);
		Card card = cards.iterator().next();
		CardColor cardColor = new CardColor(card.getId(),"Blue");
		card.getCardColors().add(cardColor);
		repo.save(card);
		cards = repo.findAll();
		assertNotNull(cards);
		Iterator<Card> iterator = cards.iterator();
		Card next = iterator.next();
		CardColor cardColor1 = next.getCardColors().get(0);
		assertNotNull(cardColor1);
		CardColor cardColor2 = next.getCardColors().get(1);
		assertNotNull(cardColor2);
		*/
		/*
		Iterable<Card> cards = repo.findAll();
		assertNotNull(cards);
		Card card = cards.iterator().next();
		CardType cardType = new CardType(card.getId(),"Artifact");
		card.getCardTypes().add(cardType);
		repo.save(card);
		cards = repo.findAll();
		assertNotNull(cards);
		Iterator<Card> iterator = cards.iterator();
		Card next = iterator.next();
		CardType cardType1 = next.getCardTypes().get(0);
		assertNotNull(cardType1);
		CardType cardType2 = next.getCardTypes().get(1);
		assertNotNull(cardType2);
		*/
		/*
		Iterable<Card> cards = repo.findAll();
		assertNotNull(cards);
		Card card = cards.iterator().next();
		CardSubType cardSubType = new CardSubType(card.getId(),"Rogue");
		card.getCardSubTypes().add(cardSubType);
		repo.save(card);
		cards = repo.findAll();
		assertNotNull(cards);
		Iterator<Card> iterator = cards.iterator();
		Card next = iterator.next();
		CardSubType cardSubType1 = next.getCardSubTypes().get(0);
		assertNotNull(cardSubType1);
		CardSubType cardSubType2 = next.getCardSubTypes().get(1);
		assertNotNull(cardSubType2);
		*/
	}

}
