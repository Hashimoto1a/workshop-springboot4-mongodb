package com.Hashimoto1a.workshopmongo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Hashimoto1a.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ //<tipo da classe de dominio a ser gerenciado, tipo de id(no caso o id usado é string)>
	@Query("{ 'title': { $regex: ?0, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{$and : [{date: {$gte: ?1}}, {date: {$lte: ?2}}, {$or: [{'title': { $regex: ?0, $options: 'i'}}, {'body': { $regex: ?0, $options: 'i'}}, {'comments.text': { $regex: ?0, $options: 'i'}}]}] }")
	List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);
}
