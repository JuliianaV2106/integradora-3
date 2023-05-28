package model;
import java.time.LocalDate;
public abstract class User {
    private String[][] library;
    private String id;
    private String name;
    private LocalDate vinculationDate;
    
    public String show() {
    /**
     * The function returns a formatted string representation of a library's contents.
     * 
     * @return The method `show()` returns a String that represents the library with its name and a
     * table of books organized by their location in the library.
     */
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

   /**
    * This is an abstract method in Java that takes an object of type Affordable as a parameter and
    * represents the action of buying something.
    * 
    * @param bill The parameter "bill" in the method signature represents an object of type
    * "Affordable". This method is abstract, which means that it does not have an implementation in the
    * current class and must be implemented by any concrete class that extends this abstract class. The
    * purpose of this method is to allow the implementation
    */
    public abstract void buy(Affordable bill);

  
    
}
