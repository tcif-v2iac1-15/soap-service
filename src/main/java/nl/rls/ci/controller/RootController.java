package nl.rls.ci.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	@GetMapping("/api/v1/")
	ResponseEntity<ResourceSupport> root() {
		ResourceSupport resourceSupport = new ResourceSupport();
		resourceSupport.add(linkTo(methodOn(RootController.class).root()).withSelfRel());
		resourceSupport.add(linkTo(methodOn(CiController.class).getAllMessages()).withRel("ci"));
		return ResponseEntity.ok(resourceSupport);
	}

}