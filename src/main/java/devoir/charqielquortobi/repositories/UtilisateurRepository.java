package devoir.charqielquortobi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import devoir.charqielquortobi.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
 
    @Query("SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    public Utilisateur getUserByUsername(@Param("nom") String nom);
    

}
