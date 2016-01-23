package example.boot.magic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MTG_SUBTYPE")

public class SubType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1242625372215796105L;

	@Id
	@Column(name="MTG_SUBTYPE_DESC")
	private String subtypeDesc;

	public String getSubtypeDesc() {
		return subtypeDesc;
	}

	public void setSubtypeDesc(String subtypeDesc) {
		this.subtypeDesc = subtypeDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subtypeDesc == null) ? 0 : subtypeDesc.hashCode());
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
		SubType other = (SubType) obj;
		if (subtypeDesc == null) {
			if (other.subtypeDesc != null)
				return false;
		} else if (!subtypeDesc.equals(other.subtypeDesc))
			return false;
		return true;
	}

}
