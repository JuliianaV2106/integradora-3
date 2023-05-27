package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class PremiumUser extends User {
    public ArrayList<BibligraphicProduct> Affordable;
    

    public PremiumUser(String cedula, String name, LocalDate vinculationDate) {
        super(cedula, name, vinculationDate);
       
    }

    public ArrayList<BibligraphicProduct> getAffordable() {
        return Affordable;
    }

    public void setAffordable(ArrayList<BibligraphicProduct> affordable) {
        Affordable = affordable;
    }
    
    @Override
    public void buy(Affordable affordable){
        if (affordable instanceof Book) {
            getAffordable().add((Book) affordable);
        }else {
            getAffordable().add((Magazine) affordable);
        }
    }
    
}

