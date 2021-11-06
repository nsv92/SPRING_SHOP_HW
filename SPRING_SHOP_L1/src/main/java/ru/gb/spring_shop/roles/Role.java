package ru.gb.spring_shop.roles;

import lombok.Data;
import ru.gb.spring_shop.users.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role() {
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.name = roleName;
    }
}
