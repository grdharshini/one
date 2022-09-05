package com.socialmedia.app.Repository;

import com.socialmedia.app.DAO.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <PostDAO, Integer>{
}
