import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProfessorService } from 'src/app/services/professor.service';

@Component({
  selector: 'app-cadastro-professor',
  templateUrl: './cadastro-professor.component.html',
  styleUrls: ['./cadastro-professor.component.scss']
})
export class CadastroProfessorComponent implements OnInit{
  cadastroForm: FormGroup = new FormGroup({})

  nome!: string;
  materia!: string;
  endereco!: string;
  telefone!: string;
  email!: string;

  constructor(private professorService: ProfessorService,
              private formBuilder: FormBuilder) {}


  ngOnInit(): void {

    this.cadastroForm = this.formBuilder.group({
      nome: ['', Validators.required],
      materia: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      endereco: ['', Validators.required],
      telefone: ['', Validators.required]
    })

  }

  adicionarProfessor():void {
    if (this.cadastroForm.valid) {
      const formData = this.cadastroForm.value;

      this.professorService.adicionarProfessor(formData.nome, formData.materia, formData.endereco, formData.telefone, formData.email);
      this.cadastroForm.reset();
    }
  }

}
