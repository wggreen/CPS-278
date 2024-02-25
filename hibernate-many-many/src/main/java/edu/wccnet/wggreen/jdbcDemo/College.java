package edu.wccnet.wggreen.jdbcDemo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "college_name")
	private String name;

	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	private List<Campus> campuses = new ArrayList<Campus>();

	public void add(Campus newCampus) {
		campuses.add(newCampus);
		newCampus.setCollege(this);
	}

	public void remove(Campus campus) {
		campuses.remove(campus);
	}

	public List<Campus> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
	}

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

	@ManyToMany
	@JoinTable(name = "college_company", joinColumns = @JoinColumn(name = "college_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
	private List<Company> companies = new ArrayList<Company>();

	public void addCompany(Company company) {
		companies.add(company);
	}

	public void removeCompany(Company company) {
		companies.remove(company);
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
}
