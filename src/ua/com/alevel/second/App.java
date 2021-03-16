package ua.com.alevel.second;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) {
        TestClass testClass = createInstance(TestClass.class);
        System.out.println(testClass.getName());
    }

    private static TestClass createInstance(Class<TestClass> testClassClass) {
       try {
           Constructor constructor = testClassClass.getConstructor();
           TestClass testClass = (TestClass)constructor.newInstance();
           initializeObject(testClass);
           return testClass;
       }catch (NoSuchMethodException e){
           System.out.println("Error");
       } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
           e.printStackTrace();
       }
        return new TestClass();
    }

    private static void initializeObject(TestClass testClass)throws IllegalAccessException {
        Field[] fields = testClass.getClass().getDeclaredFields();
        for (Field field : fields) {
                Value annotation = field.getAnnotation(Value.class);
                String value = annotation.value();
                field.setAccessible(true);
                field.set(testClass, value);
                field.setAccessible(false);

        }
    }
}
