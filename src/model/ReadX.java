package model;
import java.util.Random;
import java.time.LocalDate;
import java.util.ArrayList;
public class ReadX {
    private Random random = new Random();
    private ArrayList<BibligraphicProduct> products = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

/**
 * This Java function registers a regular user with an ID, name, and vinculation date and adds them to
 * a list of users.
 * 
 * @param id A unique identifier for the regular user being registered.
 * @param name The name of the regular user being registered.
 * @param vinculationDate vinculationDate is a String parameter representing the date on which the user
 * is being registered. It is parsed into a LocalDate object using the `LocalDate.parse()` method.
 * @return The method is returning a String message "User registered successfully".
 */
    public String regularUserRegister(String id, String name, String vinculationDate){
        LocalDate date = LocalDate.parse(vinculationDate);
        User obj = new RegularUser( id, name, date);
        getUsers().add(obj);
        return "User registered successfully";
    }


   /**
    * The function registers a new premium user with the given ID, name, and vinculation date.
    * 
    * @param id A unique identifier for the premium user being registered.
    * @param name The name of the premium user being registered.
    * @param vinculationDate vinculationDate is a String parameter representing the date on which the
    * PremiumUser is being registered. It is parsed into a LocalDate object using the LocalDate.parse()
    * method.
    * @return The method is returning a String message "User registered successfully".
    */
    public String premiumUserRegister(String id, String name, String vinculationDate){
        LocalDate date = LocalDate.parse(vinculationDate);
        User obj = new PremiumUser( id, name, date);
        getUsers().add(obj);
        return "User registered successfully";
    }

    /**
     * The function registers a book with its details and adds it to a list of products.
     * 
     * @param id A unique identifier for the book.
     * @param name The name of the book being registered.
     * @param description The description parameter is a String that describes the book being
     * registered. It may include information about the plot, genre, author, or any other relevant
     * details about the book.
     * @param publicationDate The publication date of the book in the format of "yyyy-MM-dd".
     * @param gander "gander" is a parameter that represents the gender or category of the book. It is
     * passed as a String and then converted to an enum type "BookGander" using the "valueOf" method.
     * The "BookGander" enum type is used to categorize books into different genres such as
     * @param url The "url" parameter in the "bookRegister" method is a String variable that represents
     * the URL (Uniform Resource Locator) of the book. It is used to store the web address of the
     * book's online location, if applicable.
     * @param saleValue The parameter "saleValue" is not used in the given method, so it is not
     * relevant to the book registration process.
     * @param numberPag The parameter "numberPag" represents the number of pages in the book being
     * registered.
     * @return The method is returning a String message "Book registered successfully".
     */
    public String bookRegister(String id, String name, String description, String publicationDate, String gander, String url, double saleValue, int numberPag){
        LocalDate date = LocalDate.parse(publicationDate);
        BookGander ganderX = BookGander.valueOf(gander);
        BibligraphicProduct obj = new Book(id, name, date, numberPag, url, description, ganderX, numberPag);
        getProducts().add(obj);
        return "Book registered successfully";
    }

    /**
     * The function registers a new magazine with its details and adds it to a list of products.
     * 
     * @param id A unique identifier for the magazine.
     * @param name The name of the magazine being registered.
     * @param publicationDate The date of publication of the magazine in the format "yyyy-MM-dd".
     * @param category The category of the magazine, represented as a String. It is later converted to
     * the enum type MagazineCategory.
     * @param url The URL is a string that represents the web address of the magazine's website or
     * online version.
     * @param periodicity The frequency at which the magazine is published, such as "daily", "weekly",
     * "monthly", etc.
     * @param suscriptionValue The subscription value is the amount of money that a person has to pay
     * to subscribe to the magazine for a certain period of time.
     * @param numberPag numberPag refers to the number of pages in the magazine.
     * @return The method is returning a String message "Magazine registered successfully" after adding
     * a new Magazine object to the list of products.
     */
    public String magazineRegister(String id, String name, String publicationDate, String category, String url, String periodicity, double suscriptionValue,  int numberPag ){
        LocalDate date = LocalDate.parse(publicationDate);
        Periodicity periodicity1 = Periodicity.valueOf(periodicity);
        MagazineCategory category1 = MagazineCategory.valueOf(category);
        BibligraphicProduct obj = new Magazine(id, name, date, numberPag, url, periodicity, category1, periodicity1, suscriptionValue);
        getProducts().add(obj);
        return "Magazine registered successfully";  
    }

    /**
     * This function validates if a given product ID belongs to a book in a list of products.
     * 
     * @param productID a String representing the ID of a book product that needs to be validated.
     * @return The method is returning a boolean value, which indicates whether the given product ID is
     * valid or not. If the product ID matches with the ID of any book in the list of products, the
     * method returns true, otherwise it returns false.
     */
    public boolean validateBookID(String productID){
        boolean validate = false;
        for(int i=0; i < products.size(); i++){
            if(products.get(i) instanceof Book ){
                if(products.get(i).getProductID().equals(productID)){
                    validate = true;
                }
                }
            }
            return validate;
        }

    /**
     * This function checks if a given product ID belongs to a magazine in a list of products.
     * 
     * @param productID A String representing the ID of a magazine product that needs to be validated.
     * @return A boolean value indicating whether the given product ID is valid or not.
     */
    public boolean validateMagazineID(String productID){
       boolean validate = false;
        for(int i=0; i < products.size(); i++){
            if(products.get(i) instanceof Magazine ){
                if(products.get(i).getProductID().equals(productID)){
                    validate = true;
                }
                }
            }
            return validate;
        }
    
    /**
     * This Java function validates whether a given product ID is a valid hexadecimal string of length
     * 3.
     * 
     * @param productID a string representing a product ID in hexadecimal format, consisting of three
     * characters.
     * @return The method is returning a boolean value, which indicates whether the input string is a
     * valid hexadecimal string or not.
     */
    public boolean validateHexadecimal(String productID){
        boolean validate = false;
            if(productID.length() != 3){
                validate = false;  
            }
            for (int i=0; i < productID.length(); i ++){
               char letter = productID.charAt(i);
                
                if(letter >= '0' && letter <= '9' || letter >= 'A' && letter <= 'F' || letter >= 'a' && letter <= 'f'){
                    validate = true;
                }else{
                    validate = false;
                }
            }  
            return validate;
    }

    /**
     * The function checks if a given string contains only alphanumeric characters.
     * 
     * @param product The input string that needs to be validated for containing only alphanumeric
     * characters.
     * @return The method is returning a boolean value, which indicates whether the input string
     * contains only alphanumeric characters (letters and/or numbers). If the string contains any other
     * characters, the method returns false.
     */
    public boolean validateAlfanumerical(String product){
        boolean validate = true;
        for (int i=0; i < product.length(); i ++){
            char letter = product.charAt(i);
            if(!(letter >= '0' && letter <= '9' || letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z')){
                validate = false;
        }
     }
     return validate;
    }

    /**
     * This Java function modifies a book object based on the specified information and returns a
     * message indicating whether the modification was successful or not.
     * 
     * @param productID A string representing the unique identifier of a book.
     * @param info an integer representing which information of the book to modify (1 for product ID, 2
     * for product name, 3 for publication date, 4 for URL, 5 for description, 6 for number of pages, 7
     * for value of the book, 8 for book gander)
     * @param modified The new value that will replace the existing value of the book's information.
     * @return The method is returning a String message indicating whether the book was modified
     * successfully or if it does not exist.
     */
    public String modifyBook(String productID, int info, String modified){
    String msg= "";
    Book obj = searchBook(productID);
    if (obj == null){
        msg = "The book does not exist";
    }
        else{ 
        switch (info){
            case 1:
                obj.setProductID(modified);
                break;
            case 2:
                obj.setProductName(modified);
                break;
            case 3:
                obj.setPublicationDate(LocalDate.parse(modified));
                break;
            case 4:
                obj.setUrl(modified);
                break;
            case 5:
                obj.setDescription(modified);
                break;
            case 6:
                obj.setNumberPag(Integer.parseInt(modified));
                break;
            case 7:
                obj.setValueBook(Double.parseDouble(modified));
                break;
            case 8:
                obj.setGander(BookGander.valueOf(modified));
                break;
            }
            msg = "The book was modified successfully";
        }
        return msg;
    }
    
    /**
     * This function modifies a magazine object based on the given information and returns a message
     * indicating whether the modification was successful or not.
     * 
     * @param productID A string representing the ID of the magazine to be modified.
     * @param info an integer representing the type of information to modify in the Magazine object.
     * The possible values are:
     * @param modified The new value that will replace the current value of the specified information
     * (info) for the magazine with the given productID.
     * @return The method is returning a String message indicating whether the magazine was modified
     * successfully or not.
     */
    public String modifyMagazine(String productID, int info, String modified){
        String msg = "";
        Magazine obj = searchMagazine(productID);
        if (obj == null){
            msg = "The magazine does not exist";
        }
        else{
        switch (info){
            case 1:
                obj.setProductID(modified);
                break;
            case 2:
                obj.setProductName(modified);
                break;
            case 3:
                obj.setPublicationDate(LocalDate.parse(modified));;
                break;
            case 4:
                obj.setUrl(modified);
                break;
            case 5:
                obj.setDescription(modified);
                break;
            case 6:
                obj.setNumberPag(Integer.parseInt(modified));
                break;
            case 7:
                obj.setSuscriptionValue(Double.parseDouble(modified));
                break;
            case 8:
                obj.setCategory(MagazineCategory.valueOf(modified));
                break;
            case 9:
                obj.setPeriodicity(Periodicity.valueOf(modified));
                break;
            }
            msg = "The magazine was modified successfully";  
        }
     return msg;
    }

   /**
    * This Java function searches for a book in a list of products based on its product ID and returns
    * the book object if found.
    * 
    * @param productID a String representing the unique identifier of the book being searched for.
    * @return The method `searchBook` returns a `Book` object.
    */
    public Book searchBook(String productID){
        Book obj = null;
        for(int i=0; i < products.size(); i++){
            if(products.get(i) instanceof Book ){
                BibligraphicProduct actual= products.get(i);
                if(actual instanceof Book && actual.getProductID().equals(productID)){
                    obj = (Book) actual;
                    break;
                }
            }
        }
            return obj;
    }

/**
 * This Java function searches for a magazine object in a list of products based on a given product ID.
 * 
 * @param productID a String variable representing the unique identifier of a magazine product that
 * needs to be searched in a list of products. The method returns a Magazine object that matches the
 * given productID.
 * @return The method is returning a Magazine object that matches the given productID. If no Magazine
 * object is found with the given productID, the method returns null.
 */
public Magazine searchMagazine(String productID){
        Magazine obj = null;
        for(int i=0; i < products.size(); i++){
                BibligraphicProduct actual= products.get(i);
                if(actual instanceof Magazine && actual.getProductID().equals(productID)){
                    obj = (Magazine) actual;
                    break;
                }
        }
            return obj;
    }

    /**
     * This Java function deletes a product from a list of products based on its ID and returns a
     * success message.
     * 
     * @param productID a String representing the unique identifier of the product that needs to be
     * deleted from a list of products.
     * @return The method is returning a String message "Product deleted successfully" after deleting
     * the product with the given productID from the products list.
     */
    public String deleteProduct (String productID){

       for (int i=0; i < products.size(); i++){
              if(products.get(i).getProductID().equals(productID)){
                products.remove(i);
              }   
       }
       return "Product deleted successfully";
    }
     
   /**
    * This Java function allows a user to purchase a product if they have enough funds and updates
    * their account accordingly.
    * 
    * @param id The ID of the user who wants to purchase the product.
    * @param productID The ID of the product that the user wants to purchase.
    * @return The method is returning a String message indicating whether the product has been
    * successfully purchased or not. If the product is successfully purchased, the message will be "The
    * product has been successfully purchased". If the product cannot be purchased, the message will be
    * "Could not add product".
    */
    public String affordarProduct(String id, String productID){
            for(int j=0; j<users.size();j++ ){
                if (users.get(j).getid().equals(id)) {  
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).getProductID().equals(productID)) {
                            
                            double cost = 0.0;
                            BibligraphicProduct buyedProduct = null;
                            LocalDate date = LocalDate.now();
                            if(products.get(i) instanceof Magazine){
                                ((Magazine)products.get(i)).affordar();
                                cost = ((Magazine)products.get(i)).getSuscriptionValue();
                                buyedProduct = new Magazine((Magazine)products.get(i));
                                
                            } else if(products.get(i) instanceof Book){
                                ((Book)products.get(i)).affordar();
                                cost = ((Book)products.get(i)).getValueBook();
                                buyedProduct = new Book((Book)products.get(i));	
                            }
                            Bill bill = new Bill((Affordable)products.get(i),cost, date);
                            if (users.get(j) instanceof RegularUser) {
                                ((RegularUser)users.get(j)).buy((Affordable)buyedProduct);
                            } else {
                                ((PremiumUser)users.get(j)).buy((Affordable)buyedProduct);
                            }
                            return "The product has been successfully purchased";
                        } 
                    }
                }
            }
            return "Could not add product"; 
    }

    /**
     * The function creates automatic products, including a book and a magazine, with specific details
     * and adds them to a list of products.
     * 
     * @return The method is returning a String message "The following products have been created".
     */
    public String createAutomaticProducts(){
        LocalDate date = LocalDate.now();
       products.add(new Book("1AC", "Narnia", date, 100,"www.Narnia.org","The Chronicles of Narnia is a heptalogy of children's books written by the Anglo-Irish writer and teacher C. S. Lewis between 1950 and 1956, and illustrated, in its original version, by Pauline Baynes.",BookGander.SCIENCEFICTION, 45000.0));
       
       products.add(new Magazine("2BA", "QHubo", date,100,"www.org.com","In Q'hubo Cali you will find all the news on sports, public order and trends and entertainment from Cali, Valle del Cauca and Colombi", MagazineCategory.DESING, Periodicity.WEEKLY,60000.0));
       return "The following products have been created";
    }

    /**
     * This function reads a certain number of pages of a given product and updates the user's reading
     * progress, while also generating a commercial message if the user has read a certain number of
     * pages.
     * 
     * @param productID a String representing the ID of the product being read
     * @param numberPagRead The current page number being read by the user.
     * @param id The username or ID of the user who is reading the product.
     * @return The method returns a String message that depends on the input parameters and the state
     * of the system. The possible messages are:
     * - "You can't go back, you're on the first page of the book."
     * - "Username does not exist"
     * - "You can not advance the page, you are in the last one"
     * - A message that includes the title of the product, the number of pages
     */
    public String readSimulation(String productID, int numberPagRead, String id){
        String msg = "";
        if(numberPagRead<=0){
            return "You can't go back, you're on the first page of the book.";
        }
        BibligraphicProduct x = null;
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getid().equalsIgnoreCase(id)){
                user = users.get(i);
            }
        }
        if(user == null){
            return "Username does not exist";
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID().equalsIgnoreCase(productID)) {
                x = products.get(i);
                if (numberPagRead>x.getNumberPag()) {
                    return "You can not advance the page, you are in the last one";
                }
                x.setNumberPagRead(x.getNumberPagRead()+1);
                if(user instanceof RegularUser){
                    if(x instanceof Book){
                        ((RegularUser)user).setReadPagBook(((RegularUser)user).getReadPagBook()+1);
                        if(((RegularUser)user).getReadPagBook()>20){
                            msg = Comersiable.comersiales[(random.nextInt( Comersiable.comersiales.length))] + "\n";
                            ((RegularUser)user).setReadPagBook(0);
                        }
                    }
                    if(x instanceof Magazine){
                        ((RegularUser)user).setReadPagMagazine(((RegularUser)user).getReadPagMagazine()+1);
                        if(((RegularUser)user).getReadPagMagazine()>5){
                            msg = Comersiable.comersiales[(random.nextInt( Comersiable.comersiales.length))] + "\n";
                            ((RegularUser)user).setReadPagMagazine(0);
                        }
                    }
                }
                msg += "Tittle " + x.getProductName() + "\n" + "Pages read: "+ numberPagRead + "\n";
                return msg;
            }
        }
        return "ERROR";
    }


   /**
    * The function calculates the total number of pages read in books and magazines from a list of
    * products.
    * 
    * @return The method is returning a String that contains the total number of pages read in books
    * and magazines.
    */
    public String acumulateReadPag(){
        int pagBook = 0;
        int pagMagazine = 0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Book){
                pagBook += products.get(i).getNumberPagRead(); 
            }else{
                pagMagazine += products.get(i).getNumberPagRead();
            }
        }
        return "The total number of pages read in books is: " + pagBook + "and the total number of pages read in magazines is: " + pagMagazine;
    }
    
    /**
     * This Java function returns the most read book genre and magazine category based on the amount of
     * pages read.
     * 
     * @return The method is returning a String that contains information about the most read book
     * genre and magazine category, along with the number of pages read for each.
     */
    public String mostRead(){
        String[][] generos = new String[BookGander.values().length][2];
        String[][] categorias = new String[MagazineCategory.values().length][2];
        for (int i = 0; i < generos.length; i++) {
            generos[i][0] = String.valueOf(BookGander.values()[i]); 
            generos[i][1] = amountPagGenre(BookGander.values()[i]) + "";
        }
        for (int i = 0; i < categorias.length; i++) {
            categorias[i][0] = String.valueOf(MagazineCategory.values()[i]);
            categorias[i][1] = String.valueOf(amountPagCategory(MagazineCategory.values()[i]));
        }
        String txt2 = "";
        String[][] mayores = new String[2][2];
        int x = 0;
        for(int i = 0;i<generos.length;i++){
            if(Double.parseDouble(generos[i][1])>Double.parseDouble(generos[x][1])){
                x = i;
            }
        }
        mayores[0][0] = "Most read gander: " + generos[x][0];
        mayores[0][1] = " pag reads: " + generos[x][1];
        for(int i = 0;i<categorias.length;i++){
            if(Double.parseDouble(categorias[i][1])>Double.parseDouble(categorias[x][1])){
                x = i;
            }
        }
        mayores[1][0] = "Most read Category: " + categorias[x][0];
        mayores[1][1] = " pag reads: " + categorias[x][1];
        
        for(int i = 0;i<mayores.length; i++){
            for(int j = 0;j<mayores[i].length; j++){
                txt2 +=  mayores[i][j];
            }
            txt2 += "\n";
        }
        return txt2;
    }


    /**
     * This Java function calculates the total number of pages read for a given book genre.
     * 
     * @param z The parameter "z" is an object of the BookGander class, which is used to specify the
     * gender of the book for which the total number of pages needs to be calculated.
     * @return The method is returning an integer value which represents the total number of pages read
     * for books of a specific genre (specified by the BookGander parameter).
     */
    public int amountPagGenre(BookGander z){
        int suma = 0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Book){
                if(((Book)products.get(i)).getGander() == z){
                    suma += ((Book)products.get(i)).getNumberPagRead();
                }
            }
        }
        return suma;
    }
    
    /**
     * This Java function calculates the total number of pages in magazines belonging to a specific
     * category.
     * 
     * @param z The parameter "z" is of type MagazineCategory, which is an enum representing the
     * category of a magazine (e.g. sports, fashion, technology, etc.). It is used to filter the
     * magazines in the products list and calculate the total number of pages for magazines in the
     * specified category.
     * @return The method `amountPagCategory` returns an integer value which represents the total
     * number of pages of magazines in the specified category `z`.
     */
    public int amountPagCategory(MagazineCategory z){
        int suma = 0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Magazine){
                if(((Magazine)products.get(i)).getCategory() == z){
                    suma += ((Magazine)products.get(i)).getNumberPagRead();
                }
            }
        }
        return suma;
    }
    
    /**
     * This Java function returns the top 5 books based on the number of pages read, along with their
     * name, genre, and number of pages.
     * 
     * @return The method is returning a String message that contains the names, number of pages read,
     * and genre of the top 5 books in the products list.
     */
    public String top5book(){
        Book[] top5Books = new Book[5];
        String msg = "";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Book) {
                Book actual = (Book) products.get(i);
                int count = -1;
                for (int j = 0; j < top5Books.length; j++) {
                    if (top5Books[j] == null || actual.getNumberPagRead() > top5Books[j].getNumberPagRead()) {
                        count = j;
                        break;
                    }
                }
                if (count != -1) {
                    
                    for (int k = top5Books.length - 2; k >= count; k--) {
                        top5Books[k + 1] = top5Books[k];
                    }
                    top5Books[count] = actual;
                }
            }
        }
        for (Book book : top5Books) {
            if (book != null) {
                msg += "The name of the book is: " + book.getProductName() + " pages read: " + book.getNumberPagRead()
                        + "  genre: " + book.getGander() + "\n";
            }
        }

        return msg;
    }
        

    /**
     * This Java function returns the top 5 magazines based on the number of pages read.
     * 
     * @return The method is returning a String that contains information about the top 5 magazines
     * based on the number of pages read. The String includes the name of the magazine, the number of
     * pages read, and the category.
     */
    /**
     * This Java function returns the top 5 magazines based on the number of pages read.
     * 
     * @return The method is returning a String that contains information about the top 5 magazines
     * based on the number of pages read. The String includes the name of the magazine, the number of
     * pages read, and the category.
     */
    public String top5Magazine(){
        Magazine[] top5Magazines = new Magazine[5];
        String msg = "";

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Magazine) {
                Magazine actual = (Magazine) products.get(i);

                int count = -1;
                for (int j = 0; j < top5Magazines.length; j++) {
                    if (top5Magazines[j] == null
                            || actual.getNumberPagRead() > top5Magazines[j].getNumberPagRead()) {
                        count = j;
                        break;
                    }
                }
                if (count != -1) {
                    for (int k = top5Magazines.length - 2; k >= count; k--) {
                        top5Magazines[k + 1] = top5Magazines[k];
                    }
                    top5Magazines[count] = actual;
                }
            }
        }
        for (Magazine magazine : top5Magazines) {
            if (magazine != null) {
                msg += "The name of the magazine is " + magazine.getProductName() + " pages read: " + magazine.getNumberPagRead()
                        + "  category: " + magazine.getCategory() + "\n";
            }
        }
        return msg;
        }
    
    /**
     * The function returns a string containing information about the sales of books by gender.
     * 
     * @return The method `infoGanderBook` returns a string that represents a matrix containing
     * information about the sales of books by gender.
     */
    public String infoGanderBook(){
        String [][] infoB = new String[3][BookGander.values().length];
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Book){
               for (int j = 0; j < infoB[0].length; j++) {
                infoB[0][j]= BookGander.values()[j].toString();
                infoB[1][j]= String.valueOf(numberCopiesSoldforGander(BookGander.values()[j]));
                infoB[2][j]= String.valueOf(totalSoldBook(BookGander.values()[j]));
               }
            }
        }
        return showMatriz(infoB); 
    }
    /**
     * The function returns the total number of copies sold for a specific book gander.
     * 
     * @param gander The parameter "gander" is an instance of the BookGander enum class, which
     * represents the gender or target audience of a book (e.g. male, female, children). The method
     * "numberCopiesSoldforGander" takes in a BookGander object as input and returns the
     * @return The method is returning an integer value which represents the total number of copies
     * sold for a specific book gander (either male or female).
     */
    public int numberCopiesSoldforGander(BookGander gander){
        int copiesSold = 0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Book){
                if(((Book)products.get(i)).getGander().equals(gander)){
                    copiesSold += ((Book)products.get(i)).getCopiesBookSold();
                }
            }
        }
        return copiesSold;
    }
    /**
     * The function calculates the total revenue generated from selling books of a specific gender.
     * 
     * @param gander The parameter "gander" is likely referring to the gender of the book's intended
     * audience. It is used to calculate the total amount of money earned from selling books of a
     * specific gender.
     * @return The method `totalSoldBook` returns a `double` value which represents the total amount of
     * money earned from selling books of a specific gender (`gander`).
     */
    public double totalSoldBook(BookGander gander){
        double totalB = 0.0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Book){
                if(((Book)products.get(i)).getGander().equals(gander)){
                    totalB += ((Book)products.get(i)).getCopiesBookSold()*((Book)products.get(i)).getValueBook();
                }
            }
        }
        return totalB;
    }
    /**
     * The function returns a string that contains information about the number of active subscriptions
     * and total sold magazines for each category.
     * 
     * @return The method `infoCategoryMagazine()` is returning a string that represents a matrix of
     * information about the different categories of magazines. The matrix contains three rows: the
     * first row contains the names of the categories, the second row contains the number of active
     * subscriptions for each category, and the third row contains the total number of magazines sold
     * for each category.
     */
    public String infoCategoryMagazine(){
        String [][] infoM = new String[3][MagazineCategory.values().length];
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Magazine){
               for (int j = 0; j < infoM[0].length; j++) {
                infoM[0][j]= MagazineCategory.values()[j].toString();
                infoM[1][j]= String.valueOf(numberSuscritionActive(MagazineCategory.values()[j]));
                infoM[2][j]= String.valueOf(totalSoldMagazine(MagazineCategory.values()[j]));
               }
            }
        }
        return showMatriz(infoM); 
    }
    /**
     * This function returns the total number of active subscriptions for a given magazine category.
     * 
     * @param category a MagazineCategory enum representing the category of magazines to count the
     * number of active subscriptions for.
     * @return The method is returning an integer value which represents the total number of active
     * subscriptions for magazines in the specified category.
     */
    public int numberSuscritionActive(MagazineCategory category){
        int susActive = 0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Magazine){
                if(((Magazine)products.get(i)).getCategory().equals(category)){
                    susActive += ((Magazine)products.get(i)).getSubcriptionActive();
                }
            }
        }
        return susActive;
    }
    /**
     * This function calculates the total revenue generated by a specific category of magazines based
     * on the number of active subscriptions and their subscription value.
     * 
     * @param category The category of the magazine for which the total sold value needs to be
     * calculated.
     * @return The method `totalSoldMagazine` returns a `double` value which represents the total
     * amount of money earned from selling magazines of a specific category.
     */
    public double totalSoldMagazine(MagazineCategory category){
        double totalM = 0.0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i) instanceof Magazine){
                if(((Magazine)products.get(i)).getCategory().equals(category)){
                    totalM += ((Magazine)products.get(i)).getSubcriptionActive()*((Magazine)products.get(i)).getSuscriptionValue();
                }
            }
        }
        return totalM;
    }

    /**
     * The function takes a 2D array of strings and returns a string representation of the array with
     * each element separated by a space and each row separated by a newline character.
     * 
     * @param matriz a 2-dimensional array of Strings that represents a matrix.
     * @return The method `showMatriz` returns a string representation of a 2D array of strings
     * (`String[][]`). The string contains the elements of the array separated by spaces and new lines
     * to represent the rows and columns of the array.
     */
    public String showMatriz(String[][] matriz){
        String matrizString = "";
        for (int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++){
                matrizString += matriz[i][j] + " ";
            }
            matrizString += "\n";
        }
        return matrizString;
    }
    /**
     * The function returns a string containing the product IDs of all the books in a list of products.
     * 
     * @return The method `showIdBooks()` returns a string containing the product IDs of all the
     * products in the `products` list that are instances of the `Book` class.
     */
    public String showIdBooks() {
        String msj = "";
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Book) {
                msj += products.get(i).getProductID() + "\n";
            }
        }
        return msj;
    }
    /**
     * This Java function returns a string containing the product IDs of all Magazine objects in a list
     * of products.
     * 
     * @return The method `showIdMagazine()` returns a string containing the product IDs of all the
     * Magazine objects in the `products` list.
     */
    public String showIdMagazine() {
        String msj = "";
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Magazine) {
                msj += products.get(i).getProductID() + "\n";
            }
        }
        return msj;
    }

    
    /**
     * This Java function adds a book or magazine to a user's library if the user exists and the
     * product ID is valid.
     * 
     * @param idUser The ID of the user whose library needs to be updated.
     * @param id The parameter "id" is a String variable representing the ID of a book or magazine that
     * needs to be added to a user's library.
     * @return The method returns a String message indicating whether the product has been successfully
     * added to the user's library or not. The possible messages are "The product has been added", "The
     * product does not exist", and "It has not been possible to add".
     */
    public String saveLibrary(String idUser,String id ){
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getid().equals(idUser)) {
                user = users.get(i);
                break; 
            }
        }

        if (user != null) {
            String[][] library = user.getLibrary();
            for (int i = 0; i < library.length; i++) {
                for (int j = 0; j < library[i].length; j++) {
                    if (library[i][j] == null) {
                        if(validateBookID(id) || validateMagazineID(id)){
                            library[i][j] = id;
                            user.setLibrary(library);
                            return "The product has been added";
                        } else {
                            return "The product does not exist";
                        }

                    }
                }
            }
        }
        return "It has not been possible to add";
    }

    /**
     * This function takes an ID as input and returns the information of the user with that ID or a
     * message indicating that the user does not exist.
     * 
     * @param id The parameter "id" is a String variable that represents the unique identifier of a
     * user in a library system. The method "showLibrary" takes this parameter as input and searches
     * for a user with the matching id in the "users" list. If a user with the matching id is found,
     * the
     * @return If a user with the given ID exists in the "users" list, the method will return the
     * result of calling the "show()" method on that user object. If no user with the given ID is
     * found, the method will return the string "The user does not exist".
     */
    public String showLibrary(String id){
        for (User user2 : users) {
            if(user2.getid().equals(id)){
                return user2.show();
            }
        }
        return "The user does not exist";
    }

    // The above code is a Java method that returns an ArrayList of objects of type
    // "BibligraphicProduct". It also includes a setter method that takes an ArrayList of objects of
    // type "BibligraphicProduct" as a parameter and sets the value of the instance variable "products"
    // to the value of the parameter "products".
    public ArrayList<BibligraphicProduct> getProducts() {
        return products;
    }

    /**
     * This function sets the list of bibliographic products for a given object.
     * 
     * @param products An ArrayList of objects of type BibligraphicProduct. This method sets the value
     * of the instance variable "products" to the value of the parameter "products".
     */
    public void setProducts(ArrayList<BibligraphicProduct> products) {
        this.products = products;
    }

   /**
    * The function returns an ArrayList of User objects.
    * 
    * @return An ArrayList of User objects is being returned.
    */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * This function sets the list of users for a particular object.
     * 
     * @param users The parameter "users" is an ArrayList of objects of type "User". The method
     * "setUsers" sets the value of the instance variable "users" to the value passed as the parameter.
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}   
