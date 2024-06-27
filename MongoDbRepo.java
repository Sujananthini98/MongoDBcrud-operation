package com.mongodbCRUD.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodbCRUD.entity.MongoDbEntity;

public interface MongoDbRepo extends MongoRepository<MongoDbEntity, String> {
}
