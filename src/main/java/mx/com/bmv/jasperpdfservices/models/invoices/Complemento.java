package mx.com.bmv.jasperpdfservices.models.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Complemento {
    @JsonProperty("TimbreFiscalDigital")
    private TimbreFiscalDigital timbreFiscalDigital;

    @JsonProperty("Pagos")
    private Pagos pagos;

    @JsonProperty("Comentarios")
    private Comentarios comentarios;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pagos {
        private String schemaLocation;

        @JsonProperty("Version")
        private String version;

        @JsonProperty("Pago")
        private Pago pago;

        public String getSchemaLocation() {
            return schemaLocation;
        }

        public void setSchemaLocation(String schemaLocation) {
            this.schemaLocation = schemaLocation;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Pago getPago() {
            return pago;
        }

        public void setPago(Pago pago) {
            this.pago = pago;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TimbreFiscalDigital {

        @JsonProperty("SelloSAT")
        private String selloSAT;

        @JsonProperty("NoCertificadoSAT")
        private String noCertificadoSAT;

        @JsonProperty("SelloCFD")
        private String selloCFD;

        @JsonProperty("RfcProvCertif")
        private String rfcProvCertif;

        @JsonProperty("FechaTimbrado")
        private String fechaTimbrado;

        @JsonProperty("UUID")
        private String uuid;

        public String getSelloSAT() {
            return selloSAT;
        }

        public void setSelloSAT(String selloSAT) {
            this.selloSAT = selloSAT;
        }

        public String getNoCertificadoSAT() {
            return noCertificadoSAT;
        }

        public void setNoCertificadoSAT(String noCertificadoSAT) {
            this.noCertificadoSAT = noCertificadoSAT;
        }

        public String getSelloCFD() {
            return selloCFD;
        }

        public void setSelloCFD(String selloCFD) {
            this.selloCFD = selloCFD;
        }

        public String getRfcProvCertif() {
            return rfcProvCertif;
        }

        public void setRfcProvCertif(String rfcProvCertif) {
            this.rfcProvCertif = rfcProvCertif;
        }

        public String getFechaTimbrado() {
            return fechaTimbrado;
        }

        public void setFechaTimbrado(String fechaTimbrado) {
            this.fechaTimbrado = fechaTimbrado;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Comentarios {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public TimbreFiscalDigital getTimbreFiscalDigital() {
        return timbreFiscalDigital;
    }

    public void setTimbreFiscalDigital(TimbreFiscalDigital timbreFiscalDigital) {
        this.timbreFiscalDigital = timbreFiscalDigital;
    }

    public Pagos getPagos() {
        return pagos;
    }

    public void setPagos(Pagos pagos) {
        this.pagos = pagos;
    }

    public Comentarios getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentarios comentarios) {
        this.comentarios = comentarios;
    }
}

