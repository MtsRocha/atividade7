package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Integer idaluno) {
		return repository.findById(idaluno)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Aluno insert(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public void delete(Integer idaluno) {
		repository.findById(idaluno).map(
				aluno -> {	repository.delete(aluno);
						  	return Void.TYPE;
						 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void update(Integer idaluno, Aluno obj) {
		repository.findById(idaluno).map(
				aluno -> {	aluno.setNome(obj.getNome());
							aluno.setDt_nasc(obj.getDt_nasc());
							aluno.setSexo(obj.getSexo());
							return repository.save(aluno);
						 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
		
}

