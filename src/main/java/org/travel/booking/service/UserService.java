package org.travel.booking.service;

import org.travel.booking.model.User;

public interface UserService {

    User createUser(String email, String password);

    User getUserById(Long id);

    User getUserByEmail(String email);
}
