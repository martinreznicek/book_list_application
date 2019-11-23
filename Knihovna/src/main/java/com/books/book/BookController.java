package com.books.book;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.model.Book;
import com.books.book.service.BookService;


@Controller
public class BookController {

	//Dependency injection - no need to create instance by constructor of LoginService here (magic of Spring framework)
	@Autowired
	private BookService service;

	@RequestMapping(value = "/list-books", method = RequestMethod.GET)
	public String showBooksList(ModelMap model) {
		String user = getLoggedInUserName();
		//instead of addAttribute, it is possible to use also put (same as in LoginController)
		model.addAttribute("books", service.retrieveBooks(user));
		return "list-books";
	}

	@RequestMapping(value = "/add-book", method = RequestMethod.GET)
	public String showAddBookPage(ModelMap model) {
		model.addAttribute("book", new Book());
		return "book";
	}

	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
	public String addBook(ModelMap model, @Valid Book book, BindingResult result) {

		if (result.hasErrors())
			return "book";

		service.addBook(getLoggedInUserName(), book.getAuthor(), book.getTitle(),
				book.getYear(), book.getCountry(), book.getGender());
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-books";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	//URL "/update-book" when called with HTTP method GET
	@RequestMapping(value = "/update-book", method = RequestMethod.GET)
	//RequestParam means that this method will request defined parameter when called
	public String showUpdateBookPage(ModelMap model, @RequestParam int id) {
		//Add to the ModelMap the supplied attribute under the supplied name.
		model.addAttribute("book", service.retrieveBook(id));
		return "book";
	}
	
	//URL "/update-book" when called with HTTP method POST
	//The @Valid run the validation process here (when user confirm on web)
	//BindingResult is an interface to reach the result of validation process done with previous parameter @Valid (binding)
	@RequestMapping(value = "/update-book", method = RequestMethod.POST)
	public String updateBook(ModelMap model, @Valid Book book,
			BindingResult result) {
		if (result.hasErrors())
			return "book";
		
		//All books has attribute user, so this command is to set user to new updated book automatically
		book.setUser(getLoggedInUserName());
		service.updateBook(book);

		model.clear();// to prevent request parameter "name" to be passed
		//Redirects means that it won't go directly to the list-books.jsp, but to URL"/list-books"
		//Redirects to list-books and also GET method is used again, so in this case all books are shown. Without redirect, it would not show books, because the method GET would not be called.
		return "redirect:/list-books";
	}

	@RequestMapping(value = "/delete-book", method = RequestMethod.GET)
	public String deleteBook(@RequestParam int id) {
		service.deleteBook(id);

		return "redirect:/list-books";
	}

}