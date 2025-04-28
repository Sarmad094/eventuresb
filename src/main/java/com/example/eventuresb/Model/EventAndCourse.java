package com.example.eventuresb.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class EventAndCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "title")
    private String title;

    @Column(name = "subject_area")
    private String subjectArea;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "participants")
    private Integer participants;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "price")
    private Double price;

    public EventAndCourse() {
    }

    public EventAndCourse(String title, LocalDateTime startDate, LocalDateTime endDate, Organization organization) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "EventAndCourse{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                '}';
    }
}