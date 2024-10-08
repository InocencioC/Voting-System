import { Component, OnInit } from '@angular/core';
import {Participant} from "../model/participant";
import {RestService} from "../service/RestService";

@Component({
  selector: 'app-votacao',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css'],
  standalone: true
})
export class VotingComponent implements OnInit {

  title = 'Votação BBB 22';
  participantes: Participant[] | undefined;

  constructor(private restService : RestService) {}

  ngOnInit(): void {
    this.getParticipantes();
  }

  getParticipantes() {
    this.restService.getData('/participantes/todos').subscribe((participantes) => {
      this.participantes = participantes;
    }) ;
  }

}
