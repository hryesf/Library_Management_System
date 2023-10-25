package com.myresume.librarymanagementsystem.jointables.donatedbook.conrtoller;

import com.myresume.librarymanagementsystem.jointables.donatedbook.entity.DonatedBook;
import com.myresume.librarymanagementsystem.jointables.donatedbook.service.DonatedBookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/donatedBooks")
public class DonatedBookController {

    private final DonatedBookService donatedBookService;

    public DonatedBookController(DonatedBookService donatedBookService) {
        this.donatedBookService = donatedBookService;
    }

    @GetMapping
    public String getAllDonatedBooks() {
        return donatedBookService.getAllDonatedBooks().toString();
    }

    @PostMapping("/{book_id}/{library_id}")
    public String startMembership(@PathVariable Long book_id , @PathVariable Long library_id) {
        DonatedBook donatedBook = donatedBookService.donateBook(book_id, library_id);
        return donatedBook.toString();
    }
}
