package ro.uvt.commands;

import lombok.AllArgsConstructor;
import ro.uvt.services.BooksService;

@AllArgsConstructor
public class DeleteBookCommand implements Command {

    private final BooksService service;
    private final Long id;

    @Override
    public Object execute() {
        service.deleteBook(id);
        return "Book deleted with id = " + id;
    }
}

