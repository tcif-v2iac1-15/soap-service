package nl.rls.ci.aa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import nl.rls.ci.aa.domain.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Integer> {
	Optional<AppUser> findByEmail(String email);
}
