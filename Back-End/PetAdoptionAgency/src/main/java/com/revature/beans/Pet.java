package com.revature.beans;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Pet")
@Table(name="pet")
public class Pet {

	@Id
	@Column(name="id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="pet_id_seq")
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "sid")
	private Species species;
	
	@ManyToOne
	@JoinColumn(name = "bid")
	private Breed breed;
	
	private String size;
	private int age;
	private String gender;
	private double price;
	private boolean available;
	private byte[] image;
	
	
	
	public Pet() {
		
	}
	

	


	public Pet(int id, String name, Species species, Breed breed, String size, int age, String gender, double price,
			boolean available, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.size = size;
		this.age = age;
		this.gender = gender;
		this.price = price;
		this.available = available;
		this.image = image;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		

	public Species getSpecies() {
		return species;
	}


	public void setSpecies(Species species) {
		this.species = species;
	}


	public Breed getBreed() {
		return breed;
	}


	public void setBreed(Breed breed) {
		this.breed = breed;
	}


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Pet other = (Pet) obj;
		if (age != other.age)
			return false;
		if (available != other.available)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
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
		return "Pet [id=" + id + ", name=" + name + ", species=" + species + ", breed=" + breed + ", size=" + size
				+ ", age=" + age + ", gender=" + gender + ", price=" + price + ", available=" + available + ", image="
				+ Arrays.toString(image) + "]";
	}





	
	

	
	
	
	
	
	
	
	
}
