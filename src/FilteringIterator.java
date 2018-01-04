/*
 *	Kunal Sawant Code Test
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteringIterator implements Iterator {
	Iterator myIterator;
	IObjectTest myTest;
	Object nextElement;
	boolean hasNextFlag;
	
	public FilteringIterator(Iterator myIterator, IObjectTest myTest) {
		// TODO Auto-generated constructor stub
		this.myIterator = myIterator;
		this.myTest = myTest;
		goToFirstElement();
	}

	@Override
	public boolean hasNext() {
		return hasNextFlag;
	}

	@Override
	public Object next() {
		Object currentElement = nextElement;
		if(hasNextFlag) {
			while(myIterator.hasNext()) {
				Object o = myIterator.next();
				if(myTest.test(o)) {
					nextElement = o;
					hasNextFlag = true;
					return currentElement;
				}
				
			}
			hasNextFlag = false;
			return currentElement;
		}
		return null;
		
	}
	
	public void goToFirstElement() {
        while (myIterator.hasNext()) {
            Object o = myIterator.next();
            if (myTest.test(o)) {
                hasNextFlag = true;
                nextElement = o;
                return ;
            }
        }
        hasNextFlag = false;
        return ;
	}
}