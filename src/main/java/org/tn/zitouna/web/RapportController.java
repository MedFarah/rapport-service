package org.tn.zitouna.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tn.zitouna.dao.RapportOperationDeviseRepository;
import org.tn.zitouna.dao.RapportPPRepository;
import org.tn.zitouna.entities.RapportOperationDevise;
import org.tn.zitouna.service.GenerateRapportImpl;
import org.tn.zitouna.service.RapportPMService;

@RestController
public class RapportController {

	@Autowired
	private GenerateRapportImpl generateRapportImpl;
	@Autowired
	private RapportOperationDeviseRepository rp;
	@Autowired
	private RapportPPRepository rrp;
	
	@RequestMapping(path = "/show",produces = "application/json",method = RequestMethod.GET)
	public List<RapportOperationDevise> show()  {
		System.out.println("***********"+rp.count());
		//RapportOperationDevise r =new RapportOperationDevise();
	//	r.setNumeroDeclaration(55L);r.setCodeEnregistrement(310);
		//rp.save(r);
		return rp.findAll();
	}
	
	@GetMapping("/test/{reportFormat}")
	public String generateRapport(@PathVariable String reportFormat) throws Exception {
		return generateRapportImpl.generateRapportOD(reportFormat);
	}
}
