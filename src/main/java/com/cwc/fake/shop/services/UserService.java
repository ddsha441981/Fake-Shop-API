package com.cwc.fake.shop.services;

import java.util.List;

import com.cwc.fake.shop.entities.users.Users;

public interface UserService {

	// Add : - New User
	Users addNewUser(Users users);

	// Update : - User
	Users updateUser(Users users, String userId);

	// Update : - User Patch
	Users updatePatchUser(Users users, String userId);

	// Get : - Single User
	Users singleUser(String userId);

	// Get : - All User
	List<Users> retriveUsers();

	// Delete : - Single User
	Users deleteUser(String userId);

	
	//Limit : - Results
	 List<Users> checkLimitResult(int limit);
	
	// Sort : - User Desc/Aces
	List<Users> sortUser(String sort);

}
