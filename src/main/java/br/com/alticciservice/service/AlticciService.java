package br.com.alticciservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.alticciservice.domain.dto.SequenciaDTO;
import br.com.alticciservice.domain.dto.SequenciaListDTO;
import br.com.alticciservice.domain.entity.Sequencia;
import br.com.alticciservice.exception.NumeroInvalidoException;
import br.com.alticciservice.repository.SequenciaReposity;

@Service
public class AlticciService {
	
	@Autowired
	private SequenciaReposity sequenciaRepository;
	
	
	@Cacheable(cacheNames = "numeros", key = "{#indice}")
	public SequenciaListDTO salvarValor (Integer indice) {
		Sequencia sequencia = new Sequencia();		
		sequencia.setNumero(getIndice(indice));
		
		sequenciaRepository.save(sequencia);
		
		return findAll();
		
	}
	
	
	public SequenciaListDTO findAll() {
		SequenciaListDTO sequenciaListDTO = new SequenciaListDTO();
		List<Integer> listaNumero = new ArrayList<>();
		
		sequenciaRepository.findAll().forEach(sequencia-> listaNumero.add(sequencia.getNumero()));
		sequenciaListDTO.setNumeros(listaNumero);
		
		return sequenciaListDTO;
	}
	
	
	@Cacheable(cacheNames = "numeroById")
	public SequenciaDTO getById(Long id) {
		
		 return convertToDTO(sequenciaRepository.findById(id));
	}
	
	
	private Integer getIndice(Integer indice) {
		Integer indiceAtual = 0; 
		switch (indice) {
		case 0:
			indiceAtual = 0;		
			break;
		case 1:
			indiceAtual = 1;
			break;
		case 2:
			indiceAtual = 1;
			break;
		default:
			if(indice < -0) {
				throw new NumeroInvalidoException("O número não pode ser negativo");
			}
			indiceAtual= calcularMaiorQueDois(indice);
			break;
		}
		
		return indiceAtual;
	}
	
	
	private Integer calcularMaiorQueDois(Integer indice) {
		Integer indiceResultado = 0;
		
		indiceResultado = (indice - 3) + (indice - 2);
		
		return indiceResultado;
	}
	
	private SequenciaDTO convertToDTO(Sequencia sequencia) {
		SequenciaDTO sequenciaDTO = new SequenciaDTO();
		sequenciaDTO.setId(sequencia.getId());
		sequenciaDTO.setNumero(sequencia.getNumero());
		
		return sequenciaDTO;
	}
	
	private SequenciaDTO convertToDTO(Optional<Sequencia> sequencia) {
		SequenciaDTO sequenciaDTO = new SequenciaDTO();
		sequenciaDTO.setId(sequencia.get().getId());
		sequenciaDTO.setNumero(sequencia.get().getNumero());
		
		return sequenciaDTO;
	}
	
	private List<SequenciaDTO> convertToDTO(List<Sequencia> sequencias) {
		List<SequenciaDTO> listaSeqenciaDTO = new ArrayList<>();
		sequencias.forEach(sequencia-> listaSeqenciaDTO.add(convertToDTO(sequencia)));
		
		return listaSeqenciaDTO;
	}


}
