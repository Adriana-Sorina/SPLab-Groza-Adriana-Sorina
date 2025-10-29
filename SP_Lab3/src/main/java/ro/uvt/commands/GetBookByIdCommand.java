package ro.uvt.commands;

import lombok.AllArgsConstructor;
import ro.uvt.services.BooksService;   // ← adaugă această linie!

@AllArgsConstructor
public class GetBookByIdCommand implements Command {

    private final BooksService service;
    private final Long id;

    @Override
    public Object execute() {
        return service.getBookById(id);
    }
}
