package pl.gozderapatryk.userservice.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return id != null && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
