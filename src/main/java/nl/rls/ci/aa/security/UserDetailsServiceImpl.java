package nl.rls.ci.aa.security;

import static java.util.Collections.emptyList;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nl.rls.ci.aa.domain.AppUser;
import nl.rls.ci.aa.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	/**
	 * Load the user from a DB
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> optionalUser = userRepository.findByEmail(username);
		optionalUser.orElseThrow(IllegalArgumentException::new);
		log.info("loadUserByUsername: " + optionalUser.get().getEmail());
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(optionalUser.get().getEmail(),
				optionalUser.get().getPassword(), emptyList());
		return userDetails;
	}
}