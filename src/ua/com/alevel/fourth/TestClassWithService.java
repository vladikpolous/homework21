package ua.com.alevel.fourth;

import ua.com.alevel.second.Value;
import ua.com.alevel.third.Service;

@Service
public class TestClassWithService {
    @Value(value = "name")
    private String name;
    @Value(value = "id")
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    @Init
    private static void InitMethod(){
        System.out.println("InitMethod");
    }

}
