package org.c15.group3.library_management_system.data.models.Abstract;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.c15.group3.library_management_system.data.models.notifications.Recipient;
import org.c15.group3.library_management_system.data.models.notifications.Sender;

import java.util.List;

import static jakarta.persistence.GenerationType.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Notification{
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;
    private String message;
    @Transient
    private Sender sender;
    @OneToMany
    @JsonProperty("to")
    private List<Recipient> recipients;
}
