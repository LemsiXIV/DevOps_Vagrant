package tn.esprit.studentmanagement.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.services.IStudentService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class StudentController {
    private static final Logger logger = LogManager.getLogger(StudentController.class);
    IStudentService studentService;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        logger.debug("Fetching all students");
        List<Student> students = studentService.getAllStudents();
        logger.info("Number of students fetched: {}", students.size());
        return students;
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Long id) {
        logger.debug("Fetching student with id: {}", id);
        Student student = studentService.getStudentById(id);
        if (student == null) {
            logger.error("Student not found with id: {}", id);
        }
        return student;
    }

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student) {
        logger.info("Creating student: {}", student);
        return studentService.saveStudent(student);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id) { studentService.deleteStudent(id); }
}
