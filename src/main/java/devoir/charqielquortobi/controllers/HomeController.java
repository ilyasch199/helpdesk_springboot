package devoir.charqielquortobi.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import devoir.charqielquortobi.models.ticket;
import devoir.charqielquortobi.models.utilisateur;
import devoir.charqielquortobi.repositories.TicketRepository;
import devoir.charqielquortobi.repositories.UtilisateurRepository;
import devoir.charqielquortobi.services.TicketService;
import devoir.charqielquortobi.services.UtilisateurService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UtilisateurService userService;
	
	@Autowired
	private UtilisateurRepository userrepo;
	
	@Autowired
	private TicketRepository ticketrepo;

	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("tickets")
	public String tickets() {
		return "tickets";
	}
	
	@GetMapping("home")
	public String home() {
		return "homepage.html";
	}
	
	@GetMapping("registersuccess")
	public String registersuccess() {
		return "login";
	}
	
	@GetMapping("register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new utilisateur());     
	    return "register";
	}
	
	@PostMapping("process_register")
	public String signUp(utilisateur user) {
		user.setEnabled(true);
		user.setRole("client");
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    userrepo.save(user);
		return "login";
	}

	@GetMapping("ticketsuser")
	public String listTickets(Model model) {
		model.addAttribute("tickets", userService.getClientTickets(idAuth()));
		return "ticketsclient";
	}
	
	private int idAuth(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        utilisateur user = userService.FindByName(auth.getName());
        return user.getId_user();
    }

	 @GetMapping("addticket")
		public String ticketadd(Model model) {
		    model.addAttribute("ticket", new ticket());     
		    return "addticket";
		}
	 
	@PostMapping("add_ticket")
	public String addticket(ticket ticket) {
		ticket.setDate(java.sql.Date.valueOf(LocalDate.now()));
		ticket.setId_user(idAuth());
		ticketrepo.save(ticket);
		return "redirect:/ticketsuser";
	}	 
	
	 @GetMapping("updateprofil")
		public String updateprofil(Model model) {
		 	utilisateur u = userrepo.findById(idAuth()).get();
//		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		    String encodedPassword = passwordEncoder.encode(u.getPassword());
//		    u.setPassword(encodedPassword);
		    model.addAttribute("user", u);
		    return "updateprofile";
		}
	 
	@PostMapping("update_user")
	public String update_user(@RequestParam(value = "nom",required=false) String nom ,@RequestParam(value = "email",required=false) String email ,
			@RequestParam(value = "password",required=false) String password ,@RequestParam(value = "phone_number",required=false) String phone_number ) {
		utilisateur u = userrepo.findById(idAuth()).get();
		if (password != "") {
		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(password);
		    u.setPassword(encodedPassword);
		}
		u.setEmail(email);
		u.setNom(nom);
		u.setPhone_number(phone_number);
		userrepo.save(u);
		return "redirect:/login";
		}

}
