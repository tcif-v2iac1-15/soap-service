package nl.rls.ci.aa.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nl.rls.ci.aa.domain.License;

public interface LicenseRepository extends CrudRepository<License, Integer> {
	@Query("SELECT l FROM License l, Owner o, AppUser u JOIN u.owner owner JOIN o.licenses license WHERE u.email = ?1 and l.validFrom<= ?2 and l.validTo >= ?2")
	public License validLicenseByUsername(String username, Date date);
}
