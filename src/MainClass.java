import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainClass {
	public static void main(String args[]) {
		IObjectTestImpl myTest = new IObjectTestImpl();
		List<Integer> list = new ArrayList();
		list.add(13);
//		list.add(3);
//		list.add(11);
//		list.add(24);
//		list.add(null);
//		list.add(2);
//		list.add(224);
//		list.add(null);
//		list.add(4);
		Iterator<Integer> iter = list.iterator();
		FilteringIterator filter = new FilteringIterator(iter, myTest);
		while(filter.hasNext()) {
			System.out.println(filter.next());
		}
	}
}
