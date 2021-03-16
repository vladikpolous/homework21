package ua.com.alevel.first;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
    Class newClass = A.class;
        List<A> aList = new ArrayList<>();
    Constructor[] constructors = newClass.getDeclaredConstructors();
        for (Constructor constr: constructors) {
            System.out.println(constr);
            if (constr.getParameterCount() == 2) {
                constr.setAccessible(true);
                aList.add((A) constr.newInstance("1","new value"));
            }
            if(constr.getParameterCount() == 0){
                constr.setAccessible(true);
                aList.add((A) constr.newInstance());
            }
        }

        System.out.println(aList);
    }

}

