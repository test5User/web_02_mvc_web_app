package by.itclass.model.services;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {
    public List<User> getUsersByCondition(Map<String, String[]> params) {
        List<User> users = new ArrayList<>();
        String choose = params.get("choose")[0];
        switch (choose) {
            case "name" : {
                String fio = params.get("fio")[0];
                users.add(DbInMemory.findUserByFio(fio));
                users = users.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                break;
            }
            case "id" : {
                int from = Integer.parseInt(params.get("fromId")[0]);
                String toId = params.get("toId")[0];
                int to = Integer.parseInt(toId);
                users = DbInMemory.findUserByIds(from, to);
                break;
            }
            default: break;
        }
        return users;
    }
}
