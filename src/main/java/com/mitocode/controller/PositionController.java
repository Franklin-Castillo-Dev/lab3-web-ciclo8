package com.mitocode.controller;

import com.mitocode.dto.PatientDTO;
import com.mitocode.dto.PositionDTO;
import com.mitocode.dto.SpecialtyDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Position;
import com.mitocode.model.Specialty;
import com.mitocode.service.IPatientService;
import com.mitocode.service.IPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private IPositionService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PositionDTO>> findAll() {
        List<PositionDTO> list = service.findAll().stream().map(p -> mapper.map(p, PositionDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PositionDTO dto) {
        Position p = service.save(mapper.map(dto, Position.class));
        //localhost:8080/specialtys/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPosition()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Position> update(@Valid @RequestBody PositionDTO dto) {
        Position obj = service.findById(dto.getIdPosition());
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdPosition());
        }

        return new ResponseEntity<>(service.update(mapper.map(dto, Position.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Position obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
