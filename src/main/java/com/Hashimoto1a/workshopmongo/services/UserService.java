package com.Hashimoto1a.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hashimoto1a.workshopmongo.domain.User;
import com.Hashimoto1a.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired //instanciar automaticamente o objeto aqui no servico
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
