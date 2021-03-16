package ua.com.alevel.third;

import ua.com.alevel.second.Value;

public class ChildClass extends ParentClass{
    @Value(value = "ChildClass")
    private String name;
    @Value(value = "id")
    private String id;

    @Override
    public String toString() {
        return "ChildClass{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
