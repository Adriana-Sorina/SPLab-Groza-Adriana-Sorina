package ro.uvt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uvt.models.Author;
import ro.uvt.persistence.AuthorsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    // ✅ Creează un autor nou
    public Author createAuthor(Author author) {
        return authorsRepository.save(author);
    }

    // ✅ Returnează toți autorii
    public List<Author> getAllAuthors() {
        return authorsRepository.findAll();
    }

    // ✅ Găsește un autor după ID
    public Optional<Author> getAuthorById(Integer id) {
        return authorsRepository.findById(id);
    }

    // ✅ Actualizează un autor existent
    public Optional<Author> updateAuthor(Integer id, Author newAuthor) {
        return authorsRepository.findById(id).map(existing -> {
            newAuthor.setId(existing.getId());
            return authorsRepository.save(newAuthor);
        });
    }

    // ✅ Șterge un autor după ID
    public boolean deleteAuthor(Integer id) {
        if (authorsRepository.existsById(id)) {
            authorsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
