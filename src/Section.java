import java.util.ArrayList;
import java.util.List;

public class Section extends Element {
    private String title;
    private List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void add(Element e) {
        elements.add(e);
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element e : elements) {
            e.print();
        }
    }
}
