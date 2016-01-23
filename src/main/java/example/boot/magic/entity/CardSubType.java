package example.boot.magic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MTG_CARD_SUBTYPE")
public class CardSubType implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5298053740075337040L;
	@EmbeddedId
    private CardSubTypeKey cardSubTypeKey;
    
    public CardSubType() {
        
    }
    
    public CardSubType(Integer cardSeq, String subTypeDesc) {
        this();
        CardSubTypeKey cardSubTypeKey = new CardSubTypeKey();
        cardSubTypeKey.setCardSeq(cardSeq);
        cardSubTypeKey.setSubTypeDesc(subTypeDesc);
         this.cardSubTypeKey = cardSubTypeKey;
    }
    
    public static class CardSubTypeKey implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2473377057404264789L;

		@Column(name="MTG_CARD_SEQ")
		private Integer cardSeq;
		
		@Column(name="MTG_SUBTYPE_DESC")
		private String subTypeDesc;
	
		public Integer getCardSeq() {
			return cardSeq;
		}
	
		public void setCardSeq(Integer cardSeq) {
			this.cardSeq = cardSeq;
		}
	
		public String getSubTypeDesc() {
			return subTypeDesc;
		}
	
		public void setSubTypeDesc(String subTypeDesc) {
			this.subTypeDesc = subTypeDesc;
		}
    }
    
	public Integer getCardSeq() {
		return cardSubTypeKey.getCardSeq();
	}
	public String getSubTypeDesc() {
		return cardSubTypeKey.getSubTypeDesc();
	}
}