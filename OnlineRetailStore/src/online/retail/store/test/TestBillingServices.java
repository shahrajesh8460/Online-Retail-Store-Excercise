package online.retail.store.test;

import org.junit.Test;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import online.retail.store.BillService;
import online.retail.store.Product;

public class TestBillingServices {
	
	
	BillService bill;
	HashMap<Integer, Product> map1;
	HashMap<Integer,Integer> map2;
	Product testProduct;
	
	@Before
	public void setup(){
		 testProduct= new Product();
		testProduct.setProductId(1);
		testProduct.setProductName("Mobile 1");
		testProduct.setDescription("Vivo");
		testProduct.setPrice(15000);
		testProduct.setCategory('A');
		
		map1= new HashMap<Integer, Product>();
		map1.put(1, testProduct);
		
		map2= new HashMap<Integer,Integer>();
		map2.put(1, 1);
		
		bill=new BillService();
	}
		
		@Test
		public void testCalculateBill(){
			
			double result=bill.calculateBill(map1, map2);
		
			Assert.assertEquals(16500.0d, result, 0.001);
			Assert.assertNotEquals(1600.0d, result);
		}
		@Test
		public void testCalculateTax(){
			
			double result=bill.calculateTax(testProduct);
			Assert.assertEquals(1.1d, result, 0.001);
			Assert.assertNotEquals(1.2d, result);
		}
		
		//public void 
		
		@After
		public  void destroyInput() {
			 bill=null;
			 map1=null;
			 map2=null;
			 testProduct=null;
		}


}
