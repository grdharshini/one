package com.socialmedia.app.Service;

import com.socialmedia.app.DAO.UserDAO;
import com.socialmedia.app.DTO.UserDTO;
import com.socialmedia.app.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public UserDTO getUserById;
    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public UserDTO convertUserDAOtoUserDTO(UserDAO userDAO) {
        return modelMapper.map(userDAO, UserDTO.class);
    }

    public UserDAO convertUserDTOtoUserDAO(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserDAO.class);
    }

    public ArrayList<UserDTO> getAllUsers() {
        List<UserDAO> userDAOList = userRepository.findAll();
        ArrayList<UserDTO> userDTOArrayList = new ArrayList<UserDTO>();
        for (UserDAO obj : userDAOList) {
            userDTOArrayList.add(this.convertUserDAOtoUserDTO(obj));
        }
        return userDTOArrayList;
    }

    public UserDTO getUserById(Integer user_id) {
        Optional<UserDAO> userDAO = userRepository.findById(user_id);
        return modelMapper.map(userDAO.get(),UserDTO.class);
    }
    public UserDTO createUser (UserDTO userDTO){
        UserDAO userDAO = modelMapper.map(userDTO,UserDAO.class);
         userRepository.save(userDAO);
            return userDTO;
        }


    }


