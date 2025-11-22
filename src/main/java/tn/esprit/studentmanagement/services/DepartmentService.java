package tn.esprit.studentmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.repositories.DepartmentRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service



public class DepartmentService implements IDepartmentService {
    private static final Logger logger = LogManager.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;




    @Override
    public List<Department> getAllDepartments() {
        logger.debug("Fetching all departments from repository");
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long idDepartment) {
        logger.debug("Fetching department by id: {}", idDepartment);
        return departmentRepository.findById(idDepartment).orElse(null);
    }


    @Override
    public Department saveDepartment(Department department) {
        logger.info("Saving department: {}", department);
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long idDepartment) {
        logger.warn("Deleting department with id: {}", idDepartment);
        departmentRepository.deleteById(idDepartment);
    }
}
