
package com.example.midan.web;

        import com.example.midan.model.Exceptions.InvalidArgumentsException;
        import com.example.midan.model.Exceptions.PasswordDoNotMatchException;
        import com.example.midan.model.Guest;
        import com.example.midan.service.BookingService;
        import com.example.midan.service.GuestService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.time.LocalDate;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
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



    @PostMapping("/bookOffer/{id}")
    public String bookOffer(
            @PathVariable Long id,
            @RequestParam LocalDate checkIn,
            @RequestParam LocalDate checkOut,
            @RequestParam Long roomId,
            @RequestParam Long guestId)
    {
        try{
            this.bookingService.book(checkIn, checkOut, roomId, guestId);
            return "redirect:/receipt";
        }
        catch (InvalidArgumentsException exception)
        {
            return "redirect:/booking?error="+exception.getMessage();
        }
    }

}