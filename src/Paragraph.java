public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy; // nou: strategia de aliniere

    public Paragraph(String text) {
        this.text = text;
    }

    // metodă nouă pentru a seta strategia de aliniere
    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy == null) {
            System.out.println("Paragraph: " + text);
        } else {
            alignStrategy.render(text);
        }
    }
}
