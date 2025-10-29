package ro.uvt.commands;

import lombok.AllArgsConstructor;
import ro.uvt.services.BooksService;

@AllArgsConstructor
public class GetBookByIdCommand implements Command {

    private final BooksService service;
    private final Integer id; // <--- schimbat din Long în Integer

    @Override
    public Object execute() {
        return service.getBookById(id);
    }
}
