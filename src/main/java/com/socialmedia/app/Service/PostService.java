package com.socialmedia.app.Service;

import com.socialmedia.app.DAO.PostDAO;
import com.socialmedia.app.DTO.PostDTO;
import com.socialmedia.app.Repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public PostDAO convertPostDTOtoDAO(PostDTO postDTO) {
        return modelMapper.map(postDTO, PostDAO.class);
    }

    public PostDTO convertPostDAOtoDTO(PostDAO postDAO) {
        return modelMapper.map(postDAO, PostDTO.class);
    }

    public PostDTO createUser(PostDTO postDTO) {
        PostDAO postDAO = modelMapper.map(postDTO, PostDAO.class);
        postRepository.save(postDAO);
        return postDTO;
    }

    public ArrayList<PostDTO> getAllPost() {
        List<PostDAO> postDAOList = postRepository.findAll();
        ArrayList<PostDTO> postDTOArrayList = new ArrayList<PostDTO>();
        for (PostDAO object : postDAOList) {
            postDTOArrayList.add(this.convertPostDAOtoDTO(object));
        }
        return postDTOArrayList;
    }

    public PostDTO getPostById(Integer id){
        Optional<PostDAO> postDAO = postRepository.findById(id);
        return modelMapper.map(postDAO.get(),PostDTO.class);
    }
}





