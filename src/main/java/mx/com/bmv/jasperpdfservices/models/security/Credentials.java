package mx.com.bmv.jasperpdfservices.models.security;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "credenciales")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "usuario")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "credencial_rol", joinColumns = {
            @JoinColumn(name = "id_credencial",referencedColumnName="id",nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_rol",referencedColumnName="id",nullable = false, updatable = false)})
    Collection<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
