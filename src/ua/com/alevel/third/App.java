package ua.com.alevel.third;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        ChildClass childClass = new ChildClass();
        TestClass testClass = new TestClass();
        List<String> listOfClasses = new ArrayList<>();
        inspectForService(childClass,listOfClasses);
        inspectForService(testClass,listOfClasses);
        inspectForService(parentClass,listOfClasses);

        System.out.println(listOfClasses);
    }
    private static <T> void inspectForService(T classToCheck, List<String> listOfMarkedClasses) {

        if(classToCheck.getClass().isAnnotationPresent(Service.class)){
            System.out.println("Annotation Service is present.");
            listOfMarkedClasses.add(classToCheck.getClass().getSimpleName());
        }else if(!classToCheck.getClass().isAnnotationPresent(Service.class)){
            System.out.println("There is no Service annotation");
        }
    }
}
