package nl.rls.ci.aa.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.rls.ci.aa.domain.AppUser;
import nl.rls.ci.aa.domain.Role;
import nl.rls.ci.aa.dto.RoleDto;
import nl.rls.ci.aa.dto.RoleDtoMapper;
import nl.rls.ci.aa.dto.UserDto;
import nl.rls.ci.aa.dto.UserDtoMapper;
import nl.rls.ci.aa.repository.RoleRepository;
import nl.rls.ci.aa.repository.UserRepository;

@RestController
@RequestMapping("/aa/users")
public class UserController {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDto> getAll() {
		log.debug("public List<UserDto> getAll()");
		Iterable<AppUser> userList = userRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for (AppUser user : userList) {
			userDtoList.add(UserDtoMapper.map(user));
		}
		return userDtoList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUser(@PathVariable int id) {
		Optional<AppUser> user = userRepository.findById(id);
		return ResponseEntity.ok(UserDtoMapper.map(user.get()));
	}

    @GetMapping("/{userId}/roles")
    public ResponseEntity<List<RoleDto>> getRolesByUser(@PathVariable int userId) {
		Optional<AppUser> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			AppUser user = optional.get();
			List<RoleDto> rolesDto = new ArrayList<>();
			for (Role role : user.getRoles()) {
				rolesDto.add(RoleDtoMapper.map(role));
			};
			return ResponseEntity.ok(rolesDto);
		} else {
			return null;
		}
	
    	
    }
    @PutMapping("/{userId}/roles/{roleName}")
    public ResponseEntity<?> addRoleToUser(@PathVariable int userId, String roleName) {
		Optional<AppUser> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			AppUser user = optional.get();
			Role role = roleRepository.findByName(roleName);
			if (role != null) {
				user.getRoles().add(role);
				userRepository.save(user);
			}
			return ResponseEntity.ok(null);
		} else {
			return null;
		}
	
    	
    }
}