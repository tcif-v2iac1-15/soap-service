package nl.rls.ci;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import nl.rls.ci.aa.domain.AppUser;
import nl.rls.ci.aa.domain.License;
import nl.rls.ci.aa.domain.Owner;
import nl.rls.ci.aa.domain.Role;
import nl.rls.ci.aa.repository.LicenseRepository;
import nl.rls.ci.aa.repository.OwnerRepository;
import nl.rls.ci.aa.repository.RoleRepository;
import nl.rls.ci.aa.repository.UserRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Trains24CI {
//	@Autowired
//	private static final Logger log = LoggerFactory.getLogger(Trains24CI.class);
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private LicenseRepository licenseRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private UserRepository userRepository;
	private static final Logger log = LoggerFactory.getLogger(Trains24CI.class);
		
	public static void main(String[] args) {
		SpringApplication.run(Trains24CI.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Transactional
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("Start CommandLineRunner");
			roleRepository.save(new Role("USER"));
			roleRepository.save(new Role("SUPER_USER"));
			roleRepository.save(new Role("ADMIN"));
			Role role = roleRepository.findByName("ADMIN");
			AppUser user = new AppUser("Berend", "Wilkens", "berend.wilkens@hu.nl");
			userRepository.save(user);
			user = userRepository.findById(user.getId()).get();
			user.getRoles().add(role);
			user.setPassword(bCryptPasswordEncoder().encode("qwerty"));
			userRepository.save(user);
			
			Owner owner = new Owner();
			owner.setCode("3502");
			owner.setName("Spitzke Spoorbouw BV");
			Calendar now = Calendar.getInstance();
			Calendar now3 = Calendar.getInstance();
			now3.add(Calendar.MONTH, 3); 
			log.info("Start saving ...");
			ownerRepository.save(owner);
			licenseRepository.save(new License("FREE", now.getTime(), now3.getTime(), owner));
			
//			Calendar now = Calendar.getInstance();
//			now.add(Calendar.MONTH, -3); 
//			Calendar now3 = Calendar.getInstance();
//			now3.add(Calendar.MONTH, -1); 
//			log.info("Start saving ...");
//			ownerRepository.save(owner);
//			licenseRepository.save(new License("FREE", now.getTime(), now3.getTime(), owner));
			
			log.info("End CommandLineRunner");
		};
	}

}
