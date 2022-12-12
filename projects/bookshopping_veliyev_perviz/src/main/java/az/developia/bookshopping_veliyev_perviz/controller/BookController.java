package az.developia.bookshopping_veliyev_perviz.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshopping_veliyev_perviz.config.MySession;
import az.developia.bookshopping_veliyev_perviz.dao.BookDAO;
import az.developia.bookshopping_veliyev_perviz.model.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private MySession mySession;
	
	
	@GetMapping(path = "/books")  //Bazadan melumati goturub. thymeleaf fastesi ile cedvelde yerlesdirmek
	public String showBooks(Model model) {
		//List<Book>books=bookDAO.findAll();
		List<Book>books=bookDAO.findAllByUsername(mySession.getUsername());  // User-e gore book cedvelini gostermek 
		model.addAttribute("books", books);
		return "books";
	} 
	
	
	@GetMapping(path = "/books/new") // yeni kitab qeydiyyati ucun cedvelin acilmasi 
	public String openNewBookPage(Model model) {
		Book book=new Book();
		model.addAttribute("book", book);
		model.addAttribute("header", "Yeni Kitab");
		return "new-book";
	} 
	@PostMapping(path = "/books/new-book-process") // Qeydiyat etdikden sonra datanin bazaya atilmasi
	 public String saveBook(@Valid @ModelAttribute(name = "book")Book book,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new-book";
		}
		book.setImage("book.jpg");
		book.setUsername(mySession.getUsername());
		bookDAO.save(book);
		List<Book>books=bookDAO.findAll();
		model.addAttribute("books", books);
			return "redirect:/books";
		}
	
	
	
	
	@GetMapping(path = "/books/delete/{id}") // id-ye gore delete etmek 
	public String deleteBook(@PathVariable(name = "id")Integer id,Model model) {
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
	
	@GetMapping(path = "/books/edit/{id}") // kitab redaktesi 
	public String editBook(@PathVariable(name = "id")Integer id,Model model) {
		Optional<Book>bookOptional=bookDAO.findById(id);
		boolean bookExists=bookOptional.isPresent();
		Book book=new Book();
		if (bookExists) {
			book=bookOptional.get();
		}
		else {
			
		}
		model.addAttribute("book", book);
		model.addAttribute("header", "Kitab redaktesi");
		
		return "new-book"; 
	}
	
	
	
	
	
	
	
	

}
