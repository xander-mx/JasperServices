package mx.com.bmv.jasperpdfservices.models.security;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "credentials")
public class Credentials {
    @Id
    private UUID id;

    @Column(name = "username")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "credential_rol", joinColumns = {
            @JoinColumn(name = "id_credential",referencedColumnName="id",nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_rol",referencedColumnName="id",nullable = false, updatable = false)})
    Collection<Role> roles;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
