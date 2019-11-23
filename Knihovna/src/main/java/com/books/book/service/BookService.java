package com.books.book.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.books.model.Book;

@Service
public class BookService {
	private static List<Book> books = new ArrayList<Book>();
	private static int bookCount = 3;

	static {
		books.add(new Book(1, "admin", "Bulgakov, Michail", "Mistr a Marketka", 2007, "Rusko",
				'M'));
		books.add(new Book(2, "admin", "Nemcova, Bozena", "Babicka", 2001, "Cesko", 'F'));
		books.add(new Book(3, "admin", "Murakami, Haruki", "1Q84",2009, "Japonsko",
				'M'));
	}

	public List<Book> retrieveBooks(String user) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getUser().equals(user))
				filteredBooks.add(book);
		}
		return filteredBooks;
	}

	public Book retrieveBook(int id) {
		for (Book book : books) {
			if (book.getId() == id)
				return book;
		}
		return null;
	}

	public void updateBook(Book book) {
		books.remove(book);
		books.add(book);
	}

	public void addBook(String name, String author, String title, int year, String country,
			char gender) {
		books.add(new Book(bookCount++, name, author, title, year, country, gender));
	}

	public void deleteBook(int id) {
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
			}
		}
	}
}