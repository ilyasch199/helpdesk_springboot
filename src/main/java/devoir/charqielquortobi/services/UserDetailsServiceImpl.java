package devoir.charqielquortobi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import devoir.charqielquortobi.models.Ticket;
import devoir.charqielquortobi.models.Utilisateur;
import devoir.charqielquortobi.repositories.UtilisateurRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UtilisateurService {
 
	@Autowired
	private UtilisateurRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Utilisateur FindByName(String name) {
		return userRepository.getUserByUsername(name);
	}

	@Override
	public void save(Utilisateur user) {
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void update(Utilisateur user) {
		List<Ticket> ticketlist1 = user.getTicketslist();
		List<Ticket> ticketlist = (userRepository.getUserByUsername(user.getEmail())).getTicketslist();
		ticketlist1.addAll(ticketlist);
		user.setTicketslist(ticketlist1);
		userRepository.save(user);
	}

	@Override
	public List<Utilisateur> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(long id_user) {
		userRepository.deleteById(id_user);
	}



}
