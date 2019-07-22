package nl.rls.ci.soap.dto.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import nl.rls.ci.domain.UicRequest;
import nl.rls.ci.domain.UicResponse;
import nl.rls.ci.soap.dto.UICMessage;
import nl.rls.ci.soap.dto.UICMessageResponse;

public class CiDtoMapper {

	public static UICMessage map(UicRequest entity) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
			protected void configure() {
			}
		};
		mapper.addMapping(mappingBuilder);
		UICMessage uicMessage = mapper.map(entity, UICMessage.class);
		return uicMessage;
	}

	public static UicResponse map(UICMessageResponse dto) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
			protected void configure() {
			}
		};
		mapper.addMapping(mappingBuilder);
		UicResponse uicResponse = mapper.map(dto, UicResponse.class);
		return uicResponse;
	}

}
