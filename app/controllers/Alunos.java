package controllers;

import java.util.List;

import models.Aluno;
import models.Curso;
import models.Status;
import play.mvc.Controller;
import play.mvc.With;

//@With(Seguranca.class)
public class Alunos extends Controller{
	
	public static void form() {
		List<Curso> cursos = Curso.findAll();
		render(cursos);
	}
	
	public static void salvar(Aluno aluno) {
		
			boolean podeSalvar = true;
			String msg = "Aluno cadastrado com sucesso!";
			
			if(aluno.matricula != null){
				flash.success("os dados do aluno foram atualizados com sucesso!!");
			}
			
			List<Aluno> alunosCadastrados = Aluno.findAll();
			
			for(Aluno posicao: alunosCadastrados) {
				if(posicao.matricula.equals(aluno.matricula) && aluno.id != null) {
					podeSalvar = false;
					flash.error("Já existe um aluno com essa matricula! Insira os dados corretamente");
				}
			}
			
			if(aluno.nome.equals("") && aluno.matricula.equals("") && aluno.curso == null && aluno.senha.equals("")) {
				podeSalvar = false;
				flash.error("Não é possível cadastrar um aluno com dados nulos! Preencha os campos corretamente!");
				form();
			}
			
			if(!podeSalvar) {
				flash.error(msg);
				form();
			} else {
				aluno.save();
				flash.success(msg);
				Alunos.listar();
			}
		
	}
	
	public static void listar() {
		List<Aluno> alunos = Aluno.findAll();
		render(alunos);
	}
	
	public static void remover(Long id) {
		Aluno aluno = Aluno.findById(id);
		aluno.delete();
		flash.success("Aluno deletado com sucesso!!");
		listar();
	}
	
	public static void editar(Long id) {
		Aluno aluno = Aluno.findById(id);
		List<Curso> cursos = Curso.findAll();
		renderTemplate("Alunos/form.html", aluno, cursos);
		listar();
	}

}
