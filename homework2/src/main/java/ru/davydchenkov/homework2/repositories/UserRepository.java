package ru.davydchenkov.homework2.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.davydchenkov.homework2.model.User;

import java.util.List;



@Repository
public class UserRepository {
    @Autowired
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstname(r.getString("firstname"));
            rowObject.setLastname(r.getString("lastname"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }
    public User save(User user){
        String sql = "INSERT INTO userTable (firstname, lastname) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstname(), user.getLastname());
        return user;
    }
    public void deleteById(Integer id){
        if(id == null){
            throw new IllegalArgumentException("ID cannot be null");
        }
        String deleteIntSql = "DELETE FROM userTable WHERE id = ?";
        jdbc.update(deleteIntSql, id);
    }
}
