package org.example.app.service;

import org.example.app.exception.UserException;
import org.example.app.repository.impl.UserRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.UserMapper;
import org.example.app.utils.UserValidator;
import org.example.app.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public String createUser(Map<String, String> data) {
        Map<String, String> errors = new UserValidator().validateUserData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        return userRepository.create(new UserMapper().mapUserData(data));
    }

    public String readUsers() {
        Optional<List<User>> optional = userRepository.read();
        if (optional.isPresent()) {
            List<User> list = optional.get();
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((user) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") ")
                                .append(user.toString())
                );
                return "\nUSERS:\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }

    public String updateUser(Map<String, String> data) {
        Map<String, String> errors = new UserValidator().validateUserData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        return userRepository.update(new UserMapper().mapUserData(data));
    }

    public String deleteUser(Map<String, String> data) {
        Map<String, String> errors = new UserValidator().validateUserData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check inputs", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        return userRepository.delete(new UserMapper().mapUserData(data).getId());
    }

    public String readUserById(Map<String, String> data) {
        Map<String, String> errors = new UserValidator().validateUserData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UserException("Check input", errors);
            } catch (UserException e) {
                return e.getErrors(errors);
            }
        }
        Optional<User> optional = userRepository.readById(Long.parseLong(data.get("id")));
        if (optional.isPresent()) {
            User user = optional.get();
            return "\nUser: " + user + "\n";
        } else return Constants.DATA_ABSENT_MSG;
    }
}
