package K1.Student.Management.System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import K1.Student.Management.System.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUsername(String username);

    List<Student> findByFullname(String fullname);

    List<Student> findByCourse(String course);

    Optional<Student> findTopByOrderByPercentageDesc();

    List<Student> findTop2ByOrderByPercentageDesc();
}