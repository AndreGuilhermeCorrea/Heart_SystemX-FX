package model.dao;

import java.util.List;

import model.entities.Psico;

public interface PsicoDAO {

	void insert(Psico objPsico);

	void update(Psico objPsico);

	void deleteByCpf(String cpf);

	Psico findByCPF(String cpf);

	List<Psico> findAll();
}
