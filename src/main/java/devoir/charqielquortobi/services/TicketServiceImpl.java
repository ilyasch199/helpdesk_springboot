package devoir.charqielquortobi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import devoir.charqielquortobi.models.ticket;
import devoir.charqielquortobi.repositories.TicketRepository;

@Component
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void addTicket(ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public List<ticket> listTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public Optional<ticket> getTicketById(int ticket_id) {
		return ticketRepository.findById(ticket_id);
	}

	@Override
	public void deleteTicket(int ticket_id) {
		ticketRepository.deleteById(ticket_id);
	}

	@Override
	public ticket getTicket(int tick) {
		return ticketRepository.findById(tick).get();
	}

	@Override
	public List<ticket> listclientTicket(int id_user) {
		return ticketRepository.getByClientUser(id_user);
	}

	@Override
	public List<ticket> listDevTicket(int iduser) {
		return ticketRepository.getByDevUser(iduser);
	}


}
