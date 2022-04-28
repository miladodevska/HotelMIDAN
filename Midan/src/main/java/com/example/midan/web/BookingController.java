//
//package com.example.midan.web;
//
//        import com.example.midan.model.Exceptions.InvalidArgumentsException;
//        import com.example.midan.model.Exceptions.OfferNotFoundException;
//        import com.example.midan.model.Exceptions.UserNotFoundException;
//        import com.example.midan.model.Guest;
//        import com.example.midan.model.Offer;
//        import com.example.midan.model.Room;
//        import com.example.midan.repository.GuestRepository;
//        import com.example.midan.repository.OfferRepository;
//        import com.example.midan.repository.RoomRepository;
//        import com.example.midan.service.BookingService;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.ui.Model;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.time.LocalDate;
//        import java.util.Optional;
//
//@Controller
//@RequestMapping("/booking")
//public class BookingController {
//
//    private final BookingService bookingService;
//    private final OfferRepository offerRepository;
//    private final GuestRepository guestRepository;
//
//    public BookingController(BookingService bookingService, OfferRepository offerRepository, GuestRepository guestRepository) {
//        this.bookingService = bookingService;
//        this.offerRepository = offerRepository;
//        this.guestRepository = guestRepository;
//    }
//
//    @GetMapping
//    public String getBookingPage(@RequestParam(required = false) String error, Model model)
//    {
//        if(error!=null && !error.isEmpty())
//        {
//            model.addAttribute("hasError",true);
//            model.addAttribute("error",error);
//        }
//        model.addAttribute("bodyContent","booking");
//        return "master-template";
//    }
//
//
//
//    //a za offerId ne ni raboti id-to za offer koga klikame na book kopceto
//    @PostMapping("/bookOffer/{id}")
//    public String bookOffer(
//            @PathVariable Long id,
//            @RequestParam(required = false) String checkIn,
//            @RequestParam(required = false) String checkOut,
//            @RequestParam Long offerId,
//            @RequestParam Long guestId) {
//        try{
//            Offer offer = this.offerRepository.findById(offerId).orElseThrow(() -> new OfferNotFoundException(id));
//            Guest guest = this.guestRepository.findById(guestId).orElseThrow(UserNotFoundException::new);
//            this.bookingService.book(LocalDate.parse(checkIn), LocalDate.parse(checkOut), offer, guest);
//            return "redirect:/booking";
//        }
//        catch (InvalidArgumentsException exception)
//        {
//            return "redirect:/booking?error="+exception.getMessage();
//        }
//    }
//
//}