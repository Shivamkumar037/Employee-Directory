package com.project1.hospital.Service;

import com.project1.hospital.entity.Classroom;
import com.project1.hospital.reposetory.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public Classroom createClass(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom getClassById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }
}