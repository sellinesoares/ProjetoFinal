package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Aluno extends Model{
	
	public String nome;
	public String matricula;
	
	public String senha;
	
	@ManyToOne
	public Curso curso;
	
	public static String autenticar(String matricula, String senha) {
		Aluno a = Aluno.find("matricula = ?1 and senha = ?2", matricula, senha).first();
			if(a == null) {
				return null;
			} else {
				return a.nome;
			}
	}

}
