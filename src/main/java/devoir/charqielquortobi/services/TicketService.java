package devoir.charqielquortobi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import devoir.charqielquortobi.models.ticket;

@Service
public interface TicketService {

	public void addTicket(ticket ticket);

	public List<ticket> listTicket();
	
	public Optional<ticket> getTicketById(int ticket_id);
	
	public void deleteTicket(int ticket_id);
	
	public ticket getTicket(int tick);
	
	public List<ticket> listclientTicket(int id_user);
	
	public List<ticket> listDevTicket(int iduser);
}
