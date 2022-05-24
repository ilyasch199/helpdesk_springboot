package devoir.charqielquortobi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import devoir.charqielquortobi.models.Utilisateur;
import devoir.charqielquortobi.services.TicketService;
import devoir.charqielquortobi.services.UtilisateurService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UtilisateurService userService;
	
//	@Autowired
//	private TicketService ticketService;

	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("register")
	public String signup() {
		return "register";
	}
	
	@GetMapping("tickets")
	public String tickets() {
		return "tickets";
	}
	
	@PostMapping("signup")
	public ModelAndView signUp(Utilisateur user) {
		ModelAndView mv = new ModelAndView("/tickets");
		userService.save(user);
//		mv.addObject("ticketList", ticketService.listTicket());
		return mv;
	}



}
