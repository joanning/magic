package example.boot.magic.servicetest;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import example.boot.magic.MagicApplication;
import example.boot.magic.entity.Card;
import example.boot.magic.service.CardPagingRepository;
import example.boot.magic.service.CardRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MagicApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class CardPagingRepositoryTest {
	
	@Autowired
	CardPagingRepository cpRepo;
	
	@Autowired
	CardRepository cRepo;
	
	protected static final int NUMBER_OF_CARDS_PER_PAGE = 5;
	
	@SuppressWarnings("unused")
	@Test
	public void testCardPaging() {
		Long count = cRepo.count();
		int lastPageIndex = (int)(count/NUMBER_OF_CARDS_PER_PAGE);
		Page<Card> cards = cpRepo.findAll(new PageRequest(lastPageIndex, count.intValue()));
		Page<Card> cards2 = cpRepo.findAll(constructPageSpecification(lastPageIndex,"DESC","cardPower"));
		//This should return nothing
		List<Card> cards3 = cpRepo.findByCardNameLike("%InG%");
		List<Card> cards4 = cpRepo.findByCardNameLikeIgnoreCase("%InG%");
		//List<Card> cards5 = cpRepo.findByCardNameLikeAndCardConvertedManaCostLikeAndCardPowerLikeAndCardToughnessLikeAllIgnoreCase("%InG%","%","%","%",constructPageSpecification(lastPageIndex,"DESC","cardPower");
		
		List<Card> cards6 = cpRepo.getCard(1);
		
		assertNotNull(cards4);
	}
	
    private Pageable constructPageSpecification(int pageIndex, String dir, String sortField) {
    	Sort sort = new Sort("ASC".equalsIgnoreCase(dir)?Sort.Direction.ASC:Sort.Direction.DESC, sortField);
        Pageable pageSpecification = new PageRequest(pageIndex, NUMBER_OF_CARDS_PER_PAGE, sort);
        return pageSpecification;
    }
    

}
