package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentInfo(int studentId) {
        return studentRepository.findById(studentId);
    }

    public String removeStudent(int studentId) {
        String result = "";
        Student removedStudent = studentRepository.removeById(studentId);
        if (removedStudent != null) {
            result = "정상적으로 삭제되었습니다.";
        } else {
            result = "삭제 과정에서 오류가 발생했습니다.";
        }

        return result;

    }

    public String addStudent(Student student) {
        String result = "";
        Integer add = studentRepository.add(student);
        if (add != null) {
            result = "정상적으로 추가되었습니다.";
        } else {
            result = "등록 과정에서 오류가 발생했습니다.";
        }
        return result;

    }

    public String updateStudent(int studentId, StudentDto studentDto) {
        Student foundStudent = studentRepository.findById(studentId);
        foundStudent.setPoint(studentDto.getPoint());
        studentRepository.update(studentId, foundStudent);
        return "수정 완료";
    }
}
