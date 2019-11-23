package com.books.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.book.service.BookService;
import com.books.model.Book;



@RestController
public class BookRestController {
	@Autowired
	BookService service;
	
	@RequestMapping(path="/books")
	public List<Book> retrieveAllBooks(){
		List<Book> list = service.retrieveBooks("admin");
		return list;
	}
	
	@RequestMapping(path="/books/{id}")
	public Book retrieveBook(@PathVariable int id){
		Book book = service.retrieveBook(id);
		return book;
	}
}
