package devoir.charqielquortobi.services;

import java.util.List;

import org.springframework.stereotype.*;

import devoir.charqielquortobi.models.*;

//@EnableJpaRepositories("UtilisateurRepository")
@Service
public interface UtilisateurService {

	public utilisateur FindByName(String name);
	
	public void save(utilisateur utilisateur);
	
	public void update(utilisateur utilisateur);
	
	public List<utilisateur> findAllUser();
	
	public void deleteUser(int id_user);

	public List<utilisateur> getDevs();
	
	public utilisateur FintById(int idUser);
	
	public List<ticket> getClientTickets(int idUser);
	
	public List<ticket> getDevsTickets(int idUser);
	
	public void affecter(int idticket ,int idDev);
	
	
	
	
	
	
	
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
