package com.example.Voting_System_bbb.Controller;

import com.example.Voting_System_bbb.model.ParameterizationModel;
import com.example.Voting_System_bbb.model.ParticipantModel;
import com.example.Voting_System_bbb.repository.ParameterizationRepository;
import com.example.Voting_System_bbb.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/participants")
@AllArgsConstructor
public class ParticipantController {

    private final ParticipantRepository participantRepository;

    @PostMapping("/save")
    public ResponseEntity<ParticipantModel> save(@RequestBody ParticipantModel participantModel) {
        ParticipantModel entity = participantRepository.save(participantModel);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consultation")
    public ResponseEntity<ParticipantModel> consultation(@RequestParam String key) {
        Optional<ParticipantModel> opt = participantRepository.findById(key);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(opt.get());
    }
}
