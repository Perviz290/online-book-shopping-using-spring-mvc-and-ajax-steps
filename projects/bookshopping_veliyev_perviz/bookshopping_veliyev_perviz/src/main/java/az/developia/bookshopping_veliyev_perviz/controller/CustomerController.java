package az.developia.bookshopping_veliyev_perviz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.bookshopping_veliyev_perviz.config.MySession;
import az.developia.bookshopping_veliyev_perviz.dao.BookDAO;
import az.developia.bookshopping_veliyev_perviz.model.Book;


@Controller
public class CustomerController {
	
	@Autowired
	BookDAO bookDAO;
	
	@Autowired
	MySession mySession;
	
	

	@GetMapping(path = "/customer")  //Bazadan melumati goturub. thymeleaf fastesi ile alici sehfesinde gostermek 
	public String showCustomerPage(Model model) {
		List<Book>books=bookDAO.findAll();
		model.addAttribute("books", books);
		System.out.println(mySession.getUsername());	
		return "customer";
	} 	
	
	
	
	
}












