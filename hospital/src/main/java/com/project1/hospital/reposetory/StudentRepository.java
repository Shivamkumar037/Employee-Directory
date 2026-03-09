package com.project1.hospital.reposetory;

import com.project1.hospital.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Specific class ke saare students nikalne ke liye custom method
    List<Student> findByClassroomId(Long classroomId);
    
    // Roll number se dhoondne ke liye
    Optional<Student> findByRollNo(String rollNo);
}