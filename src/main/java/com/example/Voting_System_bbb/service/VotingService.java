package com.example.Voting_System_bbb.service;

import com.example.Voting_System_bbb.model.ParticipantModel;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotingService {
    private static final String TOPIC_VOTING = "voting";
    private final KafkaTemplate<Object, Object> template;

    public void AddEvent(ParticipantModel participantModel) {
        template.send(TOPIC_VOTING, participantModel);
    }
}

