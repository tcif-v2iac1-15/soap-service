package nl.rls.ci.aa.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import nl.rls.ci.aa.domain.AppUser;
import nl.rls.ci.aa.repository.UserRepository;

@Component
public class SecurityContext {
	@Autowired
    private UserRepository userRepository;

    public int getOwnerId() {
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	Optional<AppUser> optionalUser = userRepository.findByEmail(username);
    	optionalUser.orElseThrow(IllegalArgumentException::new);
    	System.out.println("OwnerId: "+optionalUser.get().getOwner().getId());
       	return optionalUser.get().getOwner().getId();
    }

}
