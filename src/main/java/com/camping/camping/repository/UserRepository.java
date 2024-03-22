package com.camping.camping.repository;

import com.camping.camping.dto.User;

import java.lang.Integer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
