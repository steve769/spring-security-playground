package info.stephenderrick.basicauth.controller;


import info.stephenderrick.basicauth.model.StudentModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private final List<StudentModel> STUDENTS = Arrays.asList(
            new StudentModel(1, "Stephen Otieno"),
            new StudentModel(2, "Alice Wagner"),
            new StudentModel(3, "Walter White")
    );
    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<StudentModel> getAllStudents(){
        return STUDENTS;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public String registerStudent(@RequestBody StudentModel studentModel){
        return "Student added successfully";
    }

}
