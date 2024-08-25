package com.example.Voting_System_bbb.Controller;

import com.example.Voting_System_bbb.model.ParameterizationModel;
import com.example.Voting_System_bbb.repository.ParameterizationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterizationController {

    private final ParameterizationRepository repository;

    public ParameterizationController(ParameterizationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/save")
    public ResponseEntity<ParameterizationModel> save(@RequestBody ParameterizationModel parameterizationModel) {
        ParameterizationModel entity = repository.save(parameterizationModel);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consultation")
    public ResponseEntity<ParameterizationModel> consultation(@RequestParam String key) {
        Optional<ParameterizationModel> optParameter = repository.findById(key);
        if (optParameter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(optParameter.get());
    }
}