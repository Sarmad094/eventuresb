package com.example.eventuresb.Service;

import com.example.eventuresb.Model.EventAndCourse;
import com.example.eventuresb.Repository.EventAndCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventAndCourseService {
    private final EventAndCourseRepository repo;

    public EventAndCourseService(EventAndCourseRepository repo) {
        this.repo = repo;
    }

    public List<EventAndCourse> findAll() {
        return repo.findAll();
    }

    public Optional<EventAndCourse> findById(Long id) {
        return repo.findById(id);
    }

    public EventAndCourse save(EventAndCourse event) {
        return repo.save(event);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
