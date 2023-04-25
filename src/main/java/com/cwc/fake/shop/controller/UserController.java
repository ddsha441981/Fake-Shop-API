package com.cwc.fake.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.fake.shop.entities.users.Users;
import com.cwc.fake.shop.services.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	

	@PostMapping("/")
	public ResponseEntity<Users> createNewUser(@RequestBody Users users){
		Users addedUser = this.userService.addNewUser(users);
		return new ResponseEntity<>(addedUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Users> updateExistingUser(@RequestBody Users users , @PathVariable("userId") String userId){
		Users updatesUser = this.userService.updateUser(users,userId);
		return new ResponseEntity<Users>(updatesUser,HttpStatus.CREATED);
	}
	
	@PatchMapping("/{userId}")
	public ResponseEntity<Users> updateTemporaryUser(@RequestBody Users users , @PathVariable("userId") String userId){
		Users updatesTemporaryUser = this.userService.updateUser(users,userId);
		return new ResponseEntity<Users>(updatesTemporaryUser,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Users>fetchSingleUser(@PathVariable("userId") String userId){
		Users fetchSingleUser = this.userService.singleUser(userId);
		return new ResponseEntity<Users>(fetchSingleUser,HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Users>>fetchCollectionsUser(){
		 List<Users> retriveUsers = this.userService.retriveUsers();
		return new ResponseEntity<List<Users>>(retriveUsers,HttpStatus.FOUND);
	}
	
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<Users> deleteSingleUser(@PathVariable("userId")  String userId){
//		
//		return  new ResponseEntity(userService.deleteUser(userId));
//	}
	
	@GetMapping("/limit")
	public ResponseEntity<List<Users>>fetchLimitUser(@RequestParam int limit){
		List<Users> limitResult = this.userService.checkLimitResult(limit);
		return new ResponseEntity<List<Users>>(limitResult,HttpStatus.FOUND);
	}
	
	@GetMapping("/sort")
	public ResponseEntity<List<Users>>fetchSortedUser(@RequestParam("sort") String sort){
		List<Users> sortedResults = this.userService.sortUser(sort);
		return new ResponseEntity<List<Users>>(sortedResults,HttpStatus.FOUND);
	}
	


}
