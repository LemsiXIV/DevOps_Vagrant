package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    void testGetAllStudents() {
        Student s1 = new Student();
        Student s2 = new Student();
        when(studentRepository.findAll()).thenReturn(Arrays.asList(s1, s2));
        List<Student> students = studentService.getAllStudents();
        assertThat(students).hasSize(2);
    }

    @Test
    void testGetStudentById() {
        Student s = new Student();
        s.setIdStudent(1L);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(s));
        Student found = studentService.getStudentById(1L);
        assertThat(found).isNotNull();
        assertThat(found.getIdStudent()).isEqualTo(1L);
    }

    @Test
    void testSaveStudent() {
        Student s = new Student();
        when(studentRepository.save(s)).thenReturn(s);
        Student saved = studentService.saveStudent(s);
        assertThat(saved).isEqualTo(s);
    }

    @Test
    void testDeleteStudent() {
        studentService.deleteStudent(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }
}
