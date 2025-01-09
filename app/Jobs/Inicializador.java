package Jobs;

import models.Aluno;
import models.Curso;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception {
		if (Curso.count() == 0) {
			Curso c1 = new Curso();
			c1.nomeCurso = "info";
			c1.codCurso = "1604";
			c1.save();
			
			Curso c2 = new Curso();
			c2.nomeCurso = "Medicina";
			c2.codCurso = "1605";
			c2.save();
		}
		
		if (Aluno.count() == 0) {
			Aluno A1 = new Aluno();
			A1.nome = "Selline";
			A1.matricula = "2025";
			A1.senha = "med2025";
			A1.save();
		}
		
		
	}

}
