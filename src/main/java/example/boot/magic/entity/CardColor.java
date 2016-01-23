package example.boot.magic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MTG_CARD_COLOR")
public class CardColor implements Serializable {
	private static final long serialVersionUID = -9151947856025262212L;

    @EmbeddedId
    private CardColorKey cardColorKey;
    
    public CardColor() {
        
    }
    
    public CardColor(Integer cardSeq, String colorDesc) {
        this();
        CardColorKey cardColorKey = new CardColorKey();
        cardColorKey.setCardSeq(cardSeq);
        cardColorKey.setColorDesc(colorDesc);
         this.cardColorKey = cardColorKey;
    }
    
    public static class CardColorKey implements Serializable {
		private static final long serialVersionUID = 7344639664933733252L;

		@Column(name="MTG_CARD_SEQ")
		private Integer cardSeq;
		
		@Column(name="MTG_COLOR_DESC")
		private String colorDesc;
	
		public Integer getCardSeq() {
			return cardSeq;
		}
	
		public void setCardSeq(Integer cardSeq) {
			this.cardSeq = cardSeq;
		}
	
		public String getColorDesc() {
			return colorDesc;
		}
	
		public void setColorDesc(String colorDesc) {
			this.colorDesc = colorDesc;
		}
    }
    
	public Integer getCardSeq() {
		return cardColorKey.getCardSeq();
	}
	public String getColorDesc() {
		return cardColorKey.getColorDesc();
	}
}