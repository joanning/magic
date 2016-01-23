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
@Table(name="MTG_ARTIST")

public class Artist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5737890875519702544L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="mtgArtistSeq")
	@SequenceGenerator(name = "mtgArtistSeq", sequenceName = "MTG_ARTIST_SEQ")
	@Column(name="MTG_ARTIST_SEQ")
	private Integer id;
	
	@Column(name="MTG_ARTIST_LAST_NAME")
	private String artistLastName;
	
	@Column(name="MTG_ARTIST_FIRST_NAME")
	private String artistFirstName;

	public String getArtistLastName() {
		return artistLastName;
	}

	public void setArtistLastName(String artistLastName) {
		this.artistLastName = artistLastName;
	}

	public String getArtistFirstName() {
		return artistFirstName;
	}

	public void setArtistFirstName(String artistFirstName) {
		this.artistFirstName = artistFirstName;
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
		Artist other = (Artist) obj;
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



}
