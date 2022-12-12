package az.developia.bookshopping_veliyev_perviz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping_veliyev_perviz.dao.BookDAO;
import az.developia.bookshopping_veliyev_perviz.model.Book;



@RestController
@RequestMapping(path = "/rest/books")
public class BookRestController {
	
	@Autowired
	private BookDAO bookDAO;
	
	@GetMapping 
	public List<Book>findAll(){
		return bookDAO.findAll();	
	}
	
	
	@GetMapping(path = "/{id}")  // id hansi yazsan onu obyekt seklinde qaytaracaq
	public Book findById(@PathVariable(name = "id") Integer id) {
		return bookDAO.findById(id).get();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}











