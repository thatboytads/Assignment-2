import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
 
public class LSAVLTApp
{   
    private AVLTree<lsObject> avl;
    int opCount= 0;
    /**creates a new constructor whose sole purpose is to instantiate LOADSHEDDING object in our LSBST app
     * 
     * @param other
     */
    public LSAVLTApp(){
      avl = new AVLTree<lsObject>();
      }
      /**main method where the program is run and our text file is inserted into our Binary search tree
       * 
       * @param args
       */
    public static void main( String [] args )
    {  
      LSAVLTApp LSAVL = new LSAVLTApp();     
    try{
      File file= new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
      Scanner sc= new Scanner(file);
      
     
      
      while(sc.hasNextLine()){
       
       
        LSAVL.insertTree(new lsObject(sc.nextLine()));
              
             
             
              }
              sc.close();
     }catch (FileNotFoundException e){
     e.printStackTrace();
     
     }
    
       if (args.length==3)
          {LSAVL.printAreas(args[0], args[1], args[2]);}
       else if(args.length==0){
           
           LSAVL.printAllAreas();}
       else{
            System.out.println("Error input entered in Incorrectly. Please Enter in the form:");
            System.out.println(" stage day time, i.e. 1 1 10");
       }
      }
  /**
   * insertion method is instantiated for use in this class
   * @param other
   */
    public void insertTree(lsObject other){
      avl.insert(other);
      }
      
    
    
    /**by calling the find method we are able to find the Loadshedding object's Areas which are being seeked by the user and print that areas and by calling the counters we can view the number of insertions and comparisons*/
    public void printAreas (String stage2, String day2, String time2) 
    {
   
     try{
      System.out.println("Areas: " + Arrays.toString((avl.find(new lsObject(stage2,day2,time2)).getData()).getAreas()));
     }
    
     catch(NullPointerException e){
       System.out.println("Area not found!");
     }

     System.out.println("The number of insertions performed: "+Integer.toString(avl.getInscount()) );
    System.out.println("The number of comparisons formed: "+Integer.toString(avl.getOpcount()) );
    
    }

    /**
     * prints all area from the text file and displays total number of insertions using an inOrder transveral
     */
    public void printAllAreas () 
    {
    
     
    avl.inOrder();
    System.out.println("The number of insertions performed: "+Integer.toString(avl.getInscount()) );
     
    } 
  }


   


