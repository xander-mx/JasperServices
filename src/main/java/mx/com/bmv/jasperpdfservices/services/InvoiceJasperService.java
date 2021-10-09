package mx.com.bmv.jasperpdfservices.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.zxing.WriterException;
import mx.com.bmv.jasperpdfservices.models.invoices.Comprobante;
import mx.com.bmv.jasperpdfservices.models.invoices.Concepto;
import mx.com.bmv.jasperpdfservices.models.invoices.Pago;
import mx.com.bmv.jasperpdfservices.utils.JasperUtils;
import mx.com.bmv.jasperpdfservices.utils.JsonUtils;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static mx.com.bmv.jasperpdfservices.utils.NumberToLetterConverter.convertNumberToLetter;

@Service
public class InvoiceJasperService {

    public static final String PIPE = "|";
    public static final String COMPROBANTE = "Comprobante";
    public static final String CONCEPTOS = "Conceptos";
    public static final String CONCEPTO = "Concepto";
    public static final String ABBREMISOR = "&re=";
    public static final String ABBRRECEPTOR = "&rr=";
    public static final String ABBRTOTAL = "&tt=";
    public static final String ABBRSELLO = "&fe=";
    public static final String URL_CONSULTA_SAT = "https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx?id=";
    public static final String VERSION_XML = "||1.1|";
    public static final String END_CADENA_ORIGINAL = "||";
    public static final String DOCUMENT_TYPE = "P";
    public static final String DOCTOS_RELACIONADOS = "DoctosRelacionados";
    public static final String COMPLEMENTO = "Complemento";
    public static final String PAGOS = "Pagos";
    public static final String PAGO = "Pago";
    public static final String DOCTO_RELACIONADO = "DoctoRelacionado";

    private final ReportJasperService reportJasperService;

    @Inject
    public InvoiceJasperService(ReportJasperService reportJasperService) {
        this.reportJasperService = reportJasperService;
    }

    public String generateInvoiceJasperPdf(byte[] xmlToTransform) throws IOException, JRException, WriterException {
        JsonUtils<Comprobante> jsonUtils = new JsonUtils<>();
        ObjectMapper om = new ObjectMapper();
        ObjectNode singleInvoiceJson;

        Comprobante comprobante = JasperUtils.mapperXmlToModel(new String(xmlToTransform, StandardCharsets.UTF_8), Comprobante.class);
        comprobante.setTextQR(generateTextQR(comprobante));
        comprobante.setCadenaOriginal(generateOriginalString(comprobante));
        comprobante.setImporteLetra(convertNumberToLetter(comprobante.getTotal()));

        singleInvoiceJson = jsonUtils.convertToObjectNodeWithNull(COMPROBANTE,comprobante);
        generateConceptsNode( singleInvoiceJson,  comprobante,om);

        if(comprobante.getTipoDeComprobante().equals(DOCUMENT_TYPE)) {
            createTemplatePaymentComplement(om, singleInvoiceJson, comprobante);
        }

        return reportJasperService.reportInvoice(singleInvoiceJson, comprobante.getTipoDeComprobante());
    }

    private void generateConceptsNode(ObjectNode singleInvoiceJson, Comprobante comprobante,ObjectMapper om) {
        JsonUtils<Concepto> jsonConceptUtils = new JsonUtils<>();
        ObjectNode conceptJson = om.createObjectNode();
        ArrayNode conceptsArray = conceptJson.putArray(CONCEPTOS);

        ((ObjectNode)singleInvoiceJson.get(COMPROBANTE)).remove(CONCEPTOS);

        for(Concepto concepto : comprobante.getConceptos()) {
            conceptJson = jsonConceptUtils.convertToObjectNodeWithNull(CONCEPTO,concepto);
            conceptsArray.add(conceptJson);
        }

        ((ObjectNode)singleInvoiceJson.get(COMPROBANTE)).set(CONCEPTOS,conceptsArray);
    }

    private void createTemplatePaymentComplement(ObjectMapper om, ObjectNode singleInvoiceJson, Comprobante comprobante) {
        JsonUtils<Pago.DoctoRelacionado> jsonDoctoRelUtils = new JsonUtils<>();
        ObjectNode doctoRelJson = om.createObjectNode();
        ArrayNode doctosArray = doctoRelJson.putArray(DOCTOS_RELACIONADOS);

        ((ObjectNode)singleInvoiceJson.get(COMPROBANTE)
                .get(COMPLEMENTO)
                .get(PAGOS)
                .get(PAGO)).remove(DOCTO_RELACIONADO);

        for(Pago.DoctoRelacionado docto : comprobante.getComplemento().getPagos().getPago().getDoctoRelacionado()) {
            doctoRelJson = jsonDoctoRelUtils.convertToObjectNodeWithNull(DOCTO_RELACIONADO,docto);
            doctosArray.add(doctoRelJson);
        }

        ((ObjectNode)singleInvoiceJson.get(COMPROBANTE)
                .get(COMPLEMENTO)
                .get(PAGOS)
                .get(PAGO)).set(DOCTOS_RELACIONADOS,doctosArray);
    }

    private String generateTextQR(Comprobante comprobante) {
        return URL_CONSULTA_SAT +
                comprobante.getComplemento().getTimbreFiscalDigital().getUuid() +
                ABBREMISOR + comprobante.getEmisor().getRfc() + ABBRRECEPTOR + comprobante.getReceptor().getRfc() + ABBRTOTAL + comprobante.getTotal() + ABBRSELLO +
                comprobante.getComplemento().getTimbreFiscalDigital().getSelloCFD().substring(comprobante.getComplemento().getTimbreFiscalDigital().getSelloCFD().length() - 8);
    }

    private String generateOriginalString(Comprobante comprobante) {
        return VERSION_XML +
                comprobante.getComplemento().getTimbreFiscalDigital().getUuid() +
                PIPE + comprobante.getComplemento().getTimbreFiscalDigital().getFechaTimbrado() +
                PIPE + comprobante.getComplemento().getTimbreFiscalDigital().getRfcProvCertif() +
                PIPE + comprobante.getComplemento().getTimbreFiscalDigital().getSelloCFD() +
                PIPE + comprobante.getComplemento().getTimbreFiscalDigital().getNoCertificadoSAT() +
                END_CADENA_ORIGINAL;
    }
}
