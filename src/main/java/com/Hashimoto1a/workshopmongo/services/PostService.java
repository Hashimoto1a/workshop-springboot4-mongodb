package com.Hashimoto1a.workshopmongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hashimoto1a.workshopmongo.domain.Post;
import com.Hashimoto1a.workshopmongo.repository.PostRepository;
import com.Hashimoto1a.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // instanciar automaticamente o objeto aqui no servico
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);

		return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findyByTitle(String text){
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate){
		maxDate = maxDate.plusDays(1);
		return repo.fullSearch(text, minDate, maxDate); 
	}
	
}
