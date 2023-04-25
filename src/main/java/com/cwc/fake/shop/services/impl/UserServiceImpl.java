package com.cwc.fake.shop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cwc.fake.shop.config.ConfigurationManager;
import com.cwc.fake.shop.entities.users.Users;
import com.cwc.fake.shop.exceptions.ResourceNotFoundException;
import com.cwc.fake.shop.repository.UserRepository;
import com.cwc.fake.shop.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public Users addNewUser(Users users) {
		// Generate Random userId
		String userId = ConfigurationManager.generateRandomId();
		users.setUserId(userId);
		Users savedUser = this.userRepository.save(users);
		return savedUser;
	}

	@Override
	public Users updateUser(Users users, String userId) {
		Users selectedUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this User  Id {} " + userId));
		// Now Update Operations
//		selectedUser.builder()
//		.username(users.getUsername())
//		.password(users.getPassword())
//		.email(users.getEmail())
//		.phone(users.getPhone())
//		.name(users.getName())
//		.address(users.getAddress());

		selectedUser.setUsername(users.getUsername());
		selectedUser.setPassword(users.getPassword());

		selectedUser.setEmail(users.getEmail());
		selectedUser.setPhone(users.getPhone());
		selectedUser.setName(users.getName());
		selectedUser.setAddress(users.getAddress());
		Users updatedUser = this.userRepository.save(selectedUser);
		return updatedUser;

	}

	@Override
	public Users updatePatchUser(Users users, String userId) {
		Users selectedUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this User  Id {} " + userId ));
		// Now Update Operations
		selectedUser.setUsername(users.getUsername());
		selectedUser.setPassword(users.getPassword());

		selectedUser.setEmail(users.getEmail());
		selectedUser.setPhone(users.getPhone());
		selectedUser.setName(users.getName());
		selectedUser.setAddress(users.getAddress());
		Users updatedUser = this.userRepository.save(selectedUser);
		return updatedUser;
	}

	@Override
	public Users singleUser(String userId) {
		Users singleUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this User  Id {} " + userId));
		return singleUser;
	}

	@Override
	public List<Users> retriveUsers() {
		return this.userRepository.findAll();
	}

//	@Override
//	public Users deleteUser(String userId) {
//		return userRepository.deleteById(userId); 
//
//	}

	@Override
	public List<Users> sortUser(String sort) {
		Query query = new Query();
		if (sort != null) {
			query.with(Sort.by(sort));
		}
		List<Users> sortedList = mongoOperations.find(query, Users.class);
		return sortedList;
	}

	@Override
	public Users deleteUser(String userId) {

		return null;
	}

	@Override
	public List<Users> checkLimitResult(int limit) {
		Query query = new Query().limit(limit);
		List<Users> find = mongoOperations.find(query, Users.class);
		return find;
	}

}
