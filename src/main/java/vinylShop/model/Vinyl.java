package vinylShop.model;

public class Vinyl {
    private String title;
    private String author;
    private int pieces;
    private String isbn;
    private double price;

    public Vinyl(String title, String author, int pieces, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.pieces = pieces;
        this.isbn = isbn;
        this.price = price;
    }

    public Vinyl() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}