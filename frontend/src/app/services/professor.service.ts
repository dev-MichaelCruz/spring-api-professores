import { Injectable } from '@angular/core';
import { Professor } from '../models/Professor';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {
  private _id = 1;
  
  listaBackup: Professor[] = []; //Guardar

  listaProfessores: Professor[] = []; //

  listaBusca: Professor[] = [];

  idProfessor!: number;
  nome!: string;
  materia!: string;
  endereco!: string;
  telefone!: string;
  email!: string;

  constructor() { 
    this.listaProfessores = this.listaBackup
  }

  adicionarProfessor(nome: string,materia: string, endereco: string,telefone: string, email: string) {

    const professor: Professor = {
      id: this.novoId(),
      nome,
      materia,
      endereco,
      telefone,
      email
    }
    
    this.listaBackup.push(professor);

    //PARA MOTIVOS DE TESTE
    console.log(professor);
    console.log(this.listaProfessores);

  }

  atualizarDados(id: number, nome: string, materia: string, endereco: string, telefone: string, email: string) {

    const indexProfessor = this.listaProfessores.findIndex((p) => p.id === id) 
    
    const professor = this.listaProfessores[indexProfessor]
    professor.nome = nome
    professor.materia=materia
    professor.endereco=endereco
    professor.telefone=telefone
    professor.email=email
    
    this.listaProfessores.splice(indexProfessor, 1, professor)

    // PARA MOTIVOS DE TESTES
    console.log(professor);
    console.log(this.listaProfessores)
      
  }

  excluirProfessor(index: number) {
    this.listaProfessores.splice(index, 1)

    // PARA MOTIVOS DE TESTES
    console.log("LISTA ATUALIZADA");
    console.log(this.listaProfessores)
  }

  buscarProfessores(busca: string) {
    console.log(busca)
    const professoresEncontrados = this.listaProfessores.filter(
      professor => professor.nome.toLowerCase().includes(busca.toLowerCase())
    );

    professoresEncontrados.forEach(professor =>{
      this.listaBusca.push(professor);
    })

    this.listaProfessores = this.listaBusca;

    console.log(this.listaBusca)
  }

  //== FUNÇÕES AUXILIARES ===
  novoId(): number{
    return this._id++;
  }

  alertaDadosIncompletos(){
    alert( "Preencha todos os campos!" );
  }

}