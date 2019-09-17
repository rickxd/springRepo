package br.usjt.veiculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.veiculo.model.Calculadora;
import br.usjt.veiculo.model.Veiculo;
import br.usjt.veiculo.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculosRepo;
	
	@Autowired
	private Calculadora calculadora;
	
	public void salvar(Veiculo veiculo) {
		veiculosRepo.save(veiculo);
	}
	
	public List <Veiculo> listarTodos(){
		List <Veiculo> lista = veiculosRepo.findAll();
		for(Veiculo veiculo : lista) {
			veiculo.setAuto(calculadora.calculaRendimento(veiculo.getTanque(), veiculo.getRendimento()));
		}
		
		return lista;
	}
	
}
