package com.camping.camping.controller;

import com.camping.camping.dto.User;
import com.camping.camping.service.UserService;

import java.lang.Integer;
import java.lang.Void;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
  @Autowired
  private UserService userService;

  /**
   * @return 
   */
  @GetMapping(
      produces = "application/json"
  )
  public ResponseEntity<ArrayList<User>> get() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.get());
  }

  /**

   * @param User
   * @return
   */
  @PostMapping(
      consumes = "application/json"
  )
  public ResponseEntity<User> post(@RequestBody User User) {
    if(userService.getByKey(User.getId()).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    } else {
      this.userService.post(User);
      return ResponseEntity.status(HttpStatus.CREATED).body(User);
    }
  }

  /**
   * @param User 
   * @param id 
   * @return
   */
  @PutMapping(
      value = "{id}",
      consumes = "application/json"
  )
  public ResponseEntity<User> put(@RequestBody User User, @PathVariable("id") Integer id) {
    if(!userService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.userService.put(User, id);
      return ResponseEntity.status(HttpStatus.OK).body(User);
    }
  }

  /**
   * @param id
   * @return 
   */
  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
    if(!userService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.userService.delete(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
  }

  /**
   * @param User 
   * @param id 
   * @return 
   */
  @GetMapping(
      value = "{id}",
      produces = "application/json"
  )
  public ResponseEntity<User> getByKey(@PathVariable("id") Integer id) {
    if(!userService.getByKey(id).isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } else {
      this.userService.getByKey(id);
      return ResponseEntity.status(HttpStatus.OK).body(this.userService.getByKey(id).get());
    }
  }
}
