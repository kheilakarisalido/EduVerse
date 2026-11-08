package com.csit321g3.agenda.eduverse.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csit321g3.agenda.eduverse.entity.Campus;
import com.csit321g3.agenda.eduverse.repository.CampusRepository;

@Service
public class CampusService {

    @Autowired
    CampusRepository crepo;

    //C
    public Campus save(Campus campus) {
        return crepo.save(campus);
    }

    //R all
    public List<Campus> getAll() {
        return crepo.findAll();
    }

    //R one
    public Campus getById(Long id) {
        return crepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Campus " + id + " not found"));
    }

    //U
    public Campus update(Long id, Campus newCampusDetails) {

    Campus campus = newCampusDetails;

    try {
        campus = crepo.findById(id).get();

        campus.setName(newCampusDetails.getName());
        campus.setDomain(newCampusDetails.getDomain());

    } catch (NoSuchElementException e) {
        throw new NoSuchElementException("Campus " + id + " not found");
    }

    return crepo.save(campus);
}

    //D
    public String delete(Long id) {

        String msg = "";

        if (crepo.findById(id).isPresent()) {
            crepo.deleteById(id);
            msg = "Campus ID " + id + " successfully deleted.";
        } else {
            msg = "Campus ID " + id + " not found.";
        }

        return msg;
    }
}
