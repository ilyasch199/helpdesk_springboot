package devoir.charqielquortobi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import devoir.charqielquortobi.models.Ticket;

@Service
public interface TicketService {


	public void addTicket(Ticket ticket);

	public List<Ticket> listTicket();
	
	public Optional<Ticket> getTicketById(long ticket_id);
	
	public void deleteTicket(long ticket_id);

}
