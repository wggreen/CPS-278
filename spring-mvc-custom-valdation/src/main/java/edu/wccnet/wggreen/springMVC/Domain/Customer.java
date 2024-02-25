package edu.wccnet.wggreen.springMVC.Domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import edu.wccnet.wggreen.springMVC.Validation.CourseName;

public class Customer {

	@NotBlank(message = "field is requried")
	@Size(min = 4, message = "name has to be at least 4 characters long")
	private String name;

	@Min(value = 18, message = "must be 18 or older")
	@NotNull(message = "field is required")
	private int age;

	@Pattern(regexp = "^[0-9]{5}", message = "zipcode should be 5 digits")
	@NotBlank(message = "field is requried")
	private String zipCode;

	@CourseName(value = {"ENG", "BIO"}, message = "course has to start with {value}")
	private String favoriteCourse;

	public String getFavoriteCourse() {
		return favoriteCourse;
	}

	public void setFavoriteCourse(String favoriteCourse) {
		this.favoriteCourse = favoriteCourse;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
