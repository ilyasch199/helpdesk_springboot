package devoir.charqielquortobi.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import devoir.charqielquortobi.models.utilisateur;
import devoir.charqielquortobi.repositories.UtilisateurRepository;

@Service
public class UserPrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private UtilisateurRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		utilisateur user = userRepository.getUserByUsername(username);
		return new UserPrincipal(user);
	}


}
