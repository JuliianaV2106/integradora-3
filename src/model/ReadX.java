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

    public String bookRegister(String id, String name, String description, String publicationDate, String gander, String url, double saleValue, int numberPag){
        LocalDate date = LocalDate.parse(publicationDate);
        BookGander ganderX = BookGander.valueOf(gander);
        BibligraphicProduct obj = new Book(id, name, date, numberPag, url, description, ganderX, numberPag);
        getProducts().add(obj);
        return "Book registered successfully";
    }

    public String magazineRegister(String id, String name, String publicationDate, String category, String url, String periodicity, double suscriptionValue,  int numberPag ){
        LocalDate date = LocalDate.parse(publicationDate);
        Periodicity periodicity1 = Periodicity.valueOf(periodicity);
        MagazineCategory category1 = MagazineCategory.valueOf(category);
        BibligraphicProduct obj = new Magazine(id, name, date, numberPag, url, periodicity, category1, periodicity1, suscriptionValue);
        getProducts().add(obj);
        return "Magazine registered successfully";  
    }

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

    public String deleteProduct (String productID){

       for (int i=0; i < products.size(); i++){
              if(products.get(i).getProductID().equals(productID)){
                products.remove(i);
              }   
       }
       return "Product deleted successfully";
    }
     
    public String affordarProduct(String id, String productID){
            for(int j=0; j<users.size();j++ ){
                if (users.get(j).getid().equals(id)) {  
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).getProductID().equals(productID)) {
                            
                            double cost = 0.0;
                            BibligraphicProduct buyedProduct = null;
                            LocalDate date = LocalDate.now();
                            if(products.get(i) instanceof Magazine){
                                ((Magazine)products.get(i)).suscribeMagazine();
                                cost = ((Magazine)products.get(i)).getSuscriptionValue();
                                buyedProduct = new Magazine((Magazine)products.get(i));
                                
                            } else if(products.get(i) instanceof Book){
                                ((Book)products.get(i)).buyBook();
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

    public String createAutomaticProducts(){
        LocalDate date = LocalDate.now();
       products.add(new Book("1AC", "Narnia", date, 100,"www.Narnia.org","The Chronicles of Narnia is a heptalogy of children's books written by the Anglo-Irish writer and teacher C. S. Lewis between 1950 and 1956, and illustrated, in its original version, by Pauline Baynes.",BookGander.SCIENCEFICTION, 45000.0));
       
       products.add(new Magazine("2BA", "QHubo", date,100,"www.org.com","In Q'hubo Cali you will find all the news on sports, public order and trends and entertainment from Cali, Valle del Cauca and Colombi", MagazineCategory.DESING, Periodicity.WEEKLY,60000.0));
       return "The following products have been created";
    }

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
    
    public String top5book(){
        Book top5B[] = new Book[5];
        String mg = "";
        for(int i = 0; i < products.size(); i++){
          if(products.get(i) instanceof Book){
            for(int j =0; j < top5B.length; j++){
                if (top5B[j] == null) {
                    top5B[j] = (Book)products.get(i);
                }else if(products.get(i).getNumberPagRead() > top5B[j].getNumberPagRead()){
                    for(int k=top5B.length-2; k!=j; k--){
                        top5B[k+1] = top5B[k];
                        mg += "The boks most read are: " + top5B[k].getProductName()+ "The gander of book is: " +top5B[k].getGander();
                    }
                }
               }       
            }
          }
        return mg;
        }

    public String top5Magazine(){
        Magazine top5M[] = new Magazine[5];
        String mg = "";
        for(int i = 0; i < products.size(); i++){
        if(products.get(i) instanceof Magazine){
            for(int j =0; j < top5M.length; j++){
                if (top5M[j] == null) {
                    top5M[j] = ( Magazine)products.get(i);
                }else if(products.get(i).getNumberPagRead() > top5M[j].getNumberPagRead()){
                    for(int k=top5M.length-2; k!=j; k--){
                        top5M[k+1] = top5M[k];
                        mg += "The boks most read are: " + top5M[k].getProductName()+ "The gander of book is: " +top5M[k].getCategory();
                    }
                }
            }       
            }
        }
        return mg;
        }
    
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
    public String showIdBooks() {
        String msj = "";
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Book) {
                msj += products.get(i).getProductID() + "\n";
            }
        }
        return msj;
    }
    public String showIdMagazine() {
        String msj = "";
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Magazine) {
                msj += products.get(i).getProductID() + "\n";
            }
        }
        return msj;
    }

    
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

    public String showLibrary(String id){
        for (User user2 : users) {
            if(user2.getid().equals(id)){
                return user2.show();
            }
        }
        return "The user does not exist";
    }

    public ArrayList<BibligraphicProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<BibligraphicProduct> products) {
        this.products = products;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}   
