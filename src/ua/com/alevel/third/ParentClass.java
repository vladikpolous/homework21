package ua.com.alevel.third;

import ua.com.alevel.second.Value;

@Service
public class ParentClass {
    @Value(value = "ParentClass")
    private String name;
    @Value(value = "id")
    private String id;

    @Override
    public String toString() {
        return "ParentClass{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
