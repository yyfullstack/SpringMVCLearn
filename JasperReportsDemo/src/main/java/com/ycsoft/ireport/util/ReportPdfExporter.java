package com.ycsoft.ireport.util;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.io.OutputStream;

public class ReportPdfExporter implements IReportFileExporter {

	public void export(ReportPrint reportPrint, OutputStream os) throws JRException {
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, reportPrint.getJasperPrint());
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
		exporter.exportReport();
	}

}