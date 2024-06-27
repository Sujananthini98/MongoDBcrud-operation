package com.mongodbCRUD.Service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodbCRUD.Dao.MongoDbDao;
import com.mongodbCRUD.entity.MongoDbEntity;

@Service
public class MongoDbService {
    @Autowired
    MongoDbDao md;

    public void postData(MongoDbEntity mb) {
        if (mb.getId() == null || mb.getId().isEmpty()) {
            mb.setId(UUID.randomUUID().toString());
        }
        md.save(mb);
    }

    public String postData(List<MongoDbEntity> mbList) {
        for (MongoDbEntity mb : mbList) {
            if (mb.getId() == null || mb.getId().isEmpty()) {
                mb.setId(UUID.randomUUID().toString());
            }
        }
        return md.saveAll(mbList);
    }

    public List<MongoDbEntity> findAll() {
        return md.findAll();
    }

    public MongoDbEntity findById(String id) {
        return md.findById(id);
    }

    public String deleteById(String id) {
        return md.deleteById(id);
    }

    public String update(MongoDbEntity mb) {
        return md.update(mb);
    }
}
