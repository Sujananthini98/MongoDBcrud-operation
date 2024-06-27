package com.mongodbCRUD.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mongodbCRUD.Service.MongoDbService;
import com.mongodbCRUD.entity.MongoDbEntity;

@RestController
public class MongodbController {
    @Autowired
    MongoDbService ms;

    @PostMapping(path = "/mob")
    public void postData(@RequestBody MongoDbEntity m) {
        ms.postData(m);
    }

    @PostMapping(path = "/mob1")
    public String postData(@RequestBody List<MongoDbEntity> m) {
        return ms.postData(m);
    }

    @GetMapping(path = "/mob2")
    public List<MongoDbEntity> findAll() {
        return ms.findAll();
    }

    @GetMapping(path = "/mob3/{a}")
    public MongoDbEntity findById(@PathVariable String a) {
        return ms.findById(a);
    }

    @DeleteMapping(path = "/mob4/{a}")
    public String deleteById(@PathVariable String a) {
        return ms.deleteById(a);
    }

    @PutMapping(path = "/mob5")
    public String update(@RequestBody MongoDbEntity a) {
        return ms.update(a);
    }
}
