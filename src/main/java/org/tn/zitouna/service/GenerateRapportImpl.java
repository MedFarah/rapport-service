package org.tn.zitouna.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.tn.zitouna.dao.RapportOperationDeviseRepository;
import org.tn.zitouna.dao.RapportPMRepository;
import org.tn.zitouna.dao.RapportPPRepository;
import org.tn.zitouna.entities.RapportOperationDevise;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Service
public class GenerateRapportImpl implements GenerateRapport{
	
	private RapportPMRepository rapportPMRepository;
	private RapportOperationDeviseRepository rapportOperationDevise;
	private RapportPPRepository rapportPPRepository;
	
	
	@Autowired
	public GenerateRapportImpl(RapportPMRepository rapportPMRepository,
			RapportOperationDeviseRepository rapportOperationDevise, RapportPPRepository rapportPPRepository) {
		super();
		this.rapportPMRepository = rapportPMRepository;
		this.rapportOperationDevise = rapportOperationDevise;
		this.rapportPPRepository = rapportPPRepository;
	}

	@Override
	public String generateRapportOD(String rapportFormat) throws Exception {
		// TODO Auto-generated method stub
		File file = ResourceUtils.getFile("classpath:Cherry_Landscape.jrxml");
		List<RapportOperationDevise> dataList = rapportOperationDevise.findAll();
		System.out.println("*************************"+dataList.size());
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("test", "MoFarah");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
		if(rapportFormat.equals("csv")) {
			/*JRPdfExporter exporter = new JRPdfExporter();

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(
			  new SimpleOutputStreamExporterOutput("employeeReport.pdf"));

			SimplePdfReportConfiguration reportConfig
			  = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);

			SimplePdfExporterConfiguration exportConfig
			  = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("baeldung");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");

			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);

			exporter.exportReport();*/
			
			JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\ASUS\\Downloads\\rapportODJasper.pdf");
			/*JRCsvExporter exporter = new JRCsvExporter();
			
			// Set input ...
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(
			  new SimpleWriterExporterOutput("ReportOD.csv"));

			exporter.exportReport();*/
		}

		return "";
	}

	@Override
	public String generateRapportPP(String rapportFormat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateRapportPM(String rapportFormat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
