package nl.rls.ci.aa.dto;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import nl.rls.ci.aa.controller.RoleController;
import nl.rls.ci.aa.domain.Role;

public class RoleDtoMapper {

	public static RoleDto map(Role role) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
			protected void configure() {
			}
		};
		mapper.addMapping(mappingBuilder);
		RoleDto roleDto = mapper.map(role, RoleDto.class);
	    roleDto.add(linkTo(methodOn(RoleController.class).getRole(role.getId())).withSelfRel());
		return roleDto;
	}

}
