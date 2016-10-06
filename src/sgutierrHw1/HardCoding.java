package sgutierrHw1;
import static org.junit.Assert.assertEquals;

import java.lang.*;
import java.util.Scanner;

import org.junit.Test;
public class HardCoding {
	public static void main(String[] args) {
		
//		runner();
		bigTest();
//		addStress();
//		DynamicArray_grow1();
	
	}
	
	
	
	
	public static void addStress(){
		 DynamicArray<Integer> da = new DynamicArray<Integer>();
		 for(int i=0; i<100; i++){
		   da.add(i);
		 }
		 String expect, actual, msg;
		 assertEquals("Size mismatch",100,da.size());
		 assertEquals("#Blocks mismatch",19,da.numberOfDataBlocks);
		 expect =
		   "- maxNumberOfDataBlocks: 8\n"+
		   "- maxNumberOfElementsPerBlock: 8\n"+
		   "- currentNumberOfDataBlocks: 5\n"+
		   "";
		 actual = da.lastSuperBlock.toStringForDebugging();
		 msg = String.format("lastSuperBlock wrong:\nEXPECT:\n%sACTUAL:\n%s\n",expect,actual);
		 assertEquals(msg,expect,actual);
	}
	
	  public static void DynamicArray_grow1(){
	   // test grow() on empty DynamicArray
	     DynamicArray<String> d1 = new DynamicArray<String>();
	     d1.grow(); // grow one space in Block0
	 
	    Block b = d1.getBlock(0);

	    if(b.getNumber()!=0){
	       System.out.println("DynamicArray grow:\n"+
	          "Expect: +b.getNumber==0\n" +
	          "Actual: b.getNumber==" + b.getNumber());
	     }
	 
	    if(b.getCapacity()!=1){
	    	System.out.println("DynamicArray grow:\n"+
	          "Expect: +b.getCapacity==1\n" +
	          "Actual: b.getCapacity==" + b.getCapacity());
	    }
	    if(b.size()!=1){
	    	System.out.println("DynamicArray grow:\n"+
	          "Expect: +b.size==1n" +
	          "Actual: b.size==" + b.size());
	    }
	  }
	
	
	
	
	
	
	
	
	public static void minorTest(){
		DynamicArray< String> da = new DynamicArray<>();
		
		for(int i=-2; i<420; i++){
			Location l = da.locate(i);
//			System.out.println("i: "+i+"\t\t blockIndex: "+l.getBlockIndex()+"\t\t\telement index: "+l.getElementIndex());
		}
	}
	
	public static void runner(){
		Scanner keyboard = new Scanner (System.in);
		String x = "0";
		String input;
		DynamicArray< String> da = new DynamicArray<>();
		while(true){
			System.out.println("1\t\tadd");
			System.out.println("2\t\tremove");
			System.out.println("3\t\tprint");
			x = keyboard.next();
			switch(x){
			case "1":
				input = keyboard.next();
				da.add(input);
				break;
			case "2":
				da.remove();
				break;
			case "3":
				System.out.println(da.toStringForDebugging());
				System.out.println(da);
				break;
			default:
				System.out.println("wrong input try again");
			}
			
		}
	}
	
	public static void bigTest(){
	DynamicArray<String> da = new DynamicArray<String>();
	
		System.out.println("\n\n\n\n\n"+da.toStringForDebugging());
		da.add("A");
		System.out.println("\n"+da.toStringForDebugging());
		da.add("B");
		System.out.println("\n\n\n"+da.toStringForDebugging());
		da.add("C");
		System.out.println("\n"+da.toStringForDebugging());
		da.add("D");
		System.out.println("\n\n\n"+da.toStringForDebugging());
		da.add("E");
		System.out.println("\n"+da.toStringForDebugging());
		da.add("F");
		System.out.println("\n\n\n"+da.toStringForDebugging());
		
		
		da.add("Q");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		da.add("F");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		da.add("Q");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);	
		
		da.add("f");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		
		da.add("G");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		da.add("M");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);

		
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		da.add("p");
//		test2();
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da.arrayOfBlocks.length);
		
		
	}
	

	

	private static void test4(int index) {
		  int r = index+1;
//		  int k = (int)(Math.log(r)/Math.log(2));//by default the log is rounded to floor*k=superblock # 
		  int k = log2Floor(r);//compute k the superblock number  
		  int p , fk2 = Math.floorDiv(k, 2);//compute floor of(k/2)
		  System.out.println("k "+k);
		  if(k % 2 == 0){//if k is even
				p = 2*(power2(fk2)-1);
		  }else {//if k is odd
				p = (2*(power2(fk2)-1)) + power2(fk2);
		  }
		  int b = returnB(r,k);//returns the b
		  int blockIndex = p+b;
		  System.out.println("p "+p +" b: "+b);
		  System.out.println("*********"+blockIndex);
	}
	
	
	public static int test3(int k){
		int ck2 = (int)Math.ceil(k / 2);//CEILING(k/2)
		int mask = (1<<ck2)-1;
		int elementIndex = mask & (k+1);
//		System.out.println(ck2+" "+mask+" "+elementIndex);
		  return elementIndex;
	}
	private static void test2(){
		Location location = new Location(0, 0);
		DynamicArray<String> da = new DynamicArray<String>();
		for (int i=0; i <100; i++){
			location = da.locate(i);
			System.out.println("i: "+i+"\t\t\tBlock:"+location.getBlockIndex()+"\t\t\tindex:"+location.getElementIndex()+"\t\t\tNewElement: "+test3(i));
			
		}
	}
	private static void test1(){
	Block <String>block = new Block <String>(0,3);
		
		System.out.println(block.toStringForDebugging());
		
		block.grow();
		block.setElement(0, "A");
		System.out.println(block.toStringForDebugging());
		
		block.grow();
		block.setElement(1, "B");
		System.out.println(block.toStringForDebugging());
		
		if(!block.isFull()){
			System.out.println("MADE IT HERE");
			block.grow();
			block.setElement(2, "C");
		}
		System.out.println(block.toStringForDebugging());
	}
	
	  // returns 2 to the power n
	  public static int power2(int n)
	  {
	     return 1 << n;
	  }
	  
	  public static int log2Floor(int n)
	  {
	     return bitNum(n) - 1;
	  }
	  private static int bitNum(int n)
	  {
	     int  count = 0;
	     while (n != 0)
	     {
	        n = n >>> 1;
	        count++;
	     }
	     return count;
	  }
	  
	  public static int returnB(int r, int k){
			int lb = bitNum(9);//returns leading bit
			int mask = 1 << lb;
			mask--;
			int b = r & mask;
			int lastShift = lb - ((int)Math.floorDiv(k,2)+1);
			b = b >> lastShift;//substract leading bit by floor (k/2)
		System.out.println("lb "+lb+" lastshift "+lastShift+" b "+b);
			return b;
	  }
	  
	  
}



