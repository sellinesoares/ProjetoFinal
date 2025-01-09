package controllers;

import models.Aluno;
import play.mvc.Controller;

public class Logins extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void logar(String matricula, String senha) {
		String alunoLogado = Aluno.autenticar(matricula, senha);
			if(alunoLogado == null) {
				flash.error("Credenciais inválidas!!");
				form();
			} else {
				session.put("usuarioLogado", alunoLogado);

				Alunos.listar();
			}
	}

	public static void sair() {
		session.clear();
		flash.success("Você desconectou do sistema!");
		form();
	}

}
