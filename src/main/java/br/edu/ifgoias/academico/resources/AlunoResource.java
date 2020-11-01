package br.edu.ifgoias.academico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
		
	}
	
	@GetMapping(value="/{idaluno}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer idaluno){
		
		Aluno aluno = service.findById(idaluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
		
		aluno = service.insert(aluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	@DeleteMapping(value = "/{idaluno}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idaluno) {
		service.delete(idaluno);
	}
	
	@PutMapping(value = "/{idaluno}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer idaluno, @RequestBody Aluno aluno) {
		service.update(idaluno, aluno);
	}
	

}
