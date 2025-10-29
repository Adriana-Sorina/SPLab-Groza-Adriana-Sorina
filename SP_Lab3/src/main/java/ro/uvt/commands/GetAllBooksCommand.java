package ro.uvt.commands;

import lombok.AllArgsConstructor;
import ro.uvt.services.BooksService;

@AllArgsConstructor
public class GetAllBooksCommand implements Command {

    private final BooksService service;

    @Override
    public Object execute() {
        return service.getAllBooks();
    }
}
