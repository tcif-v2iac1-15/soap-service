package nl.rls.ci.aa.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.rls.ci.aa.domain.License;
import nl.rls.ci.aa.domain.Owner;
import nl.rls.ci.aa.dto.OwnerDto;
import nl.rls.ci.aa.dto.OwnerDtoMapper;
import nl.rls.ci.aa.dto.OwnerDtoPost;
import nl.rls.ci.aa.repository.OwnerRepository;

@RestController
@RequestMapping("/aa/owners")
public class OwnerController {
	@Autowired
    private OwnerRepository ownerRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<OwnerDto> getAll() {
		Iterable<Owner> ownerList = ownerRepository.findAll();
		List<OwnerDto> ownerDtoList = new ArrayList<OwnerDto>();
		for (Owner owner : ownerList) {
			ownerDtoList.add(OwnerDtoMapper.map(owner));
		}
		return ownerDtoList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OwnerDto> getOwner(@PathVariable Integer id) {
		Optional<Owner> owner = ownerRepository.findById(id);
		return ResponseEntity.ok(OwnerDtoMapper.map(owner.get()));
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> postOwner(@RequestBody OwnerDtoPost dto) {
		Owner owner = OwnerDtoMapper.map(dto);
		License license = new License();
		license.setValidTo(new Date());
		license.setContract("BASIC");
		owner.getLicenses().add(license);
		ownerRepository.save(owner);
		return ResponseEntity.created(linkTo(methodOn(OwnerController.class).getOwner(owner.getId())).toUri()).build();
	}

}