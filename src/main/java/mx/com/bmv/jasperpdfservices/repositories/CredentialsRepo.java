package mx.com.bmv.jasperpdfservices.repositories;

import mx.com.bmv.jasperpdfservices.models.security.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CredentialsRepo extends JpaRepository<Credentials, UUID> {

    Credentials findByUser(String user);
}
