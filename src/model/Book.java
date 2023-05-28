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
        this.copiesBookSold = copiesBookSold;
    }
    // This is a constructor that creates a new `Book` object by copying the properties of an existing
    // `Book` object. It calls the constructor of the superclass `BibligraphicProduct` to copy the
    // common properties, and then sets the specific properties of the `Book` class (`gander`,
    // `valueBook`, and `copiesBookSold`) to the values of the corresponding properties of the input
    // `book` object.
    public Book(Book book){
        super(book.getProductID(),book.getProductName(),book.getPublicationDate(),book.getNumberPag(),book.getUrl(),book.getDescription());
        this.gander = book.getGander();
        this.valueBook = book.getValueBook();
        this.copiesBookSold = book.getCopiesBookSold();
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
    /**
     * The function increments the number of copies of a book sold by one.
     */
    public void affordar() {
        setCopiesBookSold(getCopiesBookSold() + 1);
    }    
}
