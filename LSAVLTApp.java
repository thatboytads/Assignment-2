import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random; 
import java.util.ArrayList;
import java.io.PrintWriter;
 
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
      
      /**
       * main method where the program is run and our text file is inserted into our
       * Binary search tree
       * 
       * @param args
       * @throws FileNotFoundException
       */
      public static void main(String[] args) throws FileNotFoundException
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
     LSAVL.Createfiles();
    
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
      public void Createfiles() throws FileNotFoundException {
        String Nsamps[] = new String[] { "number 1", "number 2", "number 3", "number 4", "number 5", "number 6",
        "number 7", "number 8", "number 9", "number 10" };
        ArrayList<Object> findOpcount = new ArrayList<>();
        
        LSAVLTApp lSTree1= new LSAVLTApp();
        ArrayList<String> result= new ArrayList<>();
    int len = Nsamps.length;
    int rand_int1=0;
        int size=250;
        try {
          File file = new File("./Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
          Scanner sc = new Scanner(file);
  
          while (sc.hasNextLine()) {
  
            String line = sc.nextLine();
            
            result.add(line);
               
               
                }
                sc.close();
       }catch (FileNotFoundException e){
       e.printStackTrace();
       
       }
       File file3 = new File("./best counter Avl tree"+".txt");
        File file4 = new File("./Average counter Avl tree"+".txt");
        File file5 = new File("./worst counter Avl tree"+".txt");
       PrintWriter writer3 = new PrintWriter(file3);
        PrintWriter writer4 = new PrintWriter(file4);
        PrintWriter writer5 = new PrintWriter(file5);
       for (int i=0;i<len;i++ ){
         
          
         
        File file1 = new File("./"+Nsamps[i]+" Avl tree.txt");
  
        
        
        
        int j=0;
        PrintWriter writer = new PrintWriter(file1);
        
        
        
  
        while(j<size){
          
          Random rand = new Random(); 
          
          rand_int1 = rand.nextInt(result.size());
          
          
          
          
        String SizeRandom=result.get(rand_int1);
        
        writer.println(SizeRandom);
        j++;
  
        
  
        } 
        writer.close();
       
        try {
         
          Scanner sc = new Scanner(file1);
  
          while (sc.hasNextLine()) {
  
            String line = sc.nextLine();
            lsObject lsobj=  new lsObject(line);
            lSTree1.insertTree(lsobj);
            
            findOpcount.add(lsobj);
         
               
               
                }
                sc.close();
       }catch (FileNotFoundException e){
       e.printStackTrace();
       
       }
       int [] opCompare = new int[297006] ;
       for (int k=0; k<findOpcount.size();k++){
         lSTree1.avl.find((lsObject) findOpcount.get(k));
         opCompare[k]=  lSTree1.avl.getInscount()+lSTree1.avl.getOpcount();
         
       }
       int best= opCompare[1];
       int worst= opCompare[size-1];
       long avg=0;
       for (int num: opCompare){
         avg= avg+num;
  
       }
       long totalAvg=avg/size;
       writer3.println(+best);
       writer4.println(totalAvg);
       writer5.println(worst);
       
       
  
       
       
        
        size= size+250; 
       }
      
       writer3.close();
       writer4.close();
       writer5.close();
  
       
       
       
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


   


