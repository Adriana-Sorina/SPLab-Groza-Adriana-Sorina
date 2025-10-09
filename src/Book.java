import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

    @Override
    public void print() {
        System.out.println("Book: " + getTitle());
        System.out.println();
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }
        System.out.println();
        super.print();
    }
}
