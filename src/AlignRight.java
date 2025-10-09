public class AlignRight implements AlignStrategy {
    @Override
    public void render(String text) {
        int width = 40;
        String formatted = String.format("%" + width + "s", text);
        System.out.println(formatted + " →");
    }
}
