package edu.wccnet.wggreen.jdbcDemo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private CollegeAddress collegeAddress;

	public CollegeAddress getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(CollegeAddress collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	@Column(name = "college_name")
	private String name;

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}

	public College(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public College() {

	}
}
