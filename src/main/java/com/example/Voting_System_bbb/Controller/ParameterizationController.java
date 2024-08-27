package com.example.Voting_System_bbb.Controller;

import com.example.Voting_System_bbb.model.ParameterizationModel;
import com.example.Voting_System_bbb.repository.ParameterizationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterizationController {
    private final ParameterizationRepository parameterizationRepository;
    public ParameterizationController(ParameterizationRepository repository) {
        this.parameterizationRepository = repository;
    }

    @PostMapping("/save")
    public ResponseEntity<ParameterizationModel> save(@RequestBody ParameterizationModel parameterizationModel) {
        ParameterizationModel entity = parameterizationRepository.save(parameterizationModel);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consultation")
    public ResponseEntity<ParameterizationModel> consultation(@RequestParam String key) {
        Optional<ParameterizationModel> optParameter = parameterizationRepository.findById(key);
        if (optParameter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(optParameter.get());
    }
}