package model;
import java.time.LocalDate;
public class Magazine extends BibligraphicProduct{

    private MagazineCategory category;
    private Periodicity periodicity;
    private double suscriptionValue;
    private int subcriptionActive;
    
    public Magazine(String productID, String productName, LocalDate publicationDate, int numberPag, String url,
            String description, MagazineCategory category, Periodicity periodicity,
            double suscriptionValue) {
        super(productID, productName, publicationDate, numberPag, url, description);
        this.category = category;
        this.periodicity = periodicity;
        this.suscriptionValue = suscriptionValue;
            }
            public Magazine(Magazine magazine){
            super(magazine.getProductID(),magazine.getProductName(),magazine.getPublicationDate(),
            magazine.getNumberPag(),magazine.getUrl(),magazine.getDescription());
            this.category = magazine.getCategory();
            this.periodicity = magazine.getPeriodicity();
            this.suscriptionValue = magazine.getSuscriptionValue();
            }
    public MagazineCategory getCategory() {
        return category;
    }
    public void setCategory(MagazineCategory category) {
        this.category = category;
    }
    public Periodicity getPeriodicity() {
        return periodicity;
    }
    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
    public double getSuscriptionValue() {
        return suscriptionValue;
    }
    public void setSuscriptionValue(double suscriptionValue) {
        this.suscriptionValue = suscriptionValue;
    }
    public int getSubcriptionActive() {
        return subcriptionActive;
    }
    public void setSubcriptionActive(int subcriptionActive) {
        this.subcriptionActive = subcriptionActive;
    }
    public void suscribeMagazine() {
        subcriptionActive++;
    }
    
   
}
    
    

    

    
    

