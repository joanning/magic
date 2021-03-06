package example.boot.magic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MTG_RARITY")

public class Rarity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7874767364298532437L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="mtgRaritySeq")
	@SequenceGenerator(name = "mtgRaritySeq", sequenceName = "MTG_RARITY_SEQ")
	@Column(name="MTG_RARITY_SEQ")
	private Integer id;
	
	@Column(name="MTG_RARITY_DESC")
	private String rarityDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRarityDesc() {
		return rarityDesc;
	}

	public void setRarityDesc(String rarityDesc) {
		this.rarityDesc = rarityDesc;
	}

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
		Rarity other = (Rarity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
