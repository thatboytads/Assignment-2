
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
 
public class LSBSTApp
{   
    private BinarySearchTree<lsObject> bst;
    int opCount= 0;
    /**creates a new constructor whose sole purpose is to instantiate the binary search object in our LSBST app
     * 
     * @param other
     */
    public LSBSTApp(){
      bst = new BinarySearchTree<lsObject>();
      }
      /**main method where the program is run and our text file is inserted into our Binary search tree
       * 
       * @param args
       */
    public static void main( String [] args )
    {  
      LSBSTApp LSTree = new LSBSTApp();     
    try{
      File file= new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
      Scanner sc= new Scanner(file);
      
     
      
      while(sc.hasNextLine()){
       
       
        LSTree.insertTree(new lsObject(sc.nextLine()));
              
             
             
              }
              sc.close();
     }catch (FileNotFoundException e){
     e.printStackTrace();
     
     }
    
       if (args.length==3)
          {LSTree.printAreas(args[0], args[1], args[2]);}
       else if(args.length==0){
           
           LSTree.printAllAreas();}
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
      bst.insert(other);
      }
      
    
    
    /**by calling the find method we are able to find the Loadshedding object's Areas which are being seeked by the user and print that areas and by calling the counters we can view the number of insertions and comparisons*/
    public void printAreas (String stage2, String day2, String time2) 
    {
   
     try{
      System.out.println("Areas: " + Arrays.toString((bst.find(new lsObject(stage2,day2,time2)).getData()).getAreas()));
     }
    
     catch(NullPointerException e){
       System.out.println("Area not found!");
     }

     System.out.println("The number of insertions performed: "+Integer.toString(bst.getInscount()) );
    System.out.println("The number of comparisons formed: "+Integer.toString(bst.getOpcount()) );
    
    }

    /**
     * prints all area from the text file and displays total number of insertions
     */
    public void printAllAreas () 
    {
    
     
    bst.inOrder();
    System.out.println("The number of insertions performed: "+Integer.toString(bst.getInscount()) );
     
    } 
  }


   


