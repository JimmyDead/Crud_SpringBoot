package com.produtos.apiRest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apiRest.models.Produto;
import com.produtos.apiRest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutosResources {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de Produtos")
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um unico produto pelo seu ID")
	public Produto listarProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value = "Insere um novo produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}

	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um produto pelo seu ID")
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);

	}

	@PutMapping("/produto")
	@ApiOperation(value = "Altera um produto")
	public Produto alterarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}

}
