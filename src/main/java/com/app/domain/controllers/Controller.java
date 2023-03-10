package com.app.domain.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/yyy")
public class Controller {
	 

	    @PostMapping("/records")
	    @ApiOperation (value = "creates yyy records", notes = "creates yyy transactions xpto etc..")
	    @Transactional(isolation = Isolation.READ_COMMITTED)
	    public ResponseEntity<String> getUserById(@RequestBody String  records){
	    	try {

//	             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            
	            return new ResponseEntity<>("", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
