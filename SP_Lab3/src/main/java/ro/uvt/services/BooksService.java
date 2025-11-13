package ro.uvt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.models.Book;
import ro.uvt.persistence.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    // Creează o carte nouă
    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    // Returnează toate cărțile
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    // Returnează o carte după ID — aici NU se folosește @PathVariable!!!
    public Book getBook(Long id) {
        return booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // Actualizează o carte existentă
    public Optional<Book> updateBook(Long id, Book newBook) {
        return booksRepository.findById(id).map(existing -> {
            newBook.setId(existing.getId());
            return booksRepository.save(newBook);
        });
    }

    // Șterge o carte
    public boolean deleteBook(Long id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
