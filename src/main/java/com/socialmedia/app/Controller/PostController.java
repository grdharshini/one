package com.socialmedia.app.Controller;

import com.socialmedia.app.DTO.PostDTO;
import com.socialmedia.app.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public PostDTO createPostDetails(@RequestBody PostDTO postDTO){
        return postService.createUser(postDTO);
    }
    @GetMapping("/getPost")
    public ArrayList<PostDTO> getAllPost() {
        return postService.getAllPost();
    }
}






