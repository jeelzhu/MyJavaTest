package ikm;

import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {

 public static void main(String[] args) {

     int x = -1;

     x = x >> 32;
     System.out.println(x);
     	x = x >> 1;     System.out.println(x);

     x = x >>> 32;     System.out.println(x);

     x = x >>> 0;     System.out.println(x);

     x = x >>> 1;     System.out.println(x);


     System.out.println(args[1] + args[2]);


     Console cons = System.console();

     String message="";

     Object obj = new MyClass();
     Method method;
     try {
         Class cls = Class.forName("com.src.ikmtest.MyClass");
         Class[] paramTypes = new Class[1];
         paramTypes[0] = String.class;
         method = cls.getDeclaredMethod("getMessage", paramTypes);
         message = (String) method.invoke(obj, "World.");
     } catch (SecurityException | NoSuchMethodException
             | IllegalAccessException | IllegalArgumentException
             | InvocationTargetException | ClassNotFoundException e) {
     }

                System.out.println(message);
             }
}

class MyClass {
 public String getMessage(String name) {
                 return "Hello " + name;
             }
  }
