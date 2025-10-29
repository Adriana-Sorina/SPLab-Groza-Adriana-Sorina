package ro.uvt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.uvt.commands.*;
import ro.uvt.models.Book;
import ro.uvt.services.BooksService;  // ← linia care lipsește!
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor executor;

    @GetMapping
    public List<Book> getAll() {
        return (List<Book>) executor.execute(new GetAllBooksCommand(booksService));
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return (Book) executor.execute(new GetBookByIdCommand(booksService, id));
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return (Book) executor.execute(new CreateBookCommand(booksService, book));
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return (Book) executor.execute(new UpdateBookCommand(booksService, id, book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        executor.execute(new DeleteBookCommand(booksService, id));
    }
}
