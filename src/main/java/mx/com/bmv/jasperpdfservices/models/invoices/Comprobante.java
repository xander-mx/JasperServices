package mx.com.bmv.jasperpdfservices.models.invoices;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comprobante {
    private String schemaLocation;

    private String textQR;

    private String cadenaOriginal;

    private String importeLetra;

    @JsonProperty("Certificado")
    private String certificado;

    @JsonProperty("Fecha")
    private String fecha;

    @JsonProperty("Folio")
    private String folio;

    @JsonProperty("FormaPago")
    private String formaPago;

    @JsonProperty("LugarExpedicion")
    private String lugarExpedicion;

    @JsonProperty("MetodoPago")
    private String metodoPago;

    @JsonProperty("Moneda")
    private String moneda;

    @JsonProperty("NoCertificado")
    private String noCertificado;

    @JsonProperty("Sello")
    private String sello;

    @JsonProperty("Serie")
    private String serie;

    @JsonProperty("SubTotal")
    private String subTotal;

    @JsonProperty("TipoCambio")
    private String tipoCambio;

    @JsonProperty("TipoDeComprobante")
    private String tipoDeComprobante;

    @JsonProperty("Total")
    private String total;

    @JsonProperty("Version")
    private String version;

    @JsonProperty("Emisor")
    private Persona emisor;

    @JsonProperty("Receptor")
    private Persona receptor;

    @JsonProperty("Conceptos")
    private List<Concepto> conceptos;

    @JsonProperty("Impuestos")
    private Impuestos impuestos;

    @JsonProperty("Complemento")
    private Complemento complemento;

    public String getImporteLetra() {
        return importeLetra;
    }

    public void setImporteLetra(String importeLetra) {
        this.importeLetra = importeLetra;
    }

    public String getCadenaOriginal() {
        return cadenaOriginal;
    }

    public void setCadenaOriginal(String cadenaOriginal) {
        this.cadenaOriginal = cadenaOriginal;
    }

    public String getTextQR() {
        return textQR;
    }

    public void setTextQR(String textQR) {
        this.textQR = textQR;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public Persona getReceptor() {
        return receptor;
    }

    public void setReceptor(Persona receptor) {
        this.receptor = receptor;
    }

    public List<Concepto> getConceptos() {
        return conceptos;
    }

    public void setConceptos(List<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        FORMA_PAGO forma_pago = Arrays.stream(FORMA_PAGO.values()).filter(forma -> Objects.equals(forma.getCode(), formaPago)).findFirst().orElse(null);
        this.formaPago = (forma_pago == null ? formaPago : forma_pago.getCodeDescription());
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getCertificado() {
        return this.certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public Persona getEmisor() {
        return emisor;
    }

    public void setEmisor(Persona emisor) {
        this.emisor = emisor;
    }

    protected enum FORMA_PAGO {
        EFECTIVO("Efectivo","01"),
        CHEQUE("Cheque nominativo","02"),
        TRANSFERENCIA("Transferencia electrónica de fondos","03"),
        CREDITO("Tarjeta de crédito","04"),
        MONEDERO("Monedero electrónico","05"),
        DINERO("Dinero electrónico","06"),
        VALES("Vales de despensa","08"),
        CONSIGNACION("Pago por consignación","14"),
        CONDONACION("Condonación","15"),
        COMPENSACION("Compensación","17"),
        DEBITO("Tarjeta de débito","28"),
        SERVICIOS("Tarjeta de servicios","29"),
        ANTICIPOS("Aplicación de anticipos","30"),
        POR_DEFINIR("Por definir","99");

        private String description;
        private String code;

        FORMA_PAGO(String descripcion, String code) {
            this.description = descripcion;
            this.code = code;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public String getCode() {
            return code;
        }

        public String getCodeDescription() {
            return this.code + " - " +this.description;
        }
    }
}

