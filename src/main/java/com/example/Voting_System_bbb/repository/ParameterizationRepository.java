package com.example.Voting_System_bbb.repository;

import com.example.Voting_System_bbb.model.ParameterizationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParameterizationRepository extends MongoRepository<ParameterizationModel, String> {

}
