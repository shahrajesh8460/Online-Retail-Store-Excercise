package online.retail.store;
import java.util.HashMap;
import java.util.Map.Entry;

public class BillService {
	
	private double total;
	private double amount;
	private double gst;

	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	public double calculateBill(HashMap<Integer, Product> map1, HashMap<Integer,Integer > map2){
		
		if(map2.isEmpty()){
			
			System.out.println("Thanks for visiting our store");
		}
		
		else{
			
		    System.out.println(String.format("%20s %20s %10s %10s %10s %10s %10s", "Item", "|", "Price(Rs)", "|", "Qty","|", "Amount"));
		    System.out.println(String.format("%s", "-------------------------------------------------------------------------------------------------------------"));

		    for (Entry<Integer, Product> entry : map1.entrySet())  {
	
		    	for(Entry<Integer,Integer> entry1 : map2.entrySet())
		
		    		if(entry.getValue().getProductId()==entry1.getKey()){
		
		    			amount= entry.getValue().getPrice()*entry1.getValue()*calculateTax(entry.getValue());
			
		    			System.out.println(String.format("%20s %20s %10s %10s %10s %10s %10s", entry.getValue().getProductName(), "|",
					entry.getValue().getPrice(),"|", entry1.getValue(),"|", amount));
			
		    			total= total+ amount;
			
			}
			 
		}
					System.out.println(String.format("\n%s", "-------------------------------------------------------------------------------------------------------------"));

					System.out.println("\t\tGrand Total:\t\t\t\t\t\t\t\t "+total);
		
					System.out.println("\n\n Thank you, Have a Nice Day ");
	
		}
		
		return total;

}
	
	public double calculateTax(Product p){
		
			if(p.getCategory()=='A'){
				
				gst=1.1d;
				
			}
			else if(p.getCategory()=='B'){
				
				gst=1.2d;
				
			}
			else{
				gst=1d;
			}
		return gst;
	}
	
}