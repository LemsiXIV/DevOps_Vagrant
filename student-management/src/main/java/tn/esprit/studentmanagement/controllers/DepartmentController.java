package tn.esprit.studentmanagement.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studentmanagement.entities.Department;
import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.services.DepartmentService;
import tn.esprit.studentmanagement.services.IDepartmentService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/ ")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class DepartmentController {
    private static final Logger logger = LogManager.getLogger(DepartmentController.class);
    private IDepartmentService departmentService;

    @GetMapping("/getAllDepartment")
    public List<Department> getAllDepartment() {
        logger.debug("Fetching all departments");
        List<Department> departments = departmentService.getAllDepartments();
        logger.info("Number of departments fetched: {}", departments.size());
        return departments;
    }

    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable Long id) {
        logger.debug("Fetching department with id: {}", id);
        Department department = departmentService.getDepartmentById(id);
        if (department == null) {
            logger.error("Department not found with id: {}", id);
        }
        return department;
    }

    @PostMapping("/createDepartment")
    public Department createDepartment(@RequestBody Department department) { return departmentService.saveDepartment(department); }

    @PutMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable Long id) {
      departmentService.deleteDepartment(id); }
}
