package uz.pdp.maven.jakartashoppingproject.dao;

import lombok.NonNull;
import uz.pdp.maven.jakartashoppingproject.dto.LoginDTO;
import uz.pdp.maven.jakartashoppingproject.entity.user.User;

import java.util.Optional;

public class UserDAO extends BaseDAO<User, String> {

    public Optional<User> findByEmail(@NonNull String email) {
        try {
            begin();
            User user = em.createQuery("select t from User t where t.email ilike :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
            commit();
            return Optional.ofNullable(user);
        } catch (Exception e) {
            e.printStackTrace();
            commit();
            return Optional.empty();
        }
    }

    public void persist(User user) {

        try {
            begin();
            em.persist(user);
            commit();
        } catch (Exception e) {
            e.printStackTrace();
            rollback();
        }

    }

    public Optional<User> findByUserName(@NonNull String username) {
        try {
            begin();
            User user = em.createQuery("select t from User t where t.username ilike :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            commit();
            return Optional.ofNullable(user);
        } catch (Exception e) {
            e.printStackTrace();
            commit();
            return Optional.empty();
        }
    }

    public User get(LoginDTO loginDTO) {
        return null;
    }
}
