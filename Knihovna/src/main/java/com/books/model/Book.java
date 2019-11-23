package com.books.model;

import javax.validation.constraints.Size;

public class Book {
	private int id;

	private String user;
	
	private String title;

	@Size(min = 10, message = "Enter atleast 10 Characters.")
	private String author;
	
	private String country;

	private int year;
	private char gender;

	public Book() {
		super();
	}

	public Book(int id, String user, String author, String title, int year, String country,
			char gender) {
		this.id = id;
		this.user = user;
		this.author = author;
		this.title = title;
		this.year = year;
		this.country = country;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Todo [id=%s, user=%s, author=%s, title=%s, targetDate=%s, gender=%s]", id,
				user, author, title, year, gender);
	}

}