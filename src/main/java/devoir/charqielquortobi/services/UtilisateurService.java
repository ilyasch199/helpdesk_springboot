package devoir.charqielquortobi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;

import devoir.charqielquortobi.models.*;
import devoir.charqielquortobi.repositories.*;

//@EnableJpaRepositories("UtilisateurRepository")
//@Service
public interface UtilisateurService {

	public Utilisateur FindByName(String name);
	
	public void save(Utilisateur utilisateur);
	
	public void update(Utilisateur utilisateur);
	
	public List<Utilisateur> findAllUser();
	
	public void deleteUser(long id_user);


	
//	@Autowired
//	private UtilisateurRepository UtilisateurRepo;
//	
//	@Autowired 
//	private RoleRepository roleRepo;
//	
//	@Autowired 
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	public  void registerDefaultUser(Utilisateur user) {
//		Role roleClient = roleRepo.findByName("Client");
//		user.addRole(roleClient);
//		user.setEnabled(true);
//		encodePassword(user);
//		UtilisateurRepo.save(user);
//	}
//	
//	public List<Utilisateur> listAll() {
//		return UtilisateurRepo.findAll();
//	}
//
//	public Utilisateur get(Long id) {
//		return UtilisateurRepo.findById(id).get();
//	}
//	
//	public List<Role> listRoles() {
//		return roleRepo.findAll();
//	}
//	
//	public void save(Utilisateur user) {
//		encodePassword(user);		
//		UtilisateurRepo.save(user);
//	}
//	
//	private void encodePassword(Utilisateur user) {
//		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);		
//	}
}
