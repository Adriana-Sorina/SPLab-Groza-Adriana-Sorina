// Clasa Book
public class Book {
    // Câmp privat pentru titlu
    private String title;

    // Constructor
    public Book(String title) {
        this.title = title;
    }

    // Metodă publică pentru a obține titlul
    public String getTitle() {
        return title;
    }

    // Optional: metodă pentru a schimba titlul
    public void setTitle(String title) {
        this.title = title;
    }

    // Metodă main pentru test
    public static void main(String[] args) {
        // Creăm un obiect Book
        Book carte = new Book("Micul Prinț");

        // Afișăm titlul folosind getTitle()
        System.out.println("Titlul cărții este: " + carte.getTitle());

        // Schimbăm titlul
        carte.setTitle("Harry Potter");

        // Afișăm din nou
        System.out.println("Titlul actualizat este: " + carte.getTitle());
    }
}
