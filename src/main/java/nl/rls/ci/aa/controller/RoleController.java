package nl.rls.ci.aa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.rls.ci.aa.domain.Role;
import nl.rls.ci.aa.dto.RoleDto;
import nl.rls.ci.aa.dto.RoleDtoMapper;
import nl.rls.ci.aa.repository.RoleRepository;

@RestController
@RequestMapping("/aa/roles")
public class RoleController {
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<RoleDto> getAll() {
		Iterable<Role> roleList = roleRepository.findAll();
		List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
		for (Role role : roleList) {
			roleDtoList.add(RoleDtoMapper.map(role));
		}
		return roleDtoList;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<RoleDto> getRole(@PathVariable int id) {
		Optional<Role> role = roleRepository.findById(id);
		return ResponseEntity.ok(RoleDtoMapper.map(role.get()));
	}

}
