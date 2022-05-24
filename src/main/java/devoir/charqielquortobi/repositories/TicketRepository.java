package devoir.charqielquortobi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import devoir.charqielquortobi.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

//	@Query("SELECT t FROM ticket t INNER JOIN user_ticket_list ON user_ticket_list.id_user = :id ")
//	public List<Ticket> findTicketsbyUser(long id_user);
}
