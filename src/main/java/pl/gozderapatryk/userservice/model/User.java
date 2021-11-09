package pl.gozderapatryk.userservice.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends Person {
    private String username;
    private String email;
}
