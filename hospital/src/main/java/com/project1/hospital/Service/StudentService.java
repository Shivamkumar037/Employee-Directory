package com.project1.hospital.Service;


import com.project1.hospital.dto.StudentRequest;
import com.project1.hospital.entity.Classroom;
import com.project1.hospital.entity.Student;
import com.project1.hospital.reposetory.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    @Transactional
    public Student saveStudent(StudentRequest request) {
        // 1. Check karein ki class exist karti hai ya nahi
        Classroom classroom = classroomRepository.findById(request.getClassroomId())
                .orElseThrow(() -> new RuntimeException("Classroom not found with ID: " + request.getClassroomId()));

        // 2. DTO se Entity mein data bharna
        Student student = new Student();
        student.setName(request.getName());
        student.setRollNo(request.getRollNo());
        student.setDob(request.getDob());
        student.setClassroom(classroom);

        // 3. Database mein save karein
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}