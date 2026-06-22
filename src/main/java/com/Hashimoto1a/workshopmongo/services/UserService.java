package com.Hashimoto1a.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hashimoto1a.workshopmongo.domain.User;
import com.Hashimoto1a.workshopmongo.repository.UserRepository;
import com.Hashimoto1a.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired //instanciar automaticamente o objeto aqui no servico
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}
