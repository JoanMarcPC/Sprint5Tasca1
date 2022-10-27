package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.controllers;


import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.dto.FlorDTO;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.services.FlorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:9001/")
public class FlorController {

    @Autowired
    private FlorServiceImpl florService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getAll() {
        try {
            List<FlorDTO> flors = florService.findAll();
            if (flors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(flors, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> getById(@PathVariable("id") long id) {
        Optional<FlorDTO> flor = florService.findById(id);

        if (flor.isPresent()) {
            return new ResponseEntity<>(flor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<FlorDTO> create(@RequestBody FlorDTO flor) {
        try {

            return new ResponseEntity<>(florService.add(flor), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<FlorDTO> update(@PathVariable("id") long id, @RequestBody FlorDTO flor) {
        Optional<FlorDTO> florFound = florService.findById(id);

        if (florFound.isPresent()) {
            FlorDTO _flor = florFound.get();
            _flor.setName(flor.getName());
            _flor.setCountry(flor.getCountry());
            return new ResponseEntity<>(florService.add(_flor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            florService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
