package nl.rls.ci.rest.dto.mapper;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import nl.rls.ci.controller.CiController;
import nl.rls.ci.domain.CiMessage;
import nl.rls.ci.rest.dto.CiDto;

public class CiPostDtoMapper {

	public static CiDto map(CiMessage cim) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
			protected void configure() {
			}
		};
		mapper.addMapping(mappingBuilder);
		CiDto ciDto = mapper.map(cim, CiDto.class);
		ciDto.add(linkTo(methodOn(CiController.class).getMessage(cim.getId())).withSelfRel());
		return ciDto;
	}

}
