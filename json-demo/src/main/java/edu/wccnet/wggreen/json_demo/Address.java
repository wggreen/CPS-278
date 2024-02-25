package edu.wccnet.wggreen.json_demo;

public class Address {
	private String street;
	private String city;
	private int zip;

	private Address() {

	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zip=" + zip + "]";
	}

	public Address(String street, String city, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

}
