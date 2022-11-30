package az.developia.bookshopping_veliyev_perviz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshopping_veliyev_perviz.dao.BookDAO;
import az.developia.bookshopping_veliyev_perviz.model.Book;

@Controller
public class BookController {
	
	@Autowired
	BookDAO bookDAO;
	
	@GetMapping(path = "/books")  //Bazadan melumati goturub. thymeleaf fastesi ile cedvelde yerlesdirmek
	public String showBooks(Model model) {
		List<Book>books=bookDAO.findAll();
		model.addAttribute("books", books);
		return "books";
	} 
	
	
	@GetMapping(path = "/books/new") // yeni kitab qeydiyyati ucun cedvelin acilmasi 
	public String openNewBookPage(Model model) {
		Book book=new Book();
		model.addAttribute("book", book);
		return "new-book";
	} 
	@PostMapping(path = "/books/new-book-process") // Qeydiyat etdikden sonra datanin bazaya atilmasi
	 public String saveBook(@ModelAttribute(name = "book")Book book,Model model) {
		book.setImage("book.jpg");
		book.setUserName("dea");
		bookDAO.save(book);
		List<Book>books=bookDAO.findAll();
		model.addAttribute("books", books);
			return "books";
		}
	
	
	
	
	@GetMapping(path = "/books/delete/{id}") // id-ye gore delete etmek 
	public String editBook(@PathVariable(name = "id")Integer id,Model model) {
		boolean bookExists=bookDAO.findById(id).isPresent();
		if (bookExists) {
			bookDAO.deleteById(id);
		}
		else {
			
		}
		List<Book>books=bookDAO.findAll();
		model.addAttribute("books", books);
		
		
		return "redirect:/books"; 
	}
	
	
	
	
	
	
	
	
	
	

}
