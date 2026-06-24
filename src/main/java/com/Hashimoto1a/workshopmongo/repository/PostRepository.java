package com.Hashimoto1a.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Hashimoto1a.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ //<tipo da classe de dominio a ser gerenciado, tipo de id(no caso o id usado é string)>
	
}
