package az.developia.bookshopping_veliyev_perviz.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomerController {

	@GetMapping(path = "/customer")  
	public String showCustomerPage(Model model) {
		ArrayList<String>books=new ArrayList<>();
		for (int i = 1; i <=100; i++) {
			books.add("");
			}
		model.addAttribute("books", books);
		return "customer";
	} 
	
	
	
	
}
