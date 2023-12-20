package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static final String QUERY = "SELECT id, fio, email FROM user WHERE fio = ?";
    public static final String QUERY1 = "SELECT id, fio, email FROM user WHERE id >= ? AND id <= ?";

    public User findUserByFio(String fio) {
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement ps = cn.prepareStatement(QUERY)){
            ps.setString(1, fio);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                return new User(id, fio, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findUserByIds(int from, int to) {
        List<User> users = new ArrayList<>();
        try (Connection cn = ConnectionManager.getConnection();
            PreparedStatement ps = cn.prepareStatement(QUERY1)){
            ps.setInt(1, from);
            ps.setInt(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fio = rs.getString("fio");
                String email = rs.getString("email");
                users.add(new User(id, fio, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
