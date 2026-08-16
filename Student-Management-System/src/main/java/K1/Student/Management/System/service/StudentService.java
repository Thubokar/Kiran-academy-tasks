package K1.Student.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import K1.Student.Management.System.entity.Student;
import K1.Student.Management.System.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    
    public Student registerStudent(Student student) {

        Optional<Student> existingStudent =
                studentRepository.findByUsername(student.getUsername());

        if (existingStudent.isPresent()) {
            throw new RuntimeException("Username already registered");
        }

        return studentRepository.save(student);
    }

   
    public Student login(String username, String password) {

        Optional<Student> student =
                studentRepository.findByUsername(username);

        if (student.isPresent()
                && student.get().getPassword().equals(password)) {

            return student.get();
        }

        throw new RuntimeException(
                "Student not registered or invalid username/password");
    }

  
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));
    }


    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

   
    public List<Student> getStudentByFullname(String fullname) {

        return studentRepository.findByFullname(fullname);
    }

  
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = getStudentById(id);

        existingStudent.setFullname(updatedStudent.getFullname());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setCity(updatedStudent.getCity());
        existingStudent.setPercentage(updatedStudent.getPercentage());
        existingStudent.setUsername(updatedStudent.getUsername());
        existingStudent.setPassword(updatedStudent.getPassword());

        return studentRepository.save(existingStudent);
    }

 
    public void deleteStudent(Long id) {

        Student student = getStudentById(id);

        studentRepository.delete(student);
    }

    
    public List<Student> getStudentsByCourse(String course) {

        return studentRepository.findByCourse(course);
    }

    
    public Student getTopper() {

        return studentRepository
                .findTopByOrderByPercentageDesc()
                .orElseThrow(() ->
                        new RuntimeException("No students found"));
    }

    
    public Student getSecondTopper() {

        List<Student> students =
                studentRepository.findTop2ByOrderByPercentageDesc();

        if (students.size() < 2) {
            throw new RuntimeException(
                    "At least two students are required");
        }

        return students.get(1);
    }
}