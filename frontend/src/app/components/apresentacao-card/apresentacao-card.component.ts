import { Component} from '@angular/core';
import { Professor } from 'src/app/models/Professor';
import { ProfessorService } from 'src/app/services/professor.service';
@Component({
  selector: 'app-apresentacao-card',
  templateUrl: './apresentacao-card.component.html',
  styleUrls: ['./apresentacao-card.component.scss']
})

export class ApresentacaoCardComponent {
  listaProfessores: Professor[] = []

  indexSelecionado: number = -1;

  idProfessor!: number
  nome!: string;
  materia!: string;
  endereco!: string;
  telefone!: string;
  email!: string


  constructor(private professorService: ProfessorService){
    this.listaProfessores = this.professorService.listaProfessores
  }

  excluirProfessor(index: number){
    this.professorService.excluirProfessor(index);
  }

  atualizarDados(id: number){
    this.professorService.atualizarDados(id, this.nome, this.materia, this.endereco, this.telefone, this.email)
  }

  buscarDados(index: number){
    const professor = this.listaProfessores[index]
      this.idProfessor = professor.id
      this.nome = professor.nome;
      this.materia = professor.materia;
      this.endereco = professor.endereco;
      this.telefone = professor.telefone;
      this.email = professor.email;
  }
}
