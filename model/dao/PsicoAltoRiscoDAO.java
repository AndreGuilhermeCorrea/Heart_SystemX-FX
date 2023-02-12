package model.dao;

import java.util.List;

import model.entities.PsicoAltoRisco;

public interface PsicoAltoRiscoDAO {

	void insert(PsicoAltoRisco objPAR);

	void update(PsicoAltoRisco objPAR);

	void deleteByCpf(String cpf);

	PsicoAltoRisco findByCPF(String cpf);

	List<PsicoAltoRisco> findAll();

}
