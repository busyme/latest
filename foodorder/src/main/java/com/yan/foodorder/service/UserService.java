package com.yan.foodorder.service;

import org.springframework.data.repository.CrudRepository;

import com.yan.foodorder.model.User;

public interface UserService extends CrudRepository<User, Long> {

}
