package com.csit321g3.agenda.eduverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g3.agenda.eduverse.entity.Campus;
import com.csit321g3.agenda.eduverse.service.CampusService;

@RestController
@RequestMapping(path = "/api/campuses")
public class CampusController {

    @Autowired
    CampusService cserv;

    //C
    @PostMapping
    public Campus create(@RequestBody Campus campus) {
        return cserv.save(campus);
    }

    //R all
    @GetMapping
    public List<Campus> getAll() {
        return cserv.getAll();
    }

    //R one
    @GetMapping("/{id}")
    public Campus getById(@PathVariable Long id) {
        return cserv.getById(id);
    }
    
    //U
    @PutMapping("/{id}")
    public Campus update(
            @PathVariable Long id,
            @RequestBody Campus campus) {

        return cserv.update(id, campus);
    }

    //D
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cserv.delete(id);
    }
}