package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class PremiumUser extends User {
    public ArrayList<BibligraphicProduct> bills;
    

    public PremiumUser(String cedula, String name, LocalDate vinculationDate) {
        super(cedula, name, vinculationDate);
        bills = new ArrayList<>();
       
    }

    public ArrayList<BibligraphicProduct> getBills() {
        return bills;
    }

    public void setAffordable(ArrayList<BibligraphicProduct> bills) {
        this.bills = bills;
    }
    
    @Override
    // This is a method that overrides the `buy` method from the `User` class. It receives an
    // `Affordable` object as a parameter, which can be either a `Book` or a `Magazine`. If it is a
    // `Book`, it is added to the `bills` ArrayList as a `Book` object. If it is a `Magazine`, it is
    // added to the `bills` ArrayList as a `Magazine` object. This method is specific to the
    // `PremiumUser` class, which extends the `User` class.
    public void buy(Affordable bill){
        if (bill instanceof Book) {
            getBills().add((Book) bill);
        }else {
            getBills().add((Magazine) bill);
        }
    }
    
}

