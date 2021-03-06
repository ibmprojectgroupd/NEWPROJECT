package onlineShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import onlineShop.model.Product;
import onlineShop.service.ProductService;

@Controller
public class HomePageController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView sayIndex() {
		List<Product> products = productService.getAllProducts();
		return new ModelAndView("index", "products", products);
	}

	@RequestMapping("/login")
	public String login(Model model,@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and Password");
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model) {	
			model.addAttribute("login", "You have logged out successfully");
		return "login";
	}

	@GetMapping("/aboutus")
	public String sayAbout() {
		return "aboutUs";
	}
	
	@GetMapping("/contactus")
	public String sayContact() {
		return "contactUs";
	}
		
}

