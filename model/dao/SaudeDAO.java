package model.dao;

import java.util.List;

import model.entities.Saude;

public interface SaudeDAO {

	void insert(Saude objSaude);

	void update(Saude objSaude);

	void deleteByCpf(String cpf);

	Saude findByCPF(String cpf);

	List<Saude> findAll();
}
