package com.example.Voting_System_bbb.repository;

import com.example.Voting_System_bbb.model.ParticipantModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<ParticipantModel, String> {

}
