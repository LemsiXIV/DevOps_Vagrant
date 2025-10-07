package tn.esprit.studentmanagement.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class StudentService implements IStudentService {
    private static final Logger logger = LogManager.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        logger.debug("Fetching all students from repository");
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        logger.debug("Fetching student by id: {}", id);
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        logger.info("Saving student: {}", student);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.warn("Deleting student with id: {}", id);
        studentRepository.deleteById(id);
    }
}
