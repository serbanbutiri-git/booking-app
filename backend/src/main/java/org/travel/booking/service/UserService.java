package org.travel.booking.service;

import java.util.List;
import org.travel.booking.model.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(String name, String email);
}
