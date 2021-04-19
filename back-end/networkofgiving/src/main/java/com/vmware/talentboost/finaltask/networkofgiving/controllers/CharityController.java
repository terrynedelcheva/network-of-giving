package com.vmware.talentboost.finaltask.networkofgiving.controllers;

import com.vmware.talentboost.finaltask.networkofgiving.model.Charity;
import com.vmware.talentboost.finaltask.networkofgiving.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/charities")
public class CharityController {
    @Autowired
    private CharityService charityService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody Charity charity) {
        charityService.create(charity);
    }

    @GetMapping
    public List<Charity> getAll() {
        return charityService.getAllCharities();
    }

    @GetMapping("/{id}")
    public Charity getCharity(@PathVariable Long id) {
        return charityService.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.charityService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Charity charity) {
        charityService.update(id, charity);
    }

    @GetMapping("/search/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Charity> getCharityByTitleOrAPartOfIt(@PathVariable String title) {
        return charityService.findByTitleContaining(title);
    }
}
