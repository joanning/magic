package example.boot.magic.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MTG_SET")

public class Set implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6584091123313761517L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="mtgSetSeq")
	@SequenceGenerator(name = "mtgSetSeq", sequenceName = "MTG_SET_SEQ")
	@Column(name="MTG_SET_SEQ")
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMagicSetDesc() {
		return magicSetDesc;
	}

	public void setMagicSetDesc(String magicSetDesc) {
		this.magicSetDesc = magicSetDesc;
	}

	public Date getMagicSetDate() {
		return magicSetDate;
	}

	public void setMagicSetDate(Date magicSetDate) {
		this.magicSetDate = magicSetDate;
	}

	public Integer getMagicSetCardTotal() {
		return magicSetCardTotal;
	}

	public void setMagicSetCardTotal(Integer magicSetCardTotal) {
		this.magicSetCardTotal = magicSetCardTotal;
	}

	@Column(name="MTG_SET_DESC")
	private String magicSetDesc;
	
	@Column(name="MTG_SET_RELEASE")
	private Date magicSetDate;
	
	@Column(name="MTG_SET_CARD_TOTAL")
	private Integer magicSetCardTotal;

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
		Set other = (Set) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
