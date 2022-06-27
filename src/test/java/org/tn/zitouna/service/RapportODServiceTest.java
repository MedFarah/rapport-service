package org.tn.zitouna.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.tn.zitouna.dao.RapportOperationDeviseRepository;
import org.tn.zitouna.entities.RapportOperationDevise;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RapportODServiceTest {

	@Mock
	 RapportOperationDeviseRepository rapportOperationDeviseRepository;
	@InjectMocks
	 RapportODService rapportODService;
	 RapportOperationDevise rapportOperationDevise;
	
	@BeforeEach
	public void setUp() throws Exception {
		rapportOperationDevise = new RapportOperationDevise();
		rapportOperationDevise.setNumeroDeclaration(77L);
		rapportOperationDevise.setTypeCompteBeneficiaire("courant");
	}

	@Test
	void testAjouterRapport() {
		when(rapportOperationDeviseRepository.save(ArgumentMatchers.any(RapportOperationDevise.class))).thenReturn(rapportOperationDevise);
		assertNotEquals(rapportODService.ajouterRapport(rapportOperationDevise), rapportOperationDevise);
		
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
		when(rapportOperationDeviseRepository.findById(rapportOperationDevise.getNumeroDeclaration())).thenReturn(Optional.of(rapportOperationDevise));
		rapportODService.supprimerRapport(rapportOperationDevise.getNumeroDeclaration());
		verify(rapportOperationDeviseRepository,times(1)).deleteById(77L);
	}

	@Test
	void testAfficherRapportById() {
		when(rapportOperationDeviseRepository.findById(rapportOperationDevise.getNumeroDeclaration())).thenReturn(Optional.of(rapportOperationDevise));
		assertEquals(rapportOperationDevise, rapportODService.afficherRapportById(rapportOperationDevise.getNumeroDeclaration()));
	}

	@Test
	void testAfficherRapports() {
		when(rapportOperationDeviseRepository.findAll()).thenReturn(null);
		assertEquals(null,rapportODService.afficherRapports());
	}

}
