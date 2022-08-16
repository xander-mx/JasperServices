package mx.com.bmv.jasperpdfservices.services.security;

import mx.com.bmv.jasperpdfservices.models.security.Credentials;
import mx.com.bmv.jasperpdfservices.repositories.CredentialsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class CredentialsServ implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CredentialsServ.class);
    private final CredentialsRepo credentialsRepo;
    private final PasswordEncoder passwordEncoder;

    @Inject
    public CredentialsServ(CredentialsRepo credentialsRepo, PasswordEncoder passwordEncoder) {
        this.credentialsRepo = credentialsRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credentials credentials = credentialsRepo.findByUser(username);
        if(credentials == null) {
            logger.error("No existe el usuario: {}", username);
            throw new UsernameNotFoundException("Usuario no encontrado!!!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        credentials.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getDescription())));
        return new User(credentials.getUser(), credentials.getPassword(),authorities);
    }

    public Credentials save(Credentials credentials){
        logger.info("Credenciales guardadas: {}", credentials.getName());
        credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
        return credentialsRepo.save(credentials);
    }

    public Credentials getByUser(String user) {
        return credentialsRepo.findByUser(user);
    }
}
