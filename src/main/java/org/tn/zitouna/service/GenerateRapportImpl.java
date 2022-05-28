package org.tn.zitouna.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.tn.zitouna.dao.RapportOperationDeviseRepository;
import org.tn.zitouna.dao.RapportPMRepository;
import org.tn.zitouna.dao.RapportPPRepository;
import org.tn.zitouna.entities.RapportOperationDevise;
import org.tn.zitouna.entities.RapportPM;
import org.tn.zitouna.entities.RapportPP;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
public class GenerateRapportImpl implements GenerateRapport {

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
		String resultat = "failed";
		File file = ResourceUtils.getFile("classpath:rapports/rapportOperationDevise.jrxml");
		List<RapportOperationDevise> dataList = rapportOperationDevise.findAll();
		System.out.println("*************************" + dataList.size());
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("CollectionBeanParam", beanColDataSource);
		//compile rapport
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		// JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
		//remplir rapport
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		if (rapportFormat.equals("pdf")) {
			JRPdfExporter exporter = new JRPdfExporter();

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("rapportOperationDevise.pdf"));

			SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);

			SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("MoFarah");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");

			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);

			exporter.exportReport();
			resultat = "success";
		} else if (rapportFormat.equals("csv")) {

			// JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\ASUS\\Downloads\\rapportODJasper1.pdf");
			JRCsvExporter exporter = new JRCsvExporter();

			// Set input ...
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleWriterExporterOutput("rapportOperationDevise.csv"));
			exporter.exportReport();
			resultat = "{success}";
		} 
		/*
		 * else if(rapportFormat.equals("xls")) { JRXlsxExporter exporter = new
		 * JRXlsxExporter();
		 * 
		 * // Set input and output ... SimpleXlsxReportConfiguration reportConfig = new
		 * SimpleXlsxReportConfiguration();
		 * reportConfig.setsheetsetSheetNames(dataList);
		 * 
		 * exporter.setConfiguration(reportConfig); exporter.exportReport(); }
		 */

		return resultat;
	}

	@Override
	public String generateRapportPP(String rapportFormat) throws Exception {
		// TODO Auto-generated method stub
		String resultat = "failed";
		File file = ResourceUtils.getFile("classpath:rapports/rapportPersonnePhysique.jrxml");
		List<RapportPP> dataList = rapportPPRepository.findAll();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("CollectionBeanParam", beanColDataSource);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		// JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		if (rapportFormat.equals("pdf")) {
			JRPdfExporter exporter = new JRPdfExporter();

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("rapportPersonnePhysique.pdf"));

			SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);

			SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("MoFarah");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");

			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);

			exporter.exportReport();
			resultat = "success";
		} else if (rapportFormat.equals("csv")) {

			JRCsvExporter exporter = new JRCsvExporter();

			// Set input ...
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleWriterExporterOutput("rapportPersonnePhysique.csv"));
			exporter.exportReport();
			resultat = "success";
		}
		return resultat;
	}

	@Override
	public String generateRapportPM(String rapportFormat) throws Exception {
		// TODO Auto-generated method stub
		RapportPM test = new RapportPM();test.setAdresseEmail("test");test.setNumeroDeclaration(77L);
		rapportPMRepository.save(test);
		String resultat = "failed";
		File file = ResourceUtils.getFile("classpath:rapports/rapportPersonneMorale.jrxml");
		List<RapportPM> dataList = rapportPMRepository.findAll();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("CollectionBeanParam", beanColDataSource);
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		// JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		if (rapportFormat.equals("pdf")) {
			JRPdfExporter exporter = new JRPdfExporter();

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("rapportPersonneMorale.pdf"));

			SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);

			SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("MoFarah");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");

			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);

			exporter.exportReport();
			resultat = "success";
		} else if (rapportFormat.equals("csv")) {

			JRCsvExporter exporter = new JRCsvExporter();

			// Set input ...
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleWriterExporterOutput("rapportPersonneMorale.csv"));
			exporter.exportReport();
			resultat = "success";
		}
		return resultat;
	}

}
