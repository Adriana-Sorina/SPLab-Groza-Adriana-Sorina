package ro.uvt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ro.uvt.services.BooksService;
import ro.uvt.models.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        return booksService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(booksService.createBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
        return booksService.updateBook(id, book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = booksService.deleteBook(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
