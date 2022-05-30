package devoir.charqielquortobi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import devoir.charqielquortobi.models.ticket;

public interface TicketRepository extends JpaRepository<ticket, Integer>{

	@Query("Select t from ticket t where t.attribue_a = :id_user and t.status = 0")
	List<ticket> getByDevUser(@Param("id_user") int id_user);
	
	@Query("Select t from ticket t where t.attribue_a = :id_user and t.status = 1")
	List<ticket> getByDevUserRes(@Param("id_user") int id_user);
	
	@Query("Select t from ticket t where t.id_user = :id_user")
	List<ticket> getByClientUser(@Param("id_user") int id_user);
	
	@Query("Select t from ticket t where t.attribue_a = 0")
	List<ticket> getNotAffected();
	
	@Query("Select t from ticket t where t.attribue_a != 0")
	List<ticket> getAffected();
}