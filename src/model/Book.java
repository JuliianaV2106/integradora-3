package model;
import java.time.LocalDate;
public class Book extends BibligraphicProduct{
    
    private BookGander gander;
    private double valueBook ;
    private int copiesBookSold;
    
    public Book(String productID, String productName, LocalDate publicationDate, int numberPag, String url,
    String description, BookGander gander, double valueBook) {
        super(productID, productName, publicationDate, numberPag, url, description );
        this.gander = gander;
        this.valueBook = valueBook;
    }
    public Book(Book book){
        super(book.getProductID(),book.getProductName(),book.getPublicationDate(),book.getNumberPag(),book.getUrl(),book.getDescription());
        this.gander = book.getGander();
        this.valueBook = book.getValueBook();
    }
    public BookGander getGander() {
        return gander;
    }
    public void setGander(BookGander gander) {
        this.gander = gander;
    }
    public double getValueBook() {
        return valueBook;
    }
    public void setValueBook(double valueBook) {
        this.valueBook = valueBook;
    }
    public int getCopiesBookSold() {
        return copiesBookSold;
    }
    public void setCopiesBookSold(int copiesBookSold) {
        this.copiesBookSold = copiesBookSold;
    }
    public void buyBook() {
         copiesBookSold++;
    }    
}
