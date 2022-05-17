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
				
				if(item.getPrecoCustoUnitario() == entrada.getPrecoUnitario() && item.getLoteProduto().equals(entrada.getLoteProduto())&&item.getProduto().getId() == entrada.getProduto().getId()) {
					item.setQuantidadeEstoqueLote(entrada.getQuantidade()+item.getQuantidadeEstoqueLote());
					item.setValorTotalLote(entrada.getTotal()+ item.getValorTotalLote());
					mesmoLote = true;
					estoqueProdutoRepository.save(item);
					break;
				}
			}
			if(!mesmoLote) criarItemNovo(estoque,entrada);
		}else {
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
