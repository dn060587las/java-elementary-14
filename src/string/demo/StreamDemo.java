package string.demo;

import java.util.*;
import java.util.stream.Collectors;

class User {
    private final String id;

    private final String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i< 100; i++) {
            list.add(i);
        }
        list
                .stream()
                .map(item->{
                    return String.valueOf(item);
                }).forEach(str->{
            System.out.println(str);
        });

        list.stream().count();
        list.stream().distinct().forEach(a->{
            System.out.println("Unique number " + a);
        });
        list.stream().mapToInt(a->a).sum();

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0 ; i< 100; i++) {
            map.put(i, String.valueOf(i));
        }
        map.entrySet().stream().forEach(entry->{
            System.out.println(String.format("Key %d value %s", entry.getKey(), entry.getValue()));
        });
        map.keySet().stream().forEach(key->{
            System.out.println(String.format("Key %d value %s", key, map.get(key) ));
        });

        Set<Integer> set = list.stream().collect(Collectors.toSet());
        Map<Integer, String> map2 = set.stream().collect(Collectors.toMap(
                setElement->setElement,
                setElement ->{
                    return String.valueOf(setElement);
                }
        ));

        Set<User> userSet = new HashSet<>();
        userSet.add(new User("id1", "test1"));
        userSet.add(new User("id1", "test1"));
        userSet.stream().map(User::getId).collect(Collectors.toSet());

        map2.entrySet().stream().map(Object::toString).collect(Collectors.toSet());
    }

}
