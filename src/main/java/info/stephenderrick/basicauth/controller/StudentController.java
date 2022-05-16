package info.stephenderrick.basicauth.controller;

import info.stephenderrick.basicauth.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final List<StudentModel> STUDENTS = Arrays.asList(
            new StudentModel(1, "Stephen Otieno"),
            new StudentModel(2, "Alice Wagner"),
            new StudentModel(3, "Walter White")
    );
    @GetMapping("/{studentId}")
    public StudentModel getStudent(@PathVariable("studentId") Integer studentId){

        return STUDENTS
                .stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student does not exist"));

    }
    @GetMapping("/")
    public List<StudentModel> getStudent(){

        return STUDENTS;

    }
}
