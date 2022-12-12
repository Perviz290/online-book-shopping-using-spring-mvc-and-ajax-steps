package az.developia.bookshopping_veliyev_perviz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = {"/home","/"})
	public String showHomePage() {
		return "home";
	}
	
	
	
	
	
}
