package mx.com.bmv.jasperpdfservices.repositories;

import mx.com.bmv.jasperpdfservices.models.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID> {

    Role findByDescription(String description);
}
