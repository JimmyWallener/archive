package se.gritacademy.model;

public class Model {
	
	private static String name,surname,address,zipcode,city,country;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Model.name = name;
	}

	public static String getSurname() {
		return surname;
	}

	public static void setSurname(String surname) {
		Model.surname = surname;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		Model.address = address;
	}

	public static String getZipcode() {
		return zipcode;
	}

	public static void setZipcode(String zipcode) {
		Model.zipcode = zipcode;
	}

	public static String getCity() {
		return city;
	}

	public static void setCity(String city) {
		Model.city = city;
	}

	public static String getCountry() {
		return country;
	}

	public static void setCountry(String country) {
		Model.country = country;
	}
}
