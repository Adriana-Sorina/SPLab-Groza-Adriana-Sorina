package ro.uvt.commands;

import lombok.AllArgsConstructor;
import ro.uvt.models.Book;
import ro.uvt.services.BooksService;

@AllArgsConstructor
public class UpdateBookCommand implements Command {

    private final BooksService service;
    private final Integer id;   // ← schimbat din Long în Integer
    private final Book book;

    @Override
    public Object execute() {
        return service.updateBook(id, book);
    }
}
