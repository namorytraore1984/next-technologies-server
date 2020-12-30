package com.nexttechnologies.nexttechnologiesserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppRole extends EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String name;
    //private String username;
    @ManyToMany
    private Set<AppUser> appUser;
    @ManyToMany(
            mappedBy = "appRole"
    )
    private Set<AppPermission> permissions;
}
