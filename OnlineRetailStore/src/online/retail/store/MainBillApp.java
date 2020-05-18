package online.retail.store;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainBillApp {

	public static void main(String[] args) {
		
		Product p1= new Product(1,"Mobile", "OnePlus- 8GB RAM/ 128 GB Memory", 'B', 30000);
		
		Product p2= new Product(2,"Laptop", "HP- 8GB RAM/ 1TB HDD/ Intel i5", 'B', 50000 );

		Product p3= new Product(3,"Speakers", "Noise- Great Sound Quality", 'A', 9000);

		Product p4= new Product(4,"HeadPhones", "JBL-Flip 3 'Silence is Boring'", 'C', 3000);
		
		Product p5= new Product(5,"Television", "Sony- 32 Inches with HD ", 'A', 25000);
		
		HashMap<Integer, Product> hmap= new HashMap<Integer, Product>();

				hmap.put(1, p1);
				hmap.put(2, p2);
				hmap.put(3, p3);
				hmap.put(4, p4);
				hmap.put(5, p5);
				
        int selection = 0;
        int qty=0;
        Scanner input = null; 
        int choice = 0;
        
		HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();

        try{
        	input=new Scanner(System.in);
        System.out.println("Do you want to purchase?");
		 System.out.println("If yes, press 1");
		 System.out.println("If No, press 2");

		  choice=input.nextInt();
        }		 
        catch(InputMismatchException e){
        	System.out.println("Please enter only defined value above for purchasing");
        }

        while(choice==1)
        	{
	
        		for (Entry<Integer, Product> entry : hmap.entrySet())  {
                    System.out.println(entry.getValue().getProductId()+ 
                    		": " +entry.getValue().getProductName()+" : "+ entry.getValue().getDescription()+" for Rs."+entry.getValue().getPrice()+" Plus GST ");
               }
        		selection=input.nextInt();
        		
        	if(selection<=hmap.size()){
        		
    	        System.out.println("Please enter the quantity");
     	         qty=input.nextInt();

        		if(hm.containsKey(selection)){
        			//hm.entrySet().contains(p1);
        			
            		for (Entry<Integer, Integer> entry : hm.entrySet())  {
            		
            	if(	entry.getKey()==selection){	
        			hm.put(selection, entry.getValue()+qty );
            	}
            }
        }
        		
        		else{
        			hm.put(selection, qty);
        		}
        	}
        		
	   	 else {
	   		 System.out.println("Invalid Choice! Select anyoneout of given option numbers.");
        }	
      
        System.out.println("Do you want to purchase more?");
		 System.out.println("1- Yes");
		 System.out.println("2- No");
		 int x=input.nextInt();	
		 if(x==2){
			 
			 break;
		 }
        	}
      
		BillService bill = new BillService();
		bill.calculateBill(hmap, hm);	
        }
}