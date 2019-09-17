package br.usjt.veiculo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.veiculo.model.Veiculo;
import br.usjt.veiculo.service.VeiculoService;

@Controller
public class VeiculoController {
	@Autowired
	private VeiculoService vs;
	
	@GetMapping ("/veiculo")
	public ModelAndView listarVeiculos() {
		ModelAndView mv = new ModelAndView("lista_veiculos");
		mv.addObject(new Veiculo());
		List <Veiculo> veiculos = vs.listarTodos();
		mv.addObject("veiculos", veiculos);
		return mv;
	}
	
	@PostMapping ("/veiculo")
	public String salvar(Veiculo veiculo) {
		vs.salvar(veiculo);
		return "redirect:/veiculo";
	}
}
