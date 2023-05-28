package ui;
import java.util.Scanner;
import model.ReadX;
public class Main {

    private Scanner lector = new Scanner(System.in);
    private static ReadX prototype = new ReadX();

    public static void main(String args[]) {
        Main main = new Main();
        main.menu();
     }
     public void repetirmenu(){
      System.out.println("Do you want to return to the menu? (1 = yes, 2 = no)");
      int option = lector.nextInt();
      if(option == 1){
            menu();
      }
      else{
            System.out.println("THANKS FOR USING THE PROGRAM.");
      }
  }
     public void menu() {
        int x = 0;
        while (x != 1) {
          
           System.out.println("WELCOME TO  RAEADX ");
           System.out.println();
           System.out.println("Next you will see some options, enter the number corresponding to the option you want to perform ");
           System.out.println("1 = REGISTER USER  ");
           System.out.println("2 = REGISTER BIBLIOGRAPHIC PRODUCT");
           System.out.println("3 = MODIFY BIBLIOGRAPHIC PRODUCT");
           System.out.println("4 = DELETE BIBLIOGRAPHIC PRODUCT");
           System.out.println("5 = AUTOMATICALLY GENERATE OBJECTS IN THE SYSTEM FOR EACH TYPE OF USER AND BIBLIOGRAPHIC PRODUCT");
           System.out.println("6 = BUY BOOK OR SUBSCRIBE TO A MAGAZINE");
           System.out.println("7 = SIMULATE READING SECTION");
           System.out.println("8 = SAVE BIBLIOGRAPHIC PRODUCTS IN YOUR LIBRARY ");
           System.out.println("9 = SEE YOUR LIBRARY OF BIBLIOGRAPHIC PRODUCTS");
           System.out.println("10 = REPORT ACCUMULATED TOTAL PAGES READ FOR PRODUCT");
           System.out.println("11=  MOST READ GENRE AND CATEGORY");
           System.out.println("12 = TOP 5 BOOKS AND THE TOP 5 MOST READ MAGAZINES");
           System.out.println("13 = NUMBER OF BOOKS SOLD AND TOTAL SALES VALUE BY GENRE");
           System.out.println("14 = NUMBER OF MAGAZINE SOLD AND TOTAL SALES VALUE BY CATEGORY");

           System.out.println("15 = EXIT THE PROGRAM");
        
           int option = lector.nextInt();
  
           switch (option) {
              case 1:
                  userRegister();
                  repetirmenu();
                
                 break;
                 
              case 2:
                  productRegister();
                  repetirmenu();
                 break;
  
              case 3:
                  modifyProduct();
                  repetirmenu(); 
                 break;
  
              case 4:
                  deleteProduct();     
                  repetirmenu();
                 break;
  
              case 5:
                  createAutomaticProducts();
                  repetirmenu();
                 break;
  
              case 6:
                 affordarProduct();
                  repetirmenu();
                  break;
  
              case 7:
                  readSimulation();
                  repetirmenu();
                  break;
              case 8:
                  saveLibrary();
                  repetirmenu();
                  break;
              case 9:
                  showLibrary();
                  repetirmenu();
                  break;
  
              case 10:
                  acumulateReadPag();
                  repetirmenu(); 
                  break;
              case 11:
                  mostRead();
                  repetirmenu();
                  break;
              case 12:
                   top5Book();
                   top5Magazine();
                  repetirmenu();
                  break;
              case 13:
                  infoGanderBook();
                  repetirmenu();
                  break;

              case 14:
                  infoCategoryMagazine();
                  repetirmenu();
                  break;

              case 15:
              x = 1;
              System.out.println("THANKS FOR USING THE PROGRAM.");
               
                  break;
      
              default:
                 System.out.println("THERE IS AN ERROR");
                 break;
           }
        }
     }

     public void userRegister(){
      String userName, userID; 
      String vinculationDate; 
      lector.nextLine();


      System.out.println("Enter the following data please:");
      System.out.println("User's full name:");
      userName = lector.nextLine();
      System.out.println("user ID:");
      userID = lector.nextLine();
      System.out.println("Vinculation date:(yyyy-mm-dd)");
      vinculationDate= lector.nextLine(); 
      System.out.println("");

      System.out.println("As what type of user do you want to register? (enter the number (1 or 2))");
      System.out.println("1. regular user");
      System.out.println("2. premium user"); 
     
      String userType = lector.nextLine();
      switch(userType){

          case "1":
               System.out.println(prototype.regularUserRegister( userID,userName, vinculationDate));
              break;
          case "2":
              System.out.println(prototype.premiumUserRegister(userID, userName, vinculationDate));
              break; 
      }
  }

   public void productRegister(){
      String productID = "",productName,publicationDate,url,description,periodicity; 
      int numberPag; 
      double saleValue, suscriptionValue;
      lector.nextLine();


      System.out.println("Enter the product name:");
      productName = lector.nextLine();
      System.out.println("Enter the publication date: (yyyy-mm-dd))");
      publicationDate = lector.nextLine();
      System.out.println("Enter the url:");
      url = lector.nextLine();
      System.out.println("Enter a short description of the product:");
      description = lector.nextLine();
      System.out.println("Enter the number of pages:");
      numberPag = lector.nextInt();
      
      System.out.println("As what type of product do you want to register? (enter the number (1 or 2))");
      System.out.println("1. Book");
      System.out.println("2. Magazine"); 
     
      int userType = lector.nextInt();
      switch(userType){
          case 1:
               lector.nextLine();
               System.out.println("Enter the following book data");
               System.out.println("The book's ID (3 hexadecimal characters):");
               productID = lector.nextLine();
               boolean hc = prototype.validateHexadecimal(productID);
               boolean id = prototype.validateBookID(productID);
               if(hc ==false){
                  System.out.println("The id entered is not hexadecimal, please enter a hexadecimal number");
                  productRegister();
               }
               if(id){
                 System.out.println("There is already a registered book with this id enter it again"); 
               }

               System.out.println("The sale value");
               saleValue = lector.nextDouble();
               lector.nextLine();
               System.out.println("The book's gander (SCIENCEFICTION, FANTASY,HISTORICALNOVEL) In capital letters please");
               String gander= lector.nextLine();
               System.out.println(prototype.bookRegister(productID, productName, description, publicationDate, gander, url, saleValue, numberPag));
              break;
          case 2:
              lector.nextLine();
              System.out.println("Enter the following magazine data");
              System.out.println("The product ID (3 alphanumeric characters):");
               productID = lector.nextLine();

               boolean ac = prototype.validateAlfanumerical(productID);
               boolean mid = prototype.validateMagazineID(productID);
               if(ac ==false){
                  System.out.println("The id entered is not alphanumeric, please enter a hexadecimal number");
                  productRegister();
               }
               if(mid){
                 System.out.println("There is already a registered magazine with this id enter it again"); 
               }

              System.out.println("Enter the magazine's category (VARIETIES, DESING, SCIENTIFIC)In capital letters please:)");
              String category = lector.nextLine();
              System.out.println("Enter the periodicity (DAILY, WEEKLY, MONTHLY, QUARTERLY, BIANNUAL, ANNUAL)In capital letters please)");
              periodicity = lector.nextLine();
              System.out.println("Enter a suscription value");
              suscriptionValue = lector.nextDouble(); 

              System.out.println(prototype.magazineRegister(productID, productName, publicationDate, category, url, periodicity, suscriptionValue, numberPag));
              break; 
      }
}
   public void modifyProduct(){
      lector.nextLine();
      String productID, modified;
      int productType, info;
      System.out.println("Enter the number corresponding to the type of bibliographic product you want to modify");
      System.out.println("1. Book");
      System.out.println("2. Magazine");
      productType = lector.nextInt();
      lector.nextLine();

      switch (productType){
         case 1:
            System.out.println("Enter the book ID you want to modify");
            productID = lector.nextLine();

            System.out.println("Which of the book attributes do you want to modify (Enter the corresponding number)?");
            System.out.println("1. id of the book");
            System.out.println("2. name of the book");
            System.out.println("3. publication date of the book");
            System.out.println("4. url of the book");
            System.out.println("5. description of the book");
            System.out.println("6. number of pages of the book");
            System.out.println("7. sale value of the book");
            System.out.println("8. gander of the book");
            info = lector.nextInt();
            lector.nextLine();
            System.out.println("enter the info corresponding to the attribute you want to replace");
            modified = lector.nextLine();
            System.out.println(prototype.modifyBook(productID, info, modified)); 
            break;
   
         case 2:
            System.out.println("Enter the magazine ID you want to modify");
            productID = lector.nextLine();
            
             System.out.println("Which of the book attributes do you want to modify (Enter the corresponding number)?");
            System.out.println("1. id of the magazine");
            System.out.println("2. name of the magazine");
            System.out.println("3. publication date of the magazine");
            System.out.println("4. url of the magazine");
            System.out.println("5. description of the magazine");
            System.out.println("6. number of pages of the magazine");
            System.out.println("7. suscription value of the magazine");
            System.out.println("8. category of the magazine");
            System.out.println("9. periodicity of the magazine");
            info = lector.nextInt();
            System.out.println("enter the number corresponding to the attribute you want to replace");
            modified = lector.nextLine();
            System.out.println(prototype.modifyMagazine(productID, info, modified));
            break;
      }

   }
   public void deleteProduct(){
      lector.nextLine();
      System.out.println("Enter the product ID you want to delete");
      String productID = lector.nextLine();
      System.out.println(prototype.deleteProduct(productID));
   }
   
   public void affordarProduct(){
      lector.nextLine();
      String id, productID;
      System.out.println("ID of the books are ");
      System.out.println(prototype.showIdBooks());
      System.out.println("ID of the magazines are ");
      System.out.println(prototype.showIdMagazine());
      System.out.println("Enter the book ID you want to bibliographic product");
      productID = lector.nextLine();
      System.out.println("Enter the id user");
      id = lector.nextLine();
      System.out.println(prototype.affordarProduct(id,productID));
   }
      
   public void createAutomaticProducts(){
      System.out.println(prototype.createAutomaticProducts());
  }

   public void readSimulation(){
      lector.nextLine();
      String productID, option, userID;
      option = "1";
      int nPag = 1;
      System.out.println("Enter the user id");
      userID = lector.nextLine();
      System.out.println("Enter the product ID you want to read");
      productID = lector.nextLine();
      
      while(!option.equalsIgnoreCase("S")){
          switch(option){
              case "P":
                  nPag--;
                  break;
              case "N":
                  nPag++;
                  break;
          }
          System.out.println(prototype.readSimulation(productID, nPag, userID));
          System.out.println("Do you want to continue reading?" );
          System.out.println("Enter:");
          System.out.println("(S) for stop");
          System.out.println("(N) to see the next page,");  
          System.out.println("(P) to see the previous page ");
          option = lector.nextLine();
      }
   }
   public void saveLibrary(){
      lector.nextLine();
      System.out.println("ID of the books are:");
      System.out.println(prototype.showIdBooks());
      System.out.println("ID of the magazines are: ");
      System.out.println(prototype.showIdMagazine());
      System.out.println("Enter the user id");
      String id = lector.nextLine();
      System.out.println("Enter the product id");
      String productID = lector.nextLine();
      System.out.println(prototype.saveLibrary(id,productID));

   }
   public void showLibrary(){
      lector.nextLine();
      System.out.println("Enter the user id");
      String id = lector.nextLine();
      System.out.println(prototype.showLibrary(id));
   }

    public void acumulateReadPag(){
      System.out.println(prototype.acumulateReadPag());
    }

   public void top5Book(){
      System.out.println(prototype.top5book());
      
   }
   public void top5Magazine(){
      System.out.println(prototype.top5Magazine());}
   
   public void infoGanderBook(){
      System.out.println(prototype.infoGanderBook());
   }
   
   public void infoCategoryMagazine(){
      System.out.println(prototype.infoCategoryMagazine());
   }

   
   public void mostRead(){
      System.out.println(prototype.mostRead());
   }
}

