package com.tribeapp.tribedirectory;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepo extends MongoRepository<Comment, String>{

    public List<Comment> findAllByBusinessName (String businessName);
}
