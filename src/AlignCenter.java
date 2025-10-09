public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String text) {
        int width = 40;
        int padding = (width - text.length()) / 2;
        String formatted = " ".repeat(Math.max(0, padding)) + text;
        System.out.println(formatted + " ↔");
    }
}
