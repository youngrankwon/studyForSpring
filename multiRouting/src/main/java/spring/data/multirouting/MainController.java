package spring.data.multirouting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.data.multirouting.repository.school.School;
import spring.data.multirouting.repository.school.SchoolRepository;
import spring.data.multirouting.repository.student.Student;
import spring.data.multirouting.repository.student.StudentRepository;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "school")
    public ResponseEntity<List<School>> getSchool() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(schoolRepository.findAll());
    }

    @GetMapping(value = "student")
    public ResponseEntity<List<Student>> getStudent() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(studentRepository.findAll());
    }
}
