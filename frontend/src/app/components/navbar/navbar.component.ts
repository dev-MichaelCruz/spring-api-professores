import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from 'src/app/models/Professor';
import { ProfessorService } from 'src/app/services/professor.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent{

  listaBusca: Professor[] =[];
  busca!: string;

  constructor(private router: Router, private professorService: ProfessorService){
    this.listaBusca = this.professorService.listaBusca;
  }

  abrirCadastro() {
    this.router.navigate(["cadastro"])
  }

  buscarProfessor() {
    this.professorService.buscarProfessores(this.busca)
  }

  

}
