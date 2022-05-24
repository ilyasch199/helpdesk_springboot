package devoir.charqielquortobi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import devoir.charqielquortobi.models.Ticket;
import devoir.charqielquortobi.repositories.TicketRepository;

public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void addTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> listTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public Optional<Ticket> getTicketById(long ticket_id) {
		return ticketRepository.findById(ticket_id);
	}


	@Override
	public void deleteTicket(long ticket_id) {
		ticketRepository.deleteById(ticket_id);
	}


}
