package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Breed")
@Table(name="breed")
public class Breed {

	@Id
	@Column(name="id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="bname", insertable = false, updatable = false)
	private String bname;
	
	@ManyToOne
	@JoinColumn(name = "sid")
	private Species species;
	
	public Breed() {}
	
	

	public Breed(int id, String bname, Species species) {
		super();
		this.id = id;
		this.bname = bname;
		this.species = species;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	public String getBname() {
		return bname;
	}



	public void setBname(String bname) {
		this.bname = bname;
	}



	public Species getSpecies() {
		return species;
	}



	public void setSpecies(Species species) {
		this.species = species;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + id;
		result = prime * result + ((species == null) ? 0 : species.hashCode());
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
		Breed other = (Breed) obj;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (id != other.id)
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Breed [id=" + id + ", bname=" + bname + ", species=" + species + "]";
	}



	
	
	
}
