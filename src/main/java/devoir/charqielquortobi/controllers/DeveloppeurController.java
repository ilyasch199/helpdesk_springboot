package devoir.charqielquortobi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import devoir.charqielquortobi.models.ticket;
import devoir.charqielquortobi.models.utilisateur;
import devoir.charqielquortobi.repositories.TicketRepository;
import devoir.charqielquortobi.services.UtilisateurService;

@Controller
@RequestMapping("/dev/")
public class DeveloppeurController {
	
	@Autowired
	private UtilisateurService userService;
	
	@Autowired
	private TicketRepository ticketrepo;
	
	@GetMapping("ticketsatt")
	public String listTickets(Model model) {
		model.addAttribute("ticket", userService.getDevsTickets(idAuth()));
		return "dev/ticketsattr";
	}
	
	@GetMapping("ticketsattres")
	public String listTicketsres(Model model) {
		model.addAttribute("ticket", ticketrepo.getByDevUserRes(idAuth()));
		return "dev/ticketsattres";
	}
	
	@PostMapping("update")
	public String attribuer(@RequestParam(value = "sta",required=false) int sta ,@RequestParam(value="idtic",required=false) int idtic) {
		ticket t = ticketrepo.findById(idtic).get();
		t.setStatus(sta);
		ticketrepo.save(t);
		return "redirect:/dev/ticketsatt";
	}
	
	private int idAuth(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        utilisateur user = userService.FindByName(auth.getName());
        return user.getId_user();
    }
}
