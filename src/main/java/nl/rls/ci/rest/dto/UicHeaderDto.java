package nl.rls.ci.rest.dto;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter @Setter
public class UicHeaderDto extends ResourceSupport {
	private String messageIdentifier;
	private String messageLiHost;
	private boolean compressed = false;
	private boolean encrypted = false;
	private boolean signed = false;

}
