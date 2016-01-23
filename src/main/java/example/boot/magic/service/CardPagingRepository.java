package example.boot.magic.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import example.boot.magic.entity.Card;

public interface CardPagingRepository extends PagingAndSortingRepository<Card, Integer> {
		List<Card> findByCardNameLikeIgnoreCase(String cardName, Pageable pageable);
		List<Card> findByCardName(String cardName);
		List<Card> findByCardNameLike(String cardName);
		List<Card> findByCardNameLikeIgnoreCase(String cardName);
		List<Card> findByCardNameLikeAndCardConvertedManaCostLikeAndCardPowerLikeAndCardToughnessLikeAllIgnoreCase(
				String cardName, String cardConvertedManaCost,
				String cardPower, String cardToughness);//, Pageable pageable
		
		@Query(value="select c.* from mtg_card c where mtg_card_seq = :cardSeq",nativeQuery = true)
		List<Card> getCard(@Param("cardSeq") Integer cardSeq);
}
