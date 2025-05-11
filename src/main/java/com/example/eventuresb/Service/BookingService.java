package com.myproject.service;

import com.eventuresb.dto.BookingBasicDTO;
import com.eventuresb.dto.BookingDetailDTO;
import com.eventuresb.mapper.BookingMapper;
import com.eventuresb.model.Booking;
import com.eventuresb.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    // Get all bookings (basic info)
    public List<BookingBasicDTO> getAllBookingsBasic() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookingMapper.toBookingBasicDTOs(bookings);
    }

    // Get booking by ID (detailed info)
    public BookingDetailDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
        return bookingMapper.toBookingDetailDTO(booking);
    }

    // Create a new booking
    public BookingDetailDTO createBooking(BookingDetailDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setBookDate(bookingDTO.getBookDate());
        booking.setPaymentStatus(bookingDTO.getPaymentStatus());
        // EventID og StudentID kan settes her hvis du ønsker
        booking.setEventId(bookingDTO.getEventId());
        booking.setStudentId(bookingDTO.getStudentId());

        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.toBookingDetailDTO(savedBooking);
    }

    // Update a booking
    public BookingDetailDTO updateBooking(Long id, BookingDetailDTO bookingDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found"));

        booking.setBookDate(bookingDTO.getBookDate());
        booking.setPaymentStatus(bookingDTO.getPaymentStatus());
        booking.setEventId(bookingDTO.getEventId());
        booking.setStudentId(bookingDTO.getStudentId());

        Booking updatedBooking = bookingRepository.save(booking);
        return bookingMapper.toBookingDetailDTO(updatedBooking);
    }

    // Delete a booking
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new EntityNotFoundException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    // Add your custom service methods here
}
