package com.mongodbCRUD.Dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mongodbCRUD.Repository.MongoDbRepo;
import com.mongodbCRUD.entity.MongoDbEntity;

@Repository
public class MongoDbDao {
    @Autowired
    MongoDbRepo mr;

    public void save(MongoDbEntity mc) {
        mr.save(mc);
    }

    public String saveAll(List<MongoDbEntity> mbList) {
        try {
            mr.saveAll(mbList);
            return "Success";
        } catch (Exception e) {
            // Handle exceptions like duplicate key errors
            return "Failure: " + e.getMessage();
        }
    }

    public List<MongoDbEntity> findAll() {
        return mr.findAll();
    }

    public MongoDbEntity findById(String id) {
        Optional<MongoDbEntity> optional = mr.findById(id);
        return optional.orElse(null); // Return null if not found
    }

    public String deleteById(String id) {
        try {
            mr.deleteById(id);
            return "Successfully deleted";
        } catch (Exception e) {
            return "Failure: " + e.getMessage();
        }
    }

    public String update(MongoDbEntity mb) {
        try {
            mr.save(mb);
            return "Successfully updated";
        } catch (Exception e) {
            return "Failure: " + e.getMessage();
        }
    }
}
