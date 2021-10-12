package hu.uni.miskolc.adatbazisos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("Select * from User")
    List<User> getAll();

    @Query("Select * from User Where last_name = :lastName and first_name = :firstName")
    List<User> getAllBySameName(String lastName, String firstName);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
