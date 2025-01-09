package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity
public class Curso extends Model{

	public String nomeCurso;
	public String codCurso;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	public Curso() {
		this.status = Status.ATIVO;
	}
	
	@Override
	public String toString() {
		return nomeCurso;
	}
	
}
