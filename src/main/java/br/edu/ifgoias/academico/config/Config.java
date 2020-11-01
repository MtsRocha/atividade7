package br.edu.ifgoias.academico.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.repositories.AlunoRepository;
import br.edu.ifgoias.academico.repositories.CursoRepository;

@Configuration
public class Config implements CommandLineRunner{
	
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		
		Curso c1 = new Curso(null, "Spring");
		
		Aluno a1 = new Aluno(null, "Mateus", "M", df.parse("31-03-1976"));
		
		cursoRepository.save(c1);
		alunoRepository.save(a1);
		
		c1.addAluno(a1);
		
		cursoRepository.save(c1);
		alunoRepository.save(a1);

	}
	
	
}
