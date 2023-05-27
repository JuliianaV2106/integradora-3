package model;
import java.time.LocalDate;
public class RegularUser extends User {
    
    private int readPagBook;
    private int readPagMagazine;

    Bill [] bills = new Bill[7];
    private Book[] books = new Book[5];
    private Magazine[] magazines = new Magazine[2];

    public RegularUser(String cedula, String name, LocalDate vinculationDate) {
        super(cedula, name, vinculationDate);
        this.readPagBook = 0;
        this.readPagMagazine =0;
        
    }
   
    public int getReadPagBook() {
        return readPagBook;
    }
    public void setReadPagBook(int readPagBook) {
        this.readPagBook = readPagBook;
    }
    public int getReadPagMagazine() {
        return readPagMagazine;
    }
    public void setReadPagMagazine(int readPagMagazine) {
        this.readPagMagazine = readPagMagazine;
    }
   
    public void buy(Affordable affordable){
        if(affordable instanceof Book){
            for(int i = 0; i <books.length; i++){
                if (books[i]==null){
                    books[i]= (Book) affordable;
                }
            }
        }else {
            for (int i=0; i<magazines.length; i++){
                if(magazines[i]==null){
                    magazines[i]= (Magazine) affordable;
                }
            }
        }
    }
}
