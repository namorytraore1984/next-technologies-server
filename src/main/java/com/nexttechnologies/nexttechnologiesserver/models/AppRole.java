package com.nexttechnologies.nexttechnologiesserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String name;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany
    private Set<AppUser> appUser;
    @ManyToMany(
            mappedBy = "appRole",
            fetch = FetchType.EAGER
    )
    private Set<AppPermission> permissions;
}
