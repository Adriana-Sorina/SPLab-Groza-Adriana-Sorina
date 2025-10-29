package ro.uvt.commands;

import lombok.AllArgsConstructor;
import ro.uvt.models.Book;
import ro.uvt.services.BooksService;   // <-- Asigură-te că linia asta există

@AllArgsConstructor
public class CreateBookCommand implements Command {

    private final BooksService service;
    private final Book book;

    @Override
    public Object execute() {
        return service.createBook(book);
    }
}
