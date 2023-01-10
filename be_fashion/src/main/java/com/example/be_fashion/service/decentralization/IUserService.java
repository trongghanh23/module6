package com.example.be_fashion.service.decentralization;


import com.example.be_fashion.model.decentralization.User;


import java.util.List;
import java.util.Optional;

public interface IUserService {
    String existsByUserName(String username);

    Optional<User> findUserByUsername(String username);

    List<User> findAll();

    User findByUsername(String name);



    void updatePassword(User user, String newPassword);

    void saveCreateGmail(User user);

    Optional<User> showUsername(String username);

    void updateUser(User user, String username);

}
