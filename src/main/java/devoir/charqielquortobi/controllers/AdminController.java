package devoir.charqielquortobi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import devoir.charqielquortobi.services.UtilisateurService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	private TicketRepository ticketrepo;
	
	@Autowired
	private UtilisateurRepository userrepo;
	
	@Autowired
	private UtilisateurService userService;
	
	@GetMapping("ticketsnot")
	public String listTickets(Model model) {
		model.addAttribute("ticket", ticketrepo.getNotAffected());
		model.addAttribute("devs", userrepo.getDevs());
		return "admin/ticketsnot";
	}
	
	@PostMapping("attribuer")
	public String attribuer(@RequestParam(value = "idDev",required=false) int idDev ,@RequestParam(value="idtic",required=false) int idtic) {
		userService.affecter(idtic, idDev);
		return "redirect:/admin/ticketsnot";
	}
	
	@GetMapping("ticketsatt")
	public String listTicketsatt(Model model) {
		model.addAttribute("ticket", ticketrepo.getAffected());
		List <ticket> t = ticketrepo.getAffected();
		List <utilisateur> u = new ArrayList<utilisateur>();
		for(ticket d : t) {
			u.add(userrepo.findById(d.getAttribue_a()).get());
		}			
		model.addAttribute("devs", u);
		return "admin/ticketsatt";
	}
	
	@GetMapping("users")
	public String listUsers(Model model) {
		model.addAttribute("user", new utilisateur());
		model.addAttribute("users", userrepo.getUsers());
		return "admin/userslist";
	}
	
	@PostMapping("userupdate")
	public String enabledisable(@RequestParam(value = "idus",required=false) int idus ,@RequestParam(value="disable",required=false) String disable
			,@RequestParam(value="enable",required=false) String enable ,@RequestParam(value="developpeur",required=false) String developpeur 
			,@RequestParam(value="client",required=false) String client ,@RequestParam(value="delete",required=false) String delete) {
		utilisateur u = userrepo.findById(idus).get();
		if (disable != null){
		    u.setEnabled(false);
		    userrepo.save(u);
		}
		else if (enable != null){
			u.setEnabled(true);
			userrepo.save(u);
		}
		else if (developpeur != null){
			u.setRole("developpeur");
			userrepo.save(u);
		}
		else if (client != null){
			u.setRole("client");
			userrepo.save(u);
		}
		else if (delete != null){
			userrepo.deleteById(idus);
		}
		return "redirect:/admin/users";
	}
}
