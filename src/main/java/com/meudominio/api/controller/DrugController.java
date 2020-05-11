package com.meudominio.api.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meudominio.api.entities.Drug;

@CrossOrigin
@RestController // Define como uma classe que faz interações REST
public class DrugController {

	@CrossOrigin
	@RequestMapping(value = "/drugs", method = RequestMethod.GET) // Define a "rota" e marca
	public List<Drug> listDrugs() {
		
		Drug drug1 = new Drug() ;
		drug1.setId(1L);
		drug1.setTitle("Paracetamol");
		drug1.setValue("50,00");
		drug1.setAmount("5");
		drug1.setImage("https://static-webv8.jet.com.br/drogaosuper/Produto/multifotos/hd/5409032017091306.jpg");
		
		Drug drug2 = new Drug() ;
		drug2.setId(2L);
		drug2.setTitle("Ibuprofeno");
		drug2.setValue("20,00");
		drug2.setAmount("8");
		drug2.setImage("https://drogariavenancio.vteximg.com.br/arquivos/ids/563624-1000-1000/62897_Z.jpg?v=636966115928530000");
		
		Drug drug3 = new Drug() ;
		drug3.setId(3L);
		drug3.setTitle("Dipirona");
		drug3.setValue("10,00");
		drug3.setAmount("12");
		drug3.setImage("https://www.sansilfarma.com.br/BACKOFFICE/Uploads/Produto/Ampliada/237818.png");
		
		Drug drug4 = new Drug() ;
		drug4.setId(4L);
		drug4.setTitle("Benzetacil");
		drug4.setValue("180,00");
		drug4.setAmount("50");
		drug4.setImage("https://www.acritica.com/uploads/news/image/105762/show_1.png");
		
		
		return Arrays.asList(drug1, drug2, drug3, drug4);
	}
}
