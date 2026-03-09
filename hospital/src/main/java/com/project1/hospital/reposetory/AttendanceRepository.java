package com.project1.hospital.reposetory;


import com.project1.hospital.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Kisi student ki kisi khas date ki attendance check karne ke liye
    List<Attendance> findByStudentIdAndDate(Long studentId, LocalDate date);
}