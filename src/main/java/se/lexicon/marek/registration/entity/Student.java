package se.lexicon.marek.registration.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    @Id
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String email;
    private String phoneNumber;
    private LocalDateTime registerDate;
    private boolean status;
}
