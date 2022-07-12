package br.com.alticciservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alticciservice.domain.dto.SequenciaDTO;
import br.com.alticciservice.domain.dto.SequenciaListDTO;
import br.com.alticciservice.service.AlticciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Alticci endpoints")
@RestController
@RequestMapping("/alticci")
public class AlticciController {
	
	
	@Autowired
	private AlticciService alticciService;
	
	
	
	@Operation(summary = "Informar um novo índice")
	@PostMapping("/{indice}")
	@ResponseStatus(HttpStatus.CREATED)
	public SequenciaListDTO salvar(@PathVariable Integer indice) {
		return alticciService.salvarValor(indice);
	}
	
	@Operation(summary = "Buscar todos os índices")
	@GetMapping
	public SequenciaListDTO all(){
		return alticciService.findAll();
	}
	
	@Operation(summary = "Buscar um índice pelo ID")
	@GetMapping("/{id}")
	public SequenciaDTO getById(@PathVariable Long id ){
		return alticciService.getById(id);
	}

}
