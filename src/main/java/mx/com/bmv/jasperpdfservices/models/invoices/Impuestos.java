package mx.com.bmv.jasperpdfservices.models.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Impuestos {
    @JsonProperty("Traslados")
    private List<Traslado> traslados;

    @JsonProperty("Retenciones")
    private List<Retencion> retenciones;

    @JsonProperty("TotalImpuestosTrasladados")
    private String totalImpuestosTrasladados;

    @JsonProperty("TotalImpuestosRetenidos")
    private String totalImpuestosRetenidos;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Traslado {

        @JsonProperty("Base")
        private String base;

        @JsonProperty("Impuesto")
        private String impuesto;

        @JsonProperty("TipoFactor")
        private String tipoFactor;

        @JsonProperty("TasaOCuota")
        private String tasaOCuota;

        @JsonProperty("Importe")
        private String importe;

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public String getImpuesto() {
            return impuesto;
        }

        public void setImpuesto(String impuesto) {
            this.impuesto = impuesto;
        }

        public String getTipoFactor() {
            return tipoFactor;
        }

        public void setTipoFactor(String tipoFactor) {
            this.tipoFactor = tipoFactor;
        }

        public String getTasaOCuota() {
            return tasaOCuota;
        }

        public void setTasaOCuota(String tasaOCuota) {
            this.tasaOCuota = tasaOCuota;
        }

        public String getImporte() {
            return importe;
        }

        public void setImporte(String importe) {
            this.importe = importe;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Retencion {

        @JsonProperty("Base")
        private String base;

        @JsonProperty("Impuesto")
        private String impuesto;

        @JsonProperty("Importe")
        private String importe;

        @JsonProperty("TipoFactor")
        private String tipoFactor;

        @JsonProperty("TasaOCuota")
        private String tasaOCuota;

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public String getImpuesto() {
            return impuesto;
        }

        public void setImpuesto(String impuesto) {
            this.impuesto = impuesto;
        }

        public String getImporte() {
            return importe;
        }

        public void setImporte(String importe) {
            this.importe = importe;
        }

        public String getTipoFactor() {
            return tipoFactor;
        }

        public void setTipoFactor(String tipoFactor) {
            this.tipoFactor = tipoFactor;
        }

        public String getTasaOCuota() {
            return tasaOCuota;
        }

        public void setTasaOCuota(String tasaOCuota) {
            this.tasaOCuota = tasaOCuota;
        }
    }

    public List<Traslado> getTraslados() {
        return traslados;
    }

    public void setTraslados(List<Traslado> traslados) {
        this.traslados = traslados;
    }

    public List<Retencion> getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(List<Retencion> retenciones) {
        this.retenciones = retenciones;
    }

    public String getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    public void setTotalImpuestosRetenidos(String totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public String getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }

    public void setTotalImpuestosTrasladados(String totalImpuestosTrasladados) {
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
    }
}

