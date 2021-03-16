package ua.com.alevel.fourth;

import ua.com.alevel.third.Service;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        String path = "src/src/ua/com/alevel/fourth";
        File file = new File(path);
        System.out.println(mapWithClassService(ListOfClass(file)));
        List<File> files = ListOfClass(file);
        findAnnotation(files);
    }



    public static List<File> ListOfClass(File file){
        List<File> listOfAllFiles = new LinkedList<>(Arrays.asList(Objects.requireNonNull(file.listFiles())));
        List<File> doneList = new LinkedList<>();
        for (File value : listOfAllFiles) {
            if (value.getName().contains(".java")) {
                doneList.add(value);
            }
        }
        return doneList;
    }
    private static Map<String,Object> mapWithClassService(List<File> listOfClass) {
        Map<String,Object> map = new LinkedHashMap<>();
        for (File ofClass : listOfClass) {
            try {
                String stringPathForClass = getPathForMethod(ofClass);
                Class<?> ourClass = Class.forName(stringPathForClass);

                getPathForMethod(ofClass);

                if (ourClass.isAnnotationPresent(Service.class)) {
                    try {
                        Constructor<?> ourConstructor = ourClass.getConstructor();
                        Object entity = ourConstructor.newInstance();
                        map.put(ofClass.getName().substring(0, ofClass.getName().length() - 5), entity);
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static String getPathForMethod(File file) {
        String filePathString = file.getPath().replace("\\", ".");
        return filePathString.substring(14, filePathString.length() - 5);
    }
    public static void findAnnotation(List<File> files) throws ClassNotFoundException {
        for (File file : files) {
            Class<?> ourClass = Class.forName(getPathForMethod(file));

            Method[] methods = ourClass.getDeclaredMethods();

            for (Method method :
                    methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    System.out.println(method);
                }
            }
        }
    }
}
