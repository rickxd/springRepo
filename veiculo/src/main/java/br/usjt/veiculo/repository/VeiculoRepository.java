package br.usjt.veiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.veiculo.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
