package com.myproject.repository;

import com.eventuresb.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Simple query methods
    List<Booking> findByPaymentStatus(Boolean paymentStatus);
    List<Booking> findByBookDateAfter(LocalDate date);

    // Custom query methods
    List<Booking> findByStudentId(Long studentId);
    List<Booking> findByEventId(Long eventId);
    List<Booking> findByBookDateBetween(LocalDate start, LocalDate end);
    List<Booking> findByPaymentStatusAndEventId(Boolean paymentStatus, Long eventId);
}
