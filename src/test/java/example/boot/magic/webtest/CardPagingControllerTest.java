package example.boot.magic.webtest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import example.boot.magic.service.CardPagingRepository;
import example.boot.magic.web.CardPagingController;

public class CardPagingControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	CardPagingRepository cardRepo;

	@InjectMocks
	private CardPagingController cardpagingController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);		
		this.mockMvc = MockMvcBuilders.standaloneSetup(
				cardpagingController)
				.build();
		//TestHelper.setAuthentication(null);
	}

	@Test
	public void checkAutowire() {
		assertNotNull(cardpagingController);		
	}
	
	@Test
	public void getCardsPaged() throws Exception {
		MockHttpServletRequestBuilder builder = get("/cards/paged");
		ResultActions resultActions = mockMvc.perform(builder);
		resultActions.andExpect(status().isOk());
		//TestHelper.assertModelAndViewViewName("edit.synonyms", resultActions);
	}
	//At the beginning of your end step, manifest the top card of your library. Sacrifice Whisperwood Elemental: Until end of turn, face-up nontoken creatures you control gain. When this creature dies, manifest the top card of your library.
	@Test
	public void saveCardMapper() throws Exception {
		MockHttpServletRequestBuilder builder = put("cards/12345");
		String content = 
			"{"
				+ "\"id\":\"2\""
				+ ",\"cardName\":\"Whisperwood Elemental\""
				+ ",\"cardManaCost\":\"3GG\""
				+ ",\"cardConvertedManaCost\":\"5\""
				+ ",\"cardText\":\"NOTES TEST\""
				+ ",\"cardPower\":\"4\""
				+ ",\"cardToughness\":\"4\""
				+ ",\"rarityId\":\"4\""
				+ ",\"setId\":\"3\""
				+ ",\"cardNumber\":\"145\""
				+ ",\"artistId\":\"2\""
			+ "}";
		
		builder.contentType(MediaType.APPLICATION_JSON).content(content);
		try {
			mockMvc.perform(builder);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("The request url is not for the same mapper sequence passed in the body"));
			throw e;
		}
	}
	
	
	
	/*
	@Test
	public void testGetCards() {
		fail("Not yet implemented");
	}
	*/
	
	

}
