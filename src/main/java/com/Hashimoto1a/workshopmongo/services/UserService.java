package com.Hashimoto1a.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hashimoto1a.workshopmongo.domain.User;
import com.Hashimoto1a.workshopmongo.dto.UserDTO;
import com.Hashimoto1a.workshopmongo.repository.UserRepository;
import com.Hashimoto1a.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // instanciar automaticamente o objeto aqui no servico
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

}
