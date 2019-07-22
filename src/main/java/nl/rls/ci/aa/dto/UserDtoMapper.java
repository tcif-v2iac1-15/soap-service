package nl.rls.ci.aa.dto;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.hateoas.Link;

import nl.rls.ci.aa.controller.OwnerController;
import nl.rls.ci.aa.controller.UserController;
import nl.rls.ci.aa.domain.AppUser;

public class UserDtoMapper {

	public static UserDto map(AppUser user) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
			protected void configure() {
			}
		};
		mapper.addMapping(mappingBuilder);
		UserDto userDto = mapper.map(user, UserDto.class);
		Link link = linkTo(methodOn(OwnerController.class).getOwner(user.getOwner().getId())).withRel("owner");
		System.out.println("link: "+ link.toString());
		userDto.add(link);
	    userDto.add(linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel());
		userDto.add(linkTo(methodOn(UserController.class).getRolesByUser(user.getId())).withRel("roles"));
		return userDto;
	}

}
