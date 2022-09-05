package com.socialmedia.app.Repository;

import com.socialmedia.app.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserDAO, Integer> {
}
