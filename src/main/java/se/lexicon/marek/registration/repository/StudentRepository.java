package se.lexicon.marek.registration.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.marek.registration.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {
    List<Student> findByEmail(String email);
    List<Student> findByFirstName_AndLastName(String firstName, String lastName);




}
