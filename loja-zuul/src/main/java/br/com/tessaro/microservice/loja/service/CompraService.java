package br.com.tessaro.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.tessaro.microservice.loja.model.dto.InfoFornecedorDTO;
import br.com.tessaro.microservice.loja.model.dto.compraDTO;

@Service
public class CompraService {

	@Autowired
	private RestTemplate client;
	
	public void realizaCompra(compraDTO compra) {
		ResponseEntity<InfoFornecedorDTO> exchange =
				client.exchange("http://zuul/api/fornecedores/info/"+compra.getEndereco().getEstado(), 
						HttpMethod.GET, 
						null, 
						InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());

	}
	
}
