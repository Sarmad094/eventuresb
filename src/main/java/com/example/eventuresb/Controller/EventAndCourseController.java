package com.example.eventuresb.Controller;

import com.example.eventuresb.Model.EventAndCourse;
import com.example.eventuresb.Service.EventAndCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventAndCourseController {

    private final EventAndCourseService service;

    public EventAndCourseController(EventAndCourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventAndCourse> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventAndCourse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EventAndCourse create(@RequestBody EventAndCourse event) {
        return service.save(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventAndCourse> update(@PathVariable Long id,
                                                 @RequestBody EventAndCourse updated) {
        return service.findById(id)
                .map(existing -> {
                    // copy fields you allow to update...
                    existing.setTitle(updated.getTitle());
                    existing.setStartDate(updated.getStartDate());
                    existing.setEndDate(updated.getEndDate());
                    // etc.
                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
