package org.c15.group3.library_management_system.data.models.Abstract;

import jakarta.persistence.*;
import lombok.*;
import org.c15.group3.library_management_system.data.models.enums.Role;
import org.c15.group3.library_management_system.data.models.users.UserBioData;

import static jakarta.persistence.GenerationType.UUID;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;
    @OneToOne
    private UserBioData userBioData;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
