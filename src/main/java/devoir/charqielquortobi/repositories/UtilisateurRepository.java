package devoir.charqielquortobi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import devoir.charqielquortobi.models.utilisateur;

public interface UtilisateurRepository extends JpaRepository<utilisateur, Integer> {
 
    @Query("SELECT u FROM utilisateur u WHERE u.nom = :nom")
    public utilisateur getUserByUsername(@Param("nom") String username);
    
	@Query("SELECT u FROM utilisateur u WHERE u.role = 'developpeur'")
	public List<utilisateur> getDevs();
	
	@Query("SELECT u FROM utilisateur u WHERE u.role = 'developpeur' or u.role = 'client'")
	public List<utilisateur> getUsers();
}
