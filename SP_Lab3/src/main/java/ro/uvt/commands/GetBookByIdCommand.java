package ro.uvt.commands;

import lombok.AllArgsConstructor;
import ro.uvt.services.BooksService;

@AllArgsConstructor
public class GetBookByIdCommand implements Command {

    private final BooksService service;
    private final Long id; // ❗ trebuie Long, nu Integer

    @Override
    public Object execute() {
        return service.getBook(id); // ✔ Asta e metoda corectă din BooksService
    }
}
