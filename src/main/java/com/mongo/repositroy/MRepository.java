package com.mongo.repositroy;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.model.Item;

public interface  MRepository extends MongoRepository<Item, ObjectId>{
	
	

}
