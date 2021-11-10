package com.example.api.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id ;

    @Basic
    @NotNull(message = "le champ name ne peut être numm")
    private String name ;

    @ManyToMany(mappedBy = "roles")
    private List<User> users ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
