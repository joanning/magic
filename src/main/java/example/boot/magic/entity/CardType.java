package example.boot.magic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MTG_CARD_TYPE")
public class CardType implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1308157930485407522L;
	@EmbeddedId
    private CardTypeKey cardTypeKey;
    
    public CardType() {
        
    }
    
    public CardType(Integer cardSeq, String typeDesc) {
        this();
        CardTypeKey cardTypeKey = new CardTypeKey();
        cardTypeKey.setCardSeq(cardSeq);
        cardTypeKey.setTypeDesc(typeDesc);
         this.cardTypeKey = cardTypeKey;
    }
    
    public static class CardTypeKey implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5996115430418229020L;

		@Column(name="MTG_CARD_SEQ")
		private Integer cardSeq;
		
		@Column(name="MTG_TYPE_DESC")
		private String typeDesc;
	
		public Integer getCardSeq() {
			return cardSeq;
		}
	
		public void setCardSeq(Integer cardSeq) {
			this.cardSeq = cardSeq;
		}
	
		public String getTypeDesc() {
			return typeDesc;
		}
	
		public void setTypeDesc(String typeDesc) {
			this.typeDesc = typeDesc;
		}
    }
    
	public Integer getCardSeq() {
		return cardTypeKey.getCardSeq();
	}
	public String getTypeDesc() {
		return cardTypeKey.getTypeDesc();
	}
}
