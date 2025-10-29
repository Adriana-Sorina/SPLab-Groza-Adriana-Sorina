package ro.uvt.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.uvt.models.Author;
import ro.uvt.models.Book;
import ro.uvt.persistence.BooksRepository;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final BooksRepository booksRepository;

    @PostConstruct
    public void loadData() {
        // verificăm dacă baza de date e goală
        if (booksRepository.count() == 0) {
            Author author = new Author();
            author.setName("Adriana Groza");

            Book book = new Book();
            book.setTitle("Primul meu volum JPA");
            book.setAuthors(Collections.singletonList(author));

            booksRepository.save(book);

            System.out.println("✅ DataLoader: Carte + Autor inserați automat în baza de date!");
        } else {
            System.out.println("ℹ️ DataLoader: Baza de date are deja date, nu s-a mai inserat nimic.");
        }
    }
}
