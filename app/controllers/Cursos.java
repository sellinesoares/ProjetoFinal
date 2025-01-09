package controllers;

import java.util.List;

import models.Curso;
import models.Status;
import play.mvc.Controller;
import play.mvc.With;

public class Cursos extends Controller{
	
	public static void form() {
		List<Curso> cursos = Curso.findAll();
		render(cursos);
	}
	
public static void salvar(Curso curso) {
		
		Curso cursoDuplicado =
				Curso.find("nomeCurso = ?1", curso.nomeCurso).first();
			if(cursoDuplicado == null) {
				curso.save();
			} else {
				flash.error("Esse curso já existe!");
			}
		listar();
	}
	
	public static void listar() {
		List<Curso> curso = Curso.find("status = ?1", Status.ATIVO).fetch();
		render(curso);
	}
	
	public static void remover(Long id) {
		Curso curso = Curso.findById(id);
		curso.status = Status.INATIVO;
		curso.save();
		flash.success("Curso deletado!");
		listar();
	}
	
	public static void editar(Long id) {
		List<Curso> cursos = Curso.findAll();
		Curso curso = Curso.findById(id);
		renderTemplate("Cursos/form.html", cursos, curso);
	}


}
