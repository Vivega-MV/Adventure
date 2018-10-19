//Michelle Vick
import java.util.*;
import java.io.*;
public class Adventure {
   public static void main(String[] args) {
      final int SCALE = 4;

      //Start Scanner
      Scanner uInput = new Scanner(System.in);

      //Get 1st user input
      System.out.println("What would you like to do?");     
      
      boolean keepGoing = true;
      int[] xyCoords = {0, 0};
      int x = 0, y = 1;
      
      String command1 = "";
      String parameter1 = "";

      do {        
        String direction1 = uInput.nextLine();
        direction1 = direction1.toUpperCase();
        
        //Split into command and parameter
        String[] parts = direction1.split(" ");
        command1 = "";
        parameter1 = "";

        if (parts.length == 1){
          command1 = parts[0];
        }
        else if (parts.length == 2){  
          command1 = parts[0];
          parameter1 = parts[1];
        }
        else {
          System.out.println("Invalid command...");    
        }
  
        if (command1.equals("G") || command1.equals("GO")){
          if (parameter1.equals("NORTH")){
            if(xyCoords[x] <= 0){
              System.out.println("You can't go that far north."); 
            }
            else{
              xyCoords[x] = (xyCoords[x] - 1);
              System.out.println("Moving " + parameter1.toLowerCase() + "..."); 
            }
          }
          else if (parameter1.equals("EAST")){
            if(xyCoords[y] >= SCALE){
              System.out.println("You can't go that far east."); 
            }
            else{
              xyCoords[y] = (xyCoords[y] + 1);
              System.out.println("Moving " + parameter1.toLowerCase() + "..."); 
            }
          }
          else if (parameter1.equals("SOUTH")){
            if(xyCoords[x] >= SCALE){
              System.out.println("You can't go that far south."); 
            }
            else{
              xyCoords[x] = (xyCoords[x] + 1);
              System.out.println("Moving " + parameter1.toLowerCase() + "..."); 
            }
          }
          else if (parameter1.equals("WEST")){
            if(xyCoords[y] <= 0){
              System.out.println("You can't go that far west."); 
            }
            else{
              xyCoords[y] = (xyCoords[y] - 1);
              System.out.println("Moving " + parameter1.toLowerCase() + "..."); 
            }
          }
          else{
            System.out.println("You can't go that way.");
          }              
          System.out.println("You are at location " + xyCoords[x] + ", " + xyCoords[y] + "."); 
        }
        else if (command1.equals("I") || command1.equals("INVENTORY")){
          System.out.println("You are carrying:");
          System.out.println("brass lantern\nrope\nrations\nstaff");    
          System.out.println("You are at location " + xyCoords[x] + ", " + xyCoords[y] + ".");  
        }
        else if (command1.equals("Q") || command1.equals("QUIT")){ 
          System.out.println("Farewell");  
          System.out.println("You are at location " + xyCoords[x] + ", " + xyCoords[y] + "."); 
          keepGoing = false;   
          System.exit(0); 
        }
        else {          
          System.out.println("Invalid command: " + direction1.toLowerCase());
          System.out.println("You are at location " + xyCoords[x] + ", " + xyCoords[y] + ".");
        }
      }while (keepGoing);     
   }
}
