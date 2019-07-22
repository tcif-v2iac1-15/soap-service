package nl.rls.ci.aa.dto;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import nl.rls.ci.aa.controller.OwnerController;
import nl.rls.ci.aa.domain.Owner;

public class OwnerDtoMapper {

	public static OwnerDto map(Owner owner) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
			protected void configure() {
			}
		};
		mapper.addMapping(mappingBuilder);
		OwnerDto ownerDto = mapper.map(owner, OwnerDto.class);
//		ownerDto.add(linkTo(methodOn(OwnerController.class).getOwner(user.getOwner().getId())).withRel("owner"));
		ownerDto.add(linkTo(methodOn(OwnerController.class).getOwner(owner.getId())).withSelfRel());
		return ownerDto;
	}

	public static Owner map(OwnerDtoPost dto) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		Owner entity = mapper.map(dto, Owner.class);
		return entity;
	}


}
