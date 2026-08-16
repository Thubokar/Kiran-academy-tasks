package K1.Student.Management.System.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import K1.Student.Management.System.entity.Student;
import K1.Student.Management.System.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   
    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {

        return studentService.registerStudent(student);
    }

    
    @PostMapping("/login")
    public Student login(
            @RequestParam String username,
            @RequestParam String password) {

        return studentService.login(username, password);
    }

   
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id);
    }

    
    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    
    @GetMapping("/name/{fullname}")
    public List<Student> getStudentByFullname(
            @PathVariable String fullname) {

        return studentService.getStudentByFullname(fullname);
    }

    
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

 
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return "Student deleted successfully";
    }


    @GetMapping("/course/{course}")
    public List<Student> getStudentsByCourse(
            @PathVariable String course) {

        return studentService.getStudentsByCourse(course);
    }

    
    @GetMapping("/topper")
    public Student getTopper() {

        return studentService.getTopper();
    }


    @GetMapping("/second-topper")
    public Student getSecondTopper() {

        return studentService.getSecondTopper();
    }
}