package by.itclass.model.db;

import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DbInMemory {
    private static final List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Vasia Pupkin", "vasia@gmail.com"));
        users.add(new User(2, "Ivan Ivanov", "vano@yandex.ru"));
        users.add(new User(3, "Petr Petrov", "petro@gmail.com"));
    }

    public static boolean isContainsUserByFio(String fio) {
        return users.stream()
                .anyMatch(it -> it.getFio().equalsIgnoreCase(fio));
    }

    public static User findUserByFio(String fio) {
        return users.stream()
                .filter(it -> it.getFio().equalsIgnoreCase(fio))
                .findFirst().orElse(null);
    }

    public static List<User> findUserByIds(int from, int to) {
        return users.stream()
                .filter(it -> it.getId() >= from && it.getId() <= to)
                .collect(Collectors.toList());
    }
}
