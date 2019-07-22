package nl.rls.ci.aa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import nl.rls.ci.aa.domain.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
	Optional<Owner> findByCode(String code);

}
