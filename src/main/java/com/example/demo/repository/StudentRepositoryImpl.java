package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private static Map<Integer, Student> studentMap = new HashMap<>();
    private static int seq = 0;

    public StudentRepositoryImpl() {
        Student s = new Student();
        s.setStudentId(1);
        s.setName("tester");
        s.setMajor("Computer Engineering");
        s.setPoint(4.0F);
        add(s);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(int studentId) {
        return studentMap.get(studentId);
    }

    @Override
    public Student removeById(int studentId) {
        Student removeStudent = studentMap.remove(studentId);
        return removeStudent;
    }

    @Override
    public Integer add(Student student) {
        Integer result = null;
        student.setStudentId(++seq);
        Student addedStudent = studentMap.put(seq, student);
        if (addedStudent != null) {
            result = student.getStudentId();
        }
        return result;
    }

    @Override
    public Student update(int studentId, Student student) {
        if (findById(studentId) != null) {
            studentMap.put(seq, student);
        } else {
            add(student);
        }
        return student;
    }
}
