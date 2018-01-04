import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

public class FilteringIteratorTest {
	@Test
	public void testHasNext() throws ConcurrentModificationException 
	{
		IObjectTestImpl myTest = new IObjectTestImpl();
		List<Integer> list = new ArrayList();
		list.add(11);
		list.add(24);
		list.add(2);
		list.add(224);
		list.add(4);
		Iterator<Integer> iter = list.iterator();
		FilteringIterator filter = new FilteringIterator(iter, myTest);
		assertTrue(filter.hasNext()); 
	}
	
	@Test
	public final void testEmptyIterator() throws ConcurrentModificationException
	{
		IObjectTestImpl myTest = new IObjectTestImpl();
		List<Integer> list = new ArrayList();
		Iterator<Integer> iter = list.iterator();
		FilteringIterator filter = new FilteringIterator(iter, myTest);
		assertFalse(filter.hasNext()); 
	}
	
	@Test
	public final void testNext() throws ConcurrentModificationException 
	{
		IObjectTestImpl myTest = new IObjectTestImpl();
		List<Integer> list = new ArrayList();
		list.add(200);
		Iterator<Integer> iter = list.iterator();
		FilteringIterator filter = new FilteringIterator(iter, myTest);
		assertEquals(200, filter.next());
	}
	
	@Test(expected=ConcurrentModificationException.class)
	public final void testNextConcurrentModification()  
	{
		IObjectTestImpl myTest = new IObjectTestImpl();
		List<Integer> list = new ArrayList();
		list.add(200);
		Iterator iter = list.iterator();
		FilteringIterator filter = new FilteringIterator(iter, myTest);
		assertTrue(filter.hasNext());
		list.add(300);
		filter.next();		
	}
}