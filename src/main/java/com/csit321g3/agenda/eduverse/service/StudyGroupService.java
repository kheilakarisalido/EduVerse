package com.csit321g3.agenda.eduverse.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csit321g3.agenda.eduverse.entity.StudyGroup;
import com.csit321g3.agenda.eduverse.repository.StudyGroupRepository;

@Service
public class StudyGroupService {

    @Autowired
    StudyGroupRepository sgrepo;

    // C
    public StudyGroup postStudyGroup(StudyGroup studyGroup) {
        return sgrepo.save(studyGroup);
    }

    // R all
    public List<StudyGroup> getAllStudyGroups() {
        return sgrepo.findAll();
    }

    // R one
    public StudyGroup getStudyGroupById(Long id) {
        return sgrepo.findById(id).get();
    }

    // U
    public StudyGroup putStudyGroup(Long id, StudyGroup newGroupDetails) {
        StudyGroup studyGroup = newGroupDetails;

        try {
            studyGroup = sgrepo.findById(id).get();

            studyGroup.setName(newGroupDetails.getName());
            studyGroup.setGroupStreak(newGroupDetails.getGroupStreak());
            studyGroup.setCreatedAt(newGroupDetails.getCreatedAt());
            studyGroup.setCampus(newGroupDetails.getCampus());
            studyGroup.setCreatedBy(newGroupDetails.getCreatedBy());

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Study Group ID " + id + " not found.");
        }

        return sgrepo.save(studyGroup);
    }

    // D
    public String deleteStudyGroup(Long id) {
        String msg = "";

        if (sgrepo.findById(id).isPresent()) {
            sgrepo.deleteById(id);
            msg = "Study Group ID " + id + " successfully deleted.";
        } else {
            msg = "Study Group ID " + id + " not found.";
        }

        return msg;
    }
}