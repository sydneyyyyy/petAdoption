package com.revature.beans;

import java.sql.*;

import javax.persistence.*;




@Entity(name="Application")
@Table(name="application")
public class Application {
	
	@Id
	@Column(name="id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Integer pid;
	
	private Integer cid;
	
	private Date subdate;
	
	private Boolean bsupapproval;
	
	private Boolean secondapproval;
	
	private String status;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Pet pet;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Customer customer;
	
	public Application() {}

	public Application(int id, Integer pid, Integer cid, Date subdate, Boolean bsupapproval, Boolean secondapproval,
			String status, Pet pet, Customer customer) {
		super();
		this.id = id;
		this.pid = pid;
		this.cid = cid;
		this.subdate = subdate;
		this.bsupapproval = bsupapproval;
		this.secondapproval = secondapproval;
		this.status = status;
		this.pet = pet;
		this.customer = customer;
	}

	public Application(int id, Integer pid, Integer cid) {
		super();
		this.id = id;
		this.pid = pid;
		this.cid = cid;
	}

	public Application(int id, Integer pid, Integer cid, Date subdate, Boolean bsupapproval, Boolean secondapproval,
			String status) {
		super();
		this.id = id;
		this.pid = pid;
		this.cid = cid;
		this.subdate = subdate;
		this.bsupapproval = bsupapproval;
		this.secondapproval = secondapproval;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Date getSubdate() {
		return subdate;
	}

	public void setSubdate(Date subdate) {
		this.subdate = subdate;
	}

	public Boolean getBsupapproval() {
		return bsupapproval;
	}

	public void setBsupapproval(Boolean bsupapproval) {
		this.bsupapproval = bsupapproval;
	}

	public Boolean getSecondapproval() {
		return secondapproval;
	}

	public void setSecondapproval(Boolean secondapproval) {
		this.secondapproval = secondapproval;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bsupapproval == null) ? 0 : bsupapproval.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((pet == null) ? 0 : pet.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((secondapproval == null) ? 0 : secondapproval.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subdate == null) ? 0 : subdate.hashCode());
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
		Application other = (Application) obj;
		if (bsupapproval == null) {
			if (other.bsupapproval != null)
				return false;
		} else if (!bsupapproval.equals(other.bsupapproval))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (pet == null) {
			if (other.pet != null)
				return false;
		} else if (!pet.equals(other.pet))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (secondapproval == null) {
			if (other.secondapproval != null)
				return false;
		} else if (!secondapproval.equals(other.secondapproval))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subdate == null) {
			if (other.subdate != null)
				return false;
		} else if (!subdate.equals(other.subdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", pid=" + pid + ", cid=" + cid + ", subdate=" + subdate + ", bsupapproval="
				+ bsupapproval + ", secondapproval=" + secondapproval + ", status=" + status + ", pet=" + pet
				+ ", customer=" + customer + "]";
	}
	
	

}
