package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.repositories.EnrollmentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class EnrollmentServiceTest {
    @Autowired
    private EnrollmentService enrollmentService;

    @MockBean
    private EnrollmentRepository enrollmentRepository;

    @Test
    void testGetAllEnrollments() {
        Enrollment e1 = new Enrollment();
        Enrollment e2 = new Enrollment();
        when(enrollmentRepository.findAll()).thenReturn(Arrays.asList(e1, e2));
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        assertThat(enrollments).hasSize(2);
    }

    @Test
    void testGetEnrollmentById() {
        Enrollment e = new Enrollment();
        e.setIdEnrollment(1L);
        when(enrollmentRepository.findById(1L)).thenReturn(Optional.of(e));
        Enrollment found = enrollmentService.getEnrollmentById(1L);
        assertThat(found).isNotNull();
        assertThat(found.getIdEnrollment()).isEqualTo(1L);
    }

    @Test
    void testSaveEnrollment() {
        Enrollment e = new Enrollment();
        when(enrollmentRepository.save(e)).thenReturn(e);
        Enrollment saved = enrollmentService.saveEnrollment(e);
        assertThat(saved).isEqualTo(e);
    }

    @Test
    void testDeleteEnrollment() {
        enrollmentService.deleteEnrollment(1L);
        verify(enrollmentRepository, times(1)).deleteById(1L);
    }
}
