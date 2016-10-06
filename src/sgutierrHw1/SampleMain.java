package sgutierrHw1;

public class SampleMain {
	public static void main(String args[]) {
		DynamicArray<String> d = new DynamicArray<String>();
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("arrayOfBlocks.length:" +               
         	d.arrayOfBlocks.length); // default
		System.out.println();
		System.out.println("add A");
		d.add("A");
		System.out.println(d);
		System.out.println("get(0):" + d.get(0));
		System.out.println(d.toStringForDebugging());
		System.out.println("remove A");
		d.remove();
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("add A");
		d.add("A");
		System.out.println(d);
		System.out.println("get(0):" + d.get(0));
		System.out.println(d.toStringForDebugging());
		System.out.println("add B");
		d.add("B");
		System.out.println(d);
		System.out.println("get(1):" + d.get(1));
		System.out.println(d.toStringForDebugging());
		System.out.println("add C");
		d.add("C");
		System.out.println(d);
		System.out.println("get(2):" + d.get(2));
		System.out.println(d.toStringForDebugging());
		System.out.println("add D");
		d.add("D");
		System.out.println(d);
		System.out.println("get(3):" + d.get(3));
		System.out.println(d.toStringForDebugging());
		System.out.println("add E");
		d.add("E");
		System.out.println(d);
		System.out.println("get(4):" + d.get(4));
		System.out.println(d.toStringForDebugging());
		System.out.println("locate 4");
		System.out.println(d.locate(4).toStringForDebugging());
		System.out.println();
		System.out.println("add F");
		d.add("F");
		System.out.println(d);
		System.out.println("get(5):" + d.get(5));
		System.out.println(d.toStringForDebugging());
		System.out.println("add G");
		d.add("G");
		System.out.println(d);
		System.out.println("get(6):" + d.get(6));
		System.out.println(d.toStringForDebugging());
		// adding 5th block
		System.out.println("arrayOfBlocks.length:" + 
			d.arrayOfBlocks.length);
		System.out.println();
		System.out.println("add H");
		d.add("H");
		System.out.println(d);
		System.out.println("get(7):" + d.get(7));
		System.out.println(d.toStringForDebugging());
		System.out.println("arrayOfBlocks.length:" + 
			d.arrayOfBlocks.length);
		System.out.println();
		System.out.println("Use sets to reverse Order");
		System.out.println();
		d.set(0, "H");
		d.set(1, "G");
		d.set(2, "F");
		d.set(3, "E");
		d.set(4, "D");
		d.set(5, "C");
		d.set(6, "B");
		d.set(7, "A");
		System.out.println(d);
		System.out.println("size: " + d.size());
		System.out.println();
		System.out.println("remove A");
		d.remove(); // A
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("remove B");
		d.remove(); // B
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("remove C");
		d.remove(); // C
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("remove D");
		d.remove(); // D
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("remove E");
		d.remove(); // E
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("remove F");
		d.remove(); // F
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("remove G");
		d.remove(); // G
		System.out.println("arrayOfBlocks.length:" + 
		d.arrayOfBlocks.length);
		System.out.println(d);
		System.out.println(d.toStringForDebugging());
		System.out.println("remove H");
		d.remove(); // H
		System.out.println(d);
		System.out.println(d.toStringForDebugging());

		System.out.println("arrayOfBlocks.length:" + 
		d.arrayOfBlocks.length);
	}    


}
