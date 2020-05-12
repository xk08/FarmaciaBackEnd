package com.meudominio.api.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.meudominio.api.entities.Drug;
import com.meudominio.api.repositories.DrugRepository;
import com.meudominio.api.services.DrugService;



@CrossOrigin
@RestController // Define como uma classe que faz interações REST
public class DrugController {
	
	//Instacia da Interface Drug
	@Autowired(required=true)
	private DrugRepository drugRepository;
	
	//Insstacia da classe Service
	@Autowired(required=true)
	private DrugService drugService;

	//MÉTODO PARA LISTAR TODOS OS REGISTROS
	@CrossOrigin
	@GetMapping("/drugs") // Define a "rota" e marca
	public List<Drug> listDrug() {
		return drugRepository.findAll() ; // Usando o método Find genérico herdado pela interface DrugRepository
	}
	
	// BUSCAR REGISTRO POR ID
	@CrossOrigin
	@GetMapping("/drugs/{drugId}")
	public Drug findDrug(@PathVariable Long drugId) {
		Optional<Drug> drug = drugRepository.findById(drugId) ; //Delega pra interface
		return drug.orElse(null) ;
	}
	
	//ADICIONAR NOVO REGISTRO
	@CrossOrigin
	@PostMapping("/drugs")
	public Drug saveDrug(@Valid @RequestBody Drug drug) { //Delega pra interface salvar
		return drugService.saveDrug(drug) ;
	}
	
	//ATUALIZANDO UM REGSITRO
	@CrossOrigin
	@PutMapping("/drugs/{drugId}")
	public ResponseEntity<Drug> updateDrug(@Valid @PathVariable Long drugId,
		@RequestBody Drug drug) {
		
		//Testa de o id já existe
		if (!drugRepository.existsById(drugId)) {
			return ResponseEntity.notFound().build(); // Caso não, encerra e exibe log
	}
		// Caso exista
		drug.setId(drugId); // Atribuiu o id existente
		drug = drugService.saveDrug(drug); //Atualiza o registro
		
		return ResponseEntity.ok(drug);
	}
	
	//APAGANDO UM REGSITRO
	@CrossOrigin
	@DeleteMapping("/drugs/{drugId}")
	public ResponseEntity<Void> removeDrug(@PathVariable Long drugId) {
		
		//Testa de o id já existe
		if (!drugRepository.existsById(drugId)) {
			return ResponseEntity.notFound().build(); // Caso não, encerra e exibe log
	}
		// Caso exista
		drugService.deleteDrug(drugId);; //Faz a exlcusão
		
		return ResponseEntity.noContent().build() ;
	}
	
}
