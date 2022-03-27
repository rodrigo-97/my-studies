package com.app.mystudies.msteatcher.controllers;

import java.util.List;
import java.util.Optional;

import com.app.mystudies.msteatcher.models.Teatcher;
import com.app.mystudies.msteatcher.repositories.TeatcherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teatchers")
class TeatcherController {

    @Autowired
    TeatcherRepository teatcherRepository;

    @GetMapping
    public ResponseEntity<List<Teatcher>> getAll() {
        try {
            List<Teatcher> teatchers = teatcherRepository.findAll();

            return new ResponseEntity<>(teatchers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Teatcher> getById(@PathVariable("id") Long id) {
        Optional<Teatcher> teatcher = teatcherRepository.findById(id);

        if (teatcher.isPresent()) {
            return new ResponseEntity<>(teatcher.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Teatcher> create(@RequestBody Teatcher teatcher) {
        try {
            Teatcher savedTeatcher = teatcherRepository.save(teatcher);
            return new ResponseEntity<>(savedTeatcher, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Teatcher> update(@PathVariable("id") Long id, @RequestBody Teatcher teatcher) {
        Optional<Teatcher> currentTeatcher = teatcherRepository.findById(id);
        if (currentTeatcher.isPresent()) {
            Teatcher existingTeatcher = currentTeatcher.get();

            existingTeatcher.setEmail(teatcher.getEmail());
            existingTeatcher.setName(teatcher.getName());
            existingTeatcher.setPhone(teatcher.getPhone());

            return new ResponseEntity<>(teatcherRepository.save(existingTeatcher), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            teatcherRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}