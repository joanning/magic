package example.boot.magic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MTG_COLOR")

public class Color implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6730522283673786842L;

	@Id
	@Column(name="MTG_COLOR_DESC")
	private String colorDesc;

	public String getColorDesc() {
		return colorDesc;
	}

	public void setColorDesc(String colorDesc) {
		this.colorDesc = colorDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((colorDesc == null) ? 0 : colorDesc.hashCode());
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
		Color other = (Color) obj;
		if (colorDesc == null) {
			if (other.colorDesc != null)
				return false;
		} else if (!colorDesc.equals(other.colorDesc))
			return false;
		return true;
	}




}
