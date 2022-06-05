package org.tn.zitouna.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.tn.zitouna.dao.RapportOperationDeviseRepository;
import org.tn.zitouna.entities.RapportOperationDevise;

@RunWith(MockitoJUnitRunner.Silent.class)
class RapportODServiceTest {

	@Mock
	private RapportOperationDeviseRepository rapportOperationDeviseRepository;
	@InjectMocks
	private RapportODService rapportODService;
	private RapportOperationDevise rapportOperationDevise;
	
	@Before
	public void setUp() throws Exception {
		rapportOperationDevise.setNumeroDeclaration(77L);
		rapportOperationDevise.setTypeCompteBeneficiaire("courant");
	}

	@Test
	void testAjouterRapport() {
		when(rapportOperationDeviseRepository.save(ArgumentMatchers.any(RapportOperationDevise.class))).thenReturn(rapportOperationDevise);
		assertEquals(rapportODService.ajouterRapport(rapportOperationDevise), rapportOperationDevise);
	}

	@Test
	void testModifierRapport() {
		rapportOperationDevise.setTypeCompteBeneficiaire("testUpdate");
		when(rapportOperationDeviseRepository.findById(rapportOperationDevise.getNumeroDeclaration())).thenReturn(Optional.of(rapportOperationDevise));
		rapportODService.modifierRapport(rapportOperationDevise);
		assertEquals("testUpdate", rapportOperationDevise.getTypeCompteBeneficiaire());
	}

	@Test
	void testSupprimerRapport() {
		fail("Not yet implemented");
	}

	@Test
	void testAfficherRapportById() {
		fail("Not yet implemented");
	}

	@Test
	void testAfficherRapports() {
		fail("Not yet implemented");
	}

}
