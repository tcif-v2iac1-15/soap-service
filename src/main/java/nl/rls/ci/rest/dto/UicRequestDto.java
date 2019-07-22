package nl.rls.ci.rest.dto;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter @Setter
public class UicRequestDto extends ResourceSupport {
	private String message;
	private String signature;
	private String senderAlias;
	private String encoding;
}
