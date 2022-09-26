package ch.zli.m223.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import ch.zli.m223.exception.UserNotFoundException;
import ch.zli.m223.model.User;

public class UserService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public void deleteUser(Long id) {
        var user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public List<User> getAllUsers(Long id) {
        var user = entityManager.createQuery("FROM User", User.class);
        return user.getResultList();
    }
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        if(user == null){
            throw new UserNotFoundException("User mit der Id" + id + "nicht gefunden");
        } else {
            return user;
        }
    }
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }
}
