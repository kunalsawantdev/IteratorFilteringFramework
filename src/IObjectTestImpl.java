
public class IObjectTestImpl implements IObjectTest{

	@Override
	public boolean test(Object o) {
		// TODO Auto-generated method stub
		if((int)o >12) {
			return true;
		}
		return false;
	}

}
