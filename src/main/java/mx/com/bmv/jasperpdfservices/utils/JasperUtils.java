package mx.com.bmv.jasperpdfservices.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JasperUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static byte[] generateJasperReport(Map<String, Object> parameters, String path) throws JRException {
        JasperReport report;
        report = (JasperReport) JRLoader.loadObjectFromFile(path);
        return JasperRunManager.runReportToPdf(report, parameters);
    }

    public static <T> T mapperXmlToModel(String xml, Class<T> clazz) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, clazz);
    }

    public static InputStream toStream(Object data) throws JsonProcessingException {
        return new ByteArrayInputStream(objectMapper.writeValueAsString(data).getBytes());
    }
}

