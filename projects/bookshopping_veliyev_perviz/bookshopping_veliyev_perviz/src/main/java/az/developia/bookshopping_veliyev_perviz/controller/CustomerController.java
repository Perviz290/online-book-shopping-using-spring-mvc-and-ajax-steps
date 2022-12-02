package az.developia.bookshopping_veliyev_perviz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	@GetMapping(path = "/customer")  
	public String showCustomerPage() {
		
		return "customer";
	} 
	
	
	
	
}
