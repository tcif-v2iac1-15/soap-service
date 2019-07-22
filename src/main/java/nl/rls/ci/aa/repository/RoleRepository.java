package nl.rls.ci.aa.repository;

import org.springframework.data.repository.CrudRepository;

import nl.rls.ci.aa.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findByName(String string);
}
