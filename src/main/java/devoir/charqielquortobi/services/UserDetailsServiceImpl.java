package devoir.charqielquortobi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devoir.charqielquortobi.models.ticket;
import devoir.charqielquortobi.models.utilisateur;
import devoir.charqielquortobi.repositories.*;

@Service
@Transactional
public class UserDetailsServiceImpl implements UtilisateurService {
 
	@Autowired
	private UtilisateurRepository userRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public utilisateur FindByName(String name) {
		return userRepository.getUserByUsername(name);
	}

	@Override
	public void save(utilisateur user) {

	}

	@Override
	public void update(utilisateur user) {
		utilisateur u = userRepository.findById(user.getId_user()).get();
		if (u != null)
		userRepository.save(user);
	}

	@Override
	public List<utilisateur> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(int id_user) {
		userRepository.deleteById(id_user);
	}

	@Override
	public List<utilisateur> getDevs() {
		return userRepository.getDevs();
	}

	@Override
	public utilisateur FintById(int idUser) {
		if(userRepository.existsById(idUser))
			return userRepository.findById(idUser).get();
		else
			return null;
	}

	@Override
	public List<ticket> getClientTickets(int idUser) {
		return ticketRepository.getByClientUser(idUser);
	}
	
	@Override
	public List<ticket> getDevsTickets(int idUser) {
		return ticketRepository.getByDevUser(idUser);
	}

	@Override
	public void affecter(int idticket, int idDev) {
		utilisateur dev = userRepository.findById(idDev).get();
		ticket t = ticketRepository.findById(idticket).get();
		t.setAttribue_a(dev.getId_user());
		ticketRepository.save(t);
	}

	

}
