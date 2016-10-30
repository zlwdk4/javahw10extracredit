package javahw10extracredit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ProductionCodeTest {

    public static void main(String[] args) {

        ProductionCode testSubject = new ProductionCode();

        int inputValue1 = 3;
        int inputValue2 = 7;
        int expectedResult = 10;

        // Insert reflection code here to call method add()
        // in ProductionCode. Compare actual result
        // with expected result and print success
        // or failure.

        Class reflectClass = ProductionCode.class;
        
        
        Method[] theMethods = reflectClass.getDeclaredMethods();
        for(Method m : theMethods)
        {
        	System.out.println(m.getName());
        }
        Class[] methodParamTypes = new Class[]{Integer.TYPE, Integer.TYPE};
       Object[] params = new Object[]{new Integer(inputValue1), new Integer(inputValue2)};
       
       int actualResult = 0;
        try {
			Method privAdd = reflectClass.getDeclaredMethod("add", methodParamTypes);
			privAdd.setAccessible(true);
	        actualResult = (int) privAdd.invoke(testSubject, params);
        
        } 
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
  	
        
        

        if (actualResult == expectedResult)
            System.out.println("ProductionCode test passed.");
        else
            System.out.println("ProductionCode test failed.");
    }
}