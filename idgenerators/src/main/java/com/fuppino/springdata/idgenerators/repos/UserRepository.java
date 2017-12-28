package com.fuppino.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.springdata.idgenerators.entities.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
}
