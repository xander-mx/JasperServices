package mx.com.bmv.jasperpdfservices.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.IOException;
import java.util.Map;

public class JasperUtils {

    public static byte[] generateJasperReport(Map<String, Object> parameters, String path) throws JRException {
        JasperReport report;
        report = (JasperReport) JRLoader.loadObjectFromFile(path);
        return JasperRunManager.runReportToPdf(report, parameters);
    }

    public static <T> T mapperXmlToModel(String xml, Class<T> clazz) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, clazz);
    }
}

