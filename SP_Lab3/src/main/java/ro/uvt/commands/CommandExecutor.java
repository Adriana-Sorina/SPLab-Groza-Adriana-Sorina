package ro.uvt.commands;

import org.springframework.stereotype.Component;
import ro.uvt.services.BooksService;

@Component
public class CommandExecutor {
    public Object execute(Command command) {
        return command.execute();
    }
}
