package com.meudominio.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meudominio.api.entities.Drug;
import com.meudominio.api.repositories.DrugRepository;

/*Responsável pelas principais regras de negocio da aplicação (SALVAR e Deletar)*/
@Service
public class DrugService {
	
	@Autowired(required=true) ///Instacia da Interface Drug
	private DrugRepository drugRepository ;
	
	//ADICIONAR UM NOVO REMÉDIO
	public Drug saveDrug (Drug drug) {
		return drugRepository.save(drug);
	}
	
	//EXCLUIR UM NOVO REMÉDIO
		public void deleteDrug (Long drugId) {
			drugRepository.deleteById(drugId);
		}
}
