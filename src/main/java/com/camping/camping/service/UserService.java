package com.camping.camping.service;

import com.camping.camping.dto.User;
import com.camping.camping.repository.UserRepository;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  /**
   * @return 
   */
  public ArrayList<User> get() {
    return (ArrayList<User>)this.userRepository.findAll();
  }

  /**
   * @param user
   * @return 
   */
  public User post(User user) {
    return userRepository.save(user);
  }

  /**
   * @param user 
   * @param id 
   * @return 
   */
  public User put(User user, Integer id) {
    return userRepository.save(user);
  }

  /**
   * @param id 
   */
  public void delete(Integer id) {
    userRepository.deleteById(id);
  }

  /**
   * @param id 
   * @return 
   */
  public Optional<User> getByKey(Integer id) {
    return userRepository.findById(id);
  }

}
