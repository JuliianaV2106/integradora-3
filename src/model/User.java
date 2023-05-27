package model;
import java.time.LocalDate;
public abstract class User {


    private String[][] library;
    private String id;
    private String name;
    private LocalDate vinculationDate;
    
    public String show() {
        String msg = "This is yor library : " + this.getName() + "\n";
        msg = String.format("%4s | %4s | %4s | %4s | %4s | %4s |", "_", "0", "1", "2", "3", "4");


        for (int i = 0; i < library.length; i++) {
            msg +="\n"+ i + " |";
            for (int j = 0; j < library[i].length; j++) {
                if (library[i][j] == null) {
                    msg += String.format(" %4s |", "___");
                } else {
                    msg += String.format(" %4s |", library[i][j]);
                }
            }
        }
        return msg;
    }
    
    public User(String id, String name, LocalDate vinculationDate) {
        this.id = id;
        this.name = name;
        this.vinculationDate = vinculationDate;
        this.library = new String[5][5];
    }
    
    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getVinculationDate() {
        return vinculationDate;
    }

    public void setVinculationDate(LocalDate vinculationDate) {
        this.vinculationDate = vinculationDate;
    }
    public String[][] getLibrary() {
        return library;
    }

    public void setLibrary(String[][] library) {
        this.library = library;
    }

    public abstract void buy(Affordable affordable);

  
    
}
