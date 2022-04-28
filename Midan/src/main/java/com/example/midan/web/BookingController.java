
package com.example.midan.web;

        import com.example.midan.model.Exceptions.InvalidArgumentsException;
        import com.example.midan.model.Guest;
        import com.example.midan.model.Room;
        import com.example.midan.repository.GuestRepository;
        import com.example.midan.repository.RoomRepository;
        import com.example.midan.service.BookingService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.time.LocalDate;
        import java.util.Optional;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public BookingController(BookingService bookingService, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.bookingService = bookingService;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public String getBookingPage(@RequestParam(required = false) String error, Model model)
    {
        if(error!=null && !error.isEmpty())
        {
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }

        model.addAttribute("bodyContent","booking");
        return "master-template"; // NEKOJ TEMPLEJT OD GOOGLE !!!!!!
    }


    // guestId mislam deka treba da go zememe od sesija ili request kako za najavata so e
    //a za offerId ne ni raboti id-to za offer koga klikame na book kompceto
    @PostMapping("/bookOffer/{id}")
    public String bookOffer(
            @PathVariable Long id,
            @RequestParam(required = false) String checkIn,
            @RequestParam(required = false) String checkOut,
            @RequestParam Long offerId,
            @RequestParam Long guestId ) {
        try{
            Optional<Room> room = this.roomRepository.findById(offerId);
            Optional<Guest> guest = this.guestRepository.findById(guestId);
            this.bookingService.book(LocalDate.parse(checkIn), LocalDate.parse(checkOut), offerId, guestId);
            return "redirect:/booking";
        }
        catch (InvalidArgumentsException exception)
        {
            return "redirect:/booking?error="+exception.getMessage();
        }
    }

}