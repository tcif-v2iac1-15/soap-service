package nl.rls.ci.aa.dto;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OwnerDto extends ResourceSupport {
	private String code;
	private String name;

}
