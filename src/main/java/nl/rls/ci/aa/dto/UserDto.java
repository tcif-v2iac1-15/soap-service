package nl.rls.ci.aa.dto;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto extends ResourceSupport {
	private String firstName;
	private String lastName;
	private String email;
}