package org.c15.group3.library_management_system.data.models.users;

import jakarta.persistence.*;
import lombok.*;
import org.c15.group3.library_management_system.data.models.Abstract.User;
import org.c15.group3.library_management_system.data.models.enums.Role;

import static jakarta.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
//@Table(name = "users")
public class Admin extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
