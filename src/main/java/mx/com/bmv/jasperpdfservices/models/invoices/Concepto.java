package mx.com.bmv.jasperpdfservices.models.invoices;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Concepto {

    @JsonProperty("NoIdentificacion")
    private String noIdentificacion;

    @JsonProperty("ClaveProdServ")
    private String claveProdServ;

    @JsonProperty("Cantidad")
    private String cantidad;

    @JsonProperty("ClaveUnidad")
    private String claveUnidad;

    @JsonProperty("Unidad")
    private String unidad;

    @JsonProperty("Descripcion")
    private String descripcion;

    @JsonProperty("ValorUnitario")
    private String valorUnitario;

    @JsonProperty("Importe")
    private String importe;

    @JsonProperty("Impuestos")
    private Impuestos impuestos;

    @JsonProperty("InformacionAduanera")
    private InformacionAduanera informacionAduanera;

    @JsonProperty("CuentaPredial")
    private CuentaPredial cuentaPredial;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InformacionAduanera {

        @JsonProperty("NumeroPedimento")
        private String numeroPedimento;

        public String getNumeroPedimento() {
            return numeroPedimento;
        }

        public void setNumeroPedimento(String numeroPedimento) {
            this.numeroPedimento = numeroPedimento;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CuentaPredial {

        @JsonProperty("Numero")
        private String numero;

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }
    }

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getClaveProdServ() {
        return claveProdServ;
    }

    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public InformacionAduanera getInformacionAduanera() {
        return informacionAduanera;
    }

    public void setInformacionAduanera(InformacionAduanera informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }

    public CuentaPredial getCuentaPredial() {
        return cuentaPredial;
    }

    public void setCuentaPredial(CuentaPredial cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }
}

