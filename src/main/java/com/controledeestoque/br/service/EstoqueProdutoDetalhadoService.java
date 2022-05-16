package com.controledeestoque.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.EstoqueProdutoDetalhadoModel;
import com.controledeestoque.br.repository.EstoqueProdutoDetalhadoRepository;

@Service
public class EstoqueProdutoDetalhadoService {

	@Autowired
	EstoqueProdutoDetalhadoRepository estoqueProdutoRepository;
	public void criarTabelaEstoque(EntradaModel entrada){
		
		EstoqueProdutoDetalhadoModel estoque = new EstoqueProdutoDetalhadoModel();
		
	
		List<EstoqueProdutoDetalhadoModel> lotes = estoqueProdutoRepository.findAllByloteProdutoContainingIgnoreCase(entrada.getLoteProduto());
		
		if(!lotes.isEmpty()) {
			boolean mesmoLote = false;
			for(EstoqueProdutoDetalhadoModel item : lotes) {
				System.out.println(item.getLoteProduto() == entrada.getLoteProduto() && item.getPrecoCustoUnitario() == entrada.getPrecoUnitario());
				System.out.println((item.getLoteProduto() == entrada.getLoteProduto()));
				System.out.println(item.getLoteProduto()+"item");
				System.out.println(entrada.getLoteProduto()+"entrada");
				System.out.println((item.getPrecoCustoUnitario() == entrada.getPrecoUnitario())+ "PREÇO");
				
				if(item.getLoteProduto() == entrada.getLoteProduto() && item.getPrecoCustoUnitario() == entrada.getPrecoUnitario()) {
					item.setQuantidadeEstoqueLote(entrada.getQuantidade());
					item.setValorTotalLote(entrada.getTotal());
					mesmoLote = true;
					estoqueProdutoRepository.save(item);
					System.out.println("oooooooooooooooooi");
					break;
				}
			}
			if(!mesmoLote) criarItemNovo(estoque,entrada);
			System.out.println("oooooooooooooooooi2");
		}else {
			System.out.println("Entreeei null");
			criarItemNovo(estoque,entrada);
		}
		
	}
	private void criarItemNovo(EstoqueProdutoDetalhadoModel estoque, EntradaModel entrada) {
		
		estoque.setPrecoCustoUnitario(entrada.getPrecoUnitario());
		estoque.setQuantidadeEstoqueLote(entrada.getQuantidade());
		estoque.setLoteProduto(entrada.getLoteProduto());
		estoque.setValorTotalLote(entrada.getTotal());
		estoque.setProduto(entrada.getProduto());
		estoqueProdutoRepository.save(estoque);
	}
}
