package ro.uvt.controllers;

import org.springframework.web.bind.annotation.*;
import ro.uvt.models.Book;
import ro.uvt.persistence.BooksRepository;
import ro.uvt.observer.AllBooksSubject;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksRepository booksRepository;
    private final AllBooksSubject allBooksSubject;

    public BooksController(BooksRepository booksRepository,
                           AllBooksSubject allBooksSubject) {
        this.booksRepository = booksRepository;
        this.allBooksSubject = allBooksSubject;
    }

    @PostMapping
    public String newBook(@RequestBody Book bookRequest) {

        Book saved = booksRepository.save(bookRequest);

        allBooksSubject.add(saved);

        return "Book saved [" + saved.getId() + "] " + saved.getTitle();
    }
}
