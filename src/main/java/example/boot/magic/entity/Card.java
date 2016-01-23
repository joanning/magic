package example.boot.magic.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MTG_CARD")
public class Card implements Serializable {

	/**
	 *  This is the main entity used in the magic card database
	 */
	private static final long serialVersionUID = 4334484633304154427L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="mtgCardSeq")
	@SequenceGenerator(name = "mtgCardSeq", sequenceName = "MTG_CARD_SEQ")
	@Column(name="MTG_CARD_SEQ")
	private Integer id;
	
	@Column(name="MTG_CARD_NAME")
	private String cardName;
	
	@Column(name="MTG_MANA_COST")
	private String cardManaCost;
	
	@Column(name="MTG_CONVERTED_MANA_COST")
	private String cardConvertedManaCost;
	
	@Column(name="MTG_CARD_TEXT")
	private String cardText;
	
	@Column(name="MTG_CARD_POWER")
	private String cardPower;
	
	@Column(name="MTG_CARD_TOUGHNESS")
	private String cardToughness;
	
	@Column(name="MTG_RARITY_SEQ")
	private Integer rarityId;
	
	@Column(name="MTG_SET_SEQ")
	private Integer setId;
	
	@Column(name="MTG_CARD_NUMBER")
	private Integer cardNumber;
	
	@Column(name="MTG_ARTIST_SEQ")
	private Integer artistId;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval=true, cascade = CascadeType.ALL)
    @JoinColumn(name="MTG_CARD_SEQ") // join column is in table for Color
    private List<CardColor> cardColors;
    public List<CardColor> getCardColors() {return cardColors;}

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval=true, cascade = CascadeType.ALL)
    @JoinColumn(name="MTG_CARD_SEQ") // join column is in table for Color
    private List<CardType> cardTypes;
    public List<CardType> getCardTypes() {return cardTypes;}
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval=true, cascade = CascadeType.ALL)
    @JoinColumn(name="MTG_CARD_SEQ") // join column is in table for Color
    private List<CardSubType> cardSubTypes;
    public List<CardSubType> getCardSubTypes() {return cardSubTypes;}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardManaCost() {
		return cardManaCost;
	}

	public void setCardManaCost(String cardManaCost) {
		this.cardManaCost = cardManaCost;
	}

	public String getCardConvertedManaCost() {
		return cardConvertedManaCost;
	}

	public void setCardConvertedManaCost(String cardConvertedManaCost) {
		this.cardConvertedManaCost = cardConvertedManaCost;
	}

	public String getCardText() {
		return cardText;
	}

	public void setCardText(String cardText) {
		this.cardText = cardText;
	}

	public String getCardPower() {
		return cardPower;
	}

	public void setCardPower(String cardPower) {
		this.cardPower = cardPower;
	}

	public String getCardToughness() {
		return cardToughness;
	}

	public void setCardToughness(String cardToughness) {
		this.cardToughness = cardToughness;
	}

	public Integer getRarityId() {
		return rarityId;
	}

	public void setRarityId(Integer rarityId) {
		this.rarityId = rarityId;
	}

	public Integer getSetId() {
		return setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
	
	
}
