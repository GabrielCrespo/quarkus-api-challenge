package com.ibm.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.ibm.dto.UserDTO;
import com.ibm.entities.User;
import com.ibm.exceptions.ResourceNotFoundException;
import com.ibm.repositories.UserRepository;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository repository;

    public List<UserDTO> findAll(){
        List<User> users = repository.listAll();
        return users.stream().map((user) -> new UserDTO(user)).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findByIdOptional(id);
        User user = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO create(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        repository.persist(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        try {
            Optional<User> optional = repository.findByIdOptional(id);
            User user = optional.get();
            user.setName(dto.getName());
            repository.persist(user);
            return new UserDTO(user);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Entity not found");
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Entity not found");
        }
    }
    
}
