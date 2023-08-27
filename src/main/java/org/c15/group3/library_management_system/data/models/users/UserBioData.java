package org.c15.group3.library_management_system.data.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class UserBioData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String LastName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
