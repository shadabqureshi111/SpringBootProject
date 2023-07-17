package com.vision.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Integer> {

	 @Query("SELECT new map(q.id as question_id, q.question as question) FROM QuestionModel q")
	    List<Map<String, Object>> findIdAndQuestion();
	 
	
	 @Query(nativeQuery = true,value =  "SELECT q.id as id, q.question as question,q.answer as ans FROM question_answer q where q.id>= :id limit 2")
	    List<Map<String, Object>> findNextQuetion(@Param("id") Integer id);
}
