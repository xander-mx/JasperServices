package mx.com.bmv.jasperpdfservices.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.zxing.WriterException;
import mx.com.bmv.jasperpdfservices.models.invoices.Comprobante;
import mx.com.bmv.jasperpdfservices.utils.CreateQR;
import mx.com.bmv.jasperpdfservices.utils.JasperUtils;
import mx.com.bmv.jasperpdfservices.utils.YAMLConfig;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportJasperService {

    public static final String QR_CODE = "qrCode";
    public static final String PNG = ".png";
    public static final String TEXT_QR = "textQR";
    public static final String INVOICE = "Invoice";
    public static final String JSON = ".json";
    public static final String CONCEPTS = "Concepts";
    public static final String PERCENTAGE = " %";
    public static final String DOCUMENT_TYPE = "P";
    public static final String DOCTOS_RELACIONADOS = "DoctosRelacionados";
    public static final String COMPLEMENTO = "Complemento";
    public static final String PAGOS = "Pagos";
    public static final String PAGO = "Pago";
    public static final String DOCTO_RELACIONADO = "DoctoRelacionado";
    public static final String DOCTOS_RELATIONS = "DoctosRelations";
    public static final String COMPROBANTE = "Comprobante";
    public static final String CONCEPTOS = "Conceptos";
    public static final String IMPUESTOS = "Impuestos";
    public static final String TASA_O_CUOTA = "TasaOCuota";
    public static final String TASA_O_CUOTA_RETENIDOS = "TasaOCuotaRetenidos";
    public static final String TIPO_DE_COMPROBANTE = "TipoDeComprobante";
    public static final String VOUCHER = "voucher";
    public static final String QR = "qr";
    public static final String CONCEPTO = "Concepto";
    public static final String TRASLADOS = "Traslados";
    public static final int ZERO = 0;
    public static final int HEIGHT_QR = 798;
    public static final int WEIGHT_QR = 800;
    public static final String SUBREPORT = "subreport";
    public static final String RETENCIONES = "Retenciones";

    private final YAMLConfig config;

    @Inject
    public ReportJasperService(YAMLConfig config) {
        this.config = config;
    }

    public String reportInvoice(ObjectNode dataXml, String type) throws IOException, JRException, WriterException {
        Map<String, Object> reportParameters= new HashMap<>();
        File imageQR = File.createTempFile(QR_CODE, PNG);
        byte[] report;
        byte[] qr = Files.readAllBytes(CreateQR.getGenerateQR(imageQR,dataXml.get(COMPROBANTE).get(TEXT_QR).asText() , HEIGHT_QR, WEIGHT_QR).toPath());

        File commonDataFile = File.createTempFile(INVOICE, JSON);
        BufferedWriter jsonFile = new BufferedWriter(new FileWriter(commonDataFile));
        jsonFile.write(dataXml.toString());
        jsonFile.flush();
        jsonFile.close();
        File conceptsFile = File.createTempFile(CONCEPTS, JSON);
        BufferedWriter conceptJson = new BufferedWriter(new FileWriter(conceptsFile));
        conceptJson.write(dataXml.get(COMPROBANTE).get(CONCEPTOS).toString());
        conceptJson.flush();
        conceptJson.close();

        reportParameters.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM, JasperUtils.toStream(dataXml));
        reportParameters.put(CONCEPTOS, new JsonDataSource(JasperUtils.toStream(dataXml.get(COMPROBANTE).get(CONCEPTOS)), CONCEPTO));
        /*reportParameters.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM, new FileInputStream(commonDataFile));*/
        /*reportParameters.put(CONCEPTOS, new JsonDataSource(new FileInputStream(conceptsFile), CONCEPTO));*/
        reportParameters.put(SUBREPORT,config.getSubReportInvoice());
        reportParameters.put(QR,new ByteArrayInputStream(qr));
        conceptsFile.delete();
        commonDataFile.delete();
        imageQR.delete();
        commonDataFile.deleteOnExit();

        report = type.equals(DOCUMENT_TYPE) ? generateReportPaymentComplement(reportParameters,dataXml) : generateReportInvoice(reportParameters,dataXml);

        return Base64.getEncoder().encodeToString(report);
    }

    private byte[] generateReportPaymentComplement(Map<String, Object> reportParameters,ObjectNode payment) throws IOException, JRException {
        File doctosFile = File.createTempFile(DOCTOS_RELATIONS, JSON);
        BufferedWriter doctosJson = new BufferedWriter(new FileWriter(doctosFile));
        doctosJson.write(payment.get(COMPROBANTE)
                .get(COMPLEMENTO)
                .get(PAGOS)
                .get(PAGO).get(DOCTOS_RELACIONADOS).toString());
        doctosJson.flush();
        doctosJson.close();

        reportParameters.put(DOCTOS_RELATIONS, new JsonDataSource(new FileInputStream(doctosFile), DOCTO_RELACIONADO));
        doctosFile.delete();
        return JasperUtils.generateJasperReport(reportParameters, config.getPayment());
    }

    private byte[] generateReportInvoice(Map<String, Object> reportParameters,ObjectNode invoice) throws JRException {
        reportParameters.put(VOUCHER, invoice.get(COMPROBANTE).get(TIPO_DE_COMPROBANTE));
        reportParameters.put(TASA_O_CUOTA,(invoice.get(COMPROBANTE).get(IMPUESTOS).get(TRASLADOS).get(ZERO).get(TASA_O_CUOTA).asDouble()*100)+ PERCENTAGE);
        if(!invoice.get(COMPROBANTE).get(IMPUESTOS).get(RETENCIONES).isNull())
            reportParameters.put(TASA_O_CUOTA_RETENIDOS,(invoice.get(COMPROBANTE).get(IMPUESTOS).get(RETENCIONES).get(ZERO).get(TASA_O_CUOTA).asDouble()*100)+ PERCENTAGE);
        return JasperUtils.generateJasperReport(reportParameters, config.getInvoice());
    }
}
