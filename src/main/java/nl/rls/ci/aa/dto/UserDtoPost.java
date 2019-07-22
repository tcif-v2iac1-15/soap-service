package nl.rls.ci.aa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDtoPost {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
}