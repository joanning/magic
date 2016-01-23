package example.boot.magic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MTG_TYPE")

public class Type implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7665795686026455682L;

	@Id
	@Column(name="MTG_TYPE_DESC")
	private String typeDesc;

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeDesc == null) ? 0 : typeDesc.hashCode());
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
		Type other = (Type) obj;
		if (typeDesc == null) {
			if (other.typeDesc != null)
				return false;
		} else if (!typeDesc.equals(other.typeDesc))
			return false;
		return true;
	}

}
