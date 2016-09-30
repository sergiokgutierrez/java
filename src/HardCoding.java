import java.lang.*;
public class HardCoding {
	public static void main(String[] args) {
		
		bigTest();
	
	}
	public static void minorTest(){
		DynamicArray< String> da = new DynamicArray<>();
		
		for(int i=-2; i<420; i++){
			Location l = da.locate(i);
//			System.out.println("i: "+i+"\t\t blockIndex: "+l.getBlockIndex()+"\t\t\telement index: "+l.getElementIndex());
		}
	}
	
	public static void bigTest(){
	DynamicArray<String> da = new DynamicArray<String>();
		
		
		System.out.println(da.returnB(6, 3));
		
		
		
		System.out.println("\n\n\n\n\n"+da.toStringForDebugging());
		da.add("T");
		System.out.println("\n"+da.toStringForDebugging());
		da.add("P");
		System.out.println("\n\n\n"+da.toStringForDebugging());
		System.out.println(da);
		
		
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



