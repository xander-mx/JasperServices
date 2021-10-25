package mx.com.bmv.jasperpdfservices.repositories;

import mx.com.bmv.jasperpdfservices.models.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByDescription(String description);
}
