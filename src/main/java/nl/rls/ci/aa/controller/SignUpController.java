package nl.rls.ci.aa.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.rls.ci.aa.domain.AppUser;
import nl.rls.ci.aa.domain.Owner;
import nl.rls.ci.aa.dto.UserDto;
import nl.rls.ci.aa.dto.UserDtoMapper;
import nl.rls.ci.aa.dto.UserDtoPost;
import nl.rls.ci.aa.repository.OwnerRepository;
import nl.rls.ci.aa.repository.UserRepository;

@RestController
public class SignUpController {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private OwnerRepository ownerRepository;
	private static final Logger log = LoggerFactory.getLogger(SignUpController.class);

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignUpController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @PostMapping("/sign-up")
	@Transactional
    public ResponseEntity<UserDto> signUp(@RequestBody UserDtoPost userDtoPost) {
    	log.info("signUp: "+userDtoPost);
    	AppUser user = new AppUser();
        user.setPassword(bCryptPasswordEncoder.encode(userDtoPost.getPassword()));
        user.setEmail(userDtoPost.getEmail());
        user.setFirstName(userDtoPost.getFirstName());
        user.setLastName(userDtoPost.getLastName());
        user.setEnabled(true);
    	log.info("signUp: getOwner");
        Optional<Owner> optional = ownerRepository.findById(1);
        optional.get().getUsers().add(user);
        user.setOwner(optional.get());
    	log.info("signUp: saving ...");
        userRepository.save(user);
		return ResponseEntity.ok(UserDtoMapper.map(user));
    }
    

}
