package tn.esprit.studentmanagement.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

import java.util.Optional;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @Test
    void contextLoads() {
        assertThat(departmentService).isNotNull();
    }

    @Test
    void testGetAllDepartments() {
        Department d1 = new Department();
        Department d2 = new Department();
        when(departmentRepository.findAll()).thenReturn(Arrays.asList(d1, d2));
        List<Department> departments = departmentService.getAllDepartments();
        assertThat(departments).hasSize(2);
    }

    @Test
    void testGetDepartmentById() {
        Department d = new Department();
        d.setIdDepartment(1L);
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(d));
        Department found = departmentService.getDepartmentById(1L);
        assertThat(found).isNotNull();
        assertThat(found.getIdDepartment()).isEqualTo(1L);
    }

    @Test
    void testSaveDepartment() {
        Department d = new Department();
        when(departmentRepository.save(d)).thenReturn(d);
        Department saved = departmentService.saveDepartment(d);
        assertThat(saved).isEqualTo(d);
    }

    @Test
    void testDeleteDepartment() {
        departmentService.deleteDepartment(1L);
        verify(departmentRepository, times(1)).deleteById(1L);
    }
}
