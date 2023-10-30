package com.example.demo.apicontroller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{studentId}")
    public Student getStudentInfo(@PathVariable("studentId") int studentId) {
        return studentService.getStudentInfo(studentId);
    }

    @DeleteMapping("/{studentId}")
    public String removeById(@PathVariable int studentId) {
        String res = studentService.removeStudent(studentId);
        return res;
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        String res = studentService.addStudent(student);
        return res;
    }

    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable int studentId,
                                @RequestBody StudentDto studentDto) {
        String res = studentService.updateStudent(studentId, studentDto);
        return res;
    }
}
