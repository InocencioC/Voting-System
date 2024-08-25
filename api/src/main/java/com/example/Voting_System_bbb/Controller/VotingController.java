package com.example.Voting_System_bbb.Controller;

import com.example.Voting_System_bbb.model.ParticipantModel;
import com.example.Voting_System_bbb.service.VotingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voting")
@AllArgsConstructor
public class VotingController {

    private final VotingService votingService;

    @PostMapping
    public ResponseEntity<String> vote(@RequestBody ParticipantModel participantModel) {
       votingService.AddEvent(participantModel);
        return ResponseEntity.ok("vote accepted");
    }
}
