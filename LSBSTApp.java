
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
 
public class LSBSTApp
{   
    private BinarySearchTree<lsObject> bst;
    int opCount= 0;
    public LSBSTApp(){
      bst = new BinarySearchTree<lsObject>();
      }
    public static void main( String [] args )
    {  
           
       if (args.length==3)
          (new LSBSTApp ()).printAreas (args[0], args[1], args[2]);
       else if(args.length==0){
           LSBSTApp m=new LSBSTApp();
           m.printAllAreas();}
        else{
          System.out.println("You have entered the input incorrectly");
        }

    }
  
    public void insertTree(lsObject other){
      bst.insert(other);
      }
      
    
        public void TextFile()
    { 
 
      
    try{
        File file= new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner sc= new Scanner(file);
        
       
        int icount= 0; 
        while(sc.hasNextLine()){
          lsObject other= new lsObject(sc.nextLine());
         
                bst.insert(other);
                
                icount= icount+1;
               
                }
                sc.close();
       }catch (FileNotFoundException e){
       e.printStackTrace();
       
       }}
       
    public void printAreas (String stage2, String day2, String time2) 
    {
   TextFile();
    
      
    System.out.println("Areas: " + Arrays.toString((bst.find(new lsObject(stage2,day2,time2)).getData()).getAreas()));
    System.out.println("The number of comparisons formed: "+Integer.toString(bst.getOpcount()) );
    //}
    
    }

    
    public void printAllAreas () 
    {
     TextFile();
     
    bst.inOrder();
 
     
    } 
  }


   

