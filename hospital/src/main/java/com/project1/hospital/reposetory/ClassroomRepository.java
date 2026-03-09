package com.project1.hospital.reposetory;


import com.project1.hospital.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    // Basic CRUD operations JpaRepository mein pehle se hote hain
}