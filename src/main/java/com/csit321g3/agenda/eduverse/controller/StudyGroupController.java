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

import com.csit321g3.agenda.eduverse.entity.StudyGroup;
import com.csit321g3.agenda.eduverse.service.StudyGroupService;

@RestController
@RequestMapping(path = "/api/study-groups")
public class StudyGroupController {

    @Autowired
    StudyGroupService sgserv;

    // C
    @PostMapping
    public StudyGroup create(@RequestBody StudyGroup studyGroup) {
        return sgserv.postStudyGroup(studyGroup);
    }

    // R all
    @GetMapping
    public List<StudyGroup> getAll() {
        return sgserv.getAllStudyGroups();
    }

    // R one
    @GetMapping("/{id}")
    public StudyGroup getById(@PathVariable Long id) {
        return sgserv.getStudyGroupById(id);
    }
    
    // U
    @PutMapping("/{id}")
    public StudyGroup update(
            @PathVariable Long id,
            @RequestBody StudyGroup studyGroup) {

        return sgserv.putStudyGroup(id, studyGroup);
    }

    // D
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sgserv.deleteStudyGroup(id);
    }
}