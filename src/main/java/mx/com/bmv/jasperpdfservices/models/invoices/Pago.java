package mx.com.bmv.jasperpdfservices.models.invoices;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pago {

    @JsonProperty("FechaPago")
    private String fechaPago;

    @JsonProperty("FormaDePagoP")
    private String formaDePagoP;

    @JsonProperty("MonedaP")
    private String monedaP;

    @JsonProperty("Monto")
    private String monto;

    @JsonProperty("RfcEmisorCtaBen")
    private String rfcEmisorCtaBen;

    @JsonProperty("CtaBeneficiario")
    private String ctaBeneficiario;

    @JsonProperty("RfcEmisorCtaOrd")
    private String rfcEmisorCtaOrd;

    @JsonProperty("CtaOrdenante")
    private String ctaOrdenante;

    @JsonProperty("DoctoRelacionado")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<DoctoRelacionado> doctoRelacionado;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DoctoRelacionado {

        @JsonProperty("IdDocumento")
        private String idDocumento;

        @JsonProperty("MonedaDR")
        private String monedaDR;

        @JsonProperty("MetodoDePagoDR")
        private String metodoDePagoDR;

        @JsonProperty("NumParcialidad")
        private String numParcialidad;

        @JsonProperty("ImpSaldoAnt")
        private String impSaldoAnt;

        @JsonProperty("ImpPagado")
        private String impPagado;

        @JsonProperty("ImpSaldoInsoluto")
        private String impSaldoInsoluto;

        @JsonProperty("Folio")
        private String folio;

        @JsonProperty("ImpuestosDR")
        public ImpuestosDR impuestosDR;

        public ImpuestosDR getImpuestosDR() {
            return impuestosDR;
        }

        public void setImpuestosDR(ImpuestosDR impuestosDR) {
            this.impuestosDR = impuestosDR;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ImpuestosDR {
            @JsonProperty("TrasladosDR")
            private TrasladosDR trasladosDR;

            public TrasladosDR getTrasladosDR() {
                return trasladosDR;
            }

            public void setTrasladosDR(TrasladosDR trasladosDR) {
                this.trasladosDR = trasladosDR;
            }
        }

        public String getIdDocumento() {
            return idDocumento;
        }

        public void setIdDocumento(String idDocumento) {
            this.idDocumento = idDocumento;
        }

        public String getMonedaDR() {
            return monedaDR;
        }

        public void setMonedaDR(String monedaDR) {
            this.monedaDR = monedaDR;
        }

        public String getMetodoDePagoDR() {
            return metodoDePagoDR;
        }

        public void setMetodoDePagoDR(String metodoDePagoDR) {
            this.metodoDePagoDR = metodoDePagoDR;
        }

        public String getNumParcialidad() {
            return numParcialidad;
        }

        public void setNumParcialidad(String numParcialidad) {
            this.numParcialidad = numParcialidad;
        }

        public String getImpSaldoAnt() {
            return impSaldoAnt;
        }

        public void setImpSaldoAnt(String impSaldoAnt) {
            this.impSaldoAnt = impSaldoAnt;
        }

        public String getImpPagado() {
            return impPagado;
        }

        public void setImpPagado(String impPagado) {
            this.impPagado = impPagado;
        }

        public String getImpSaldoInsoluto() {
            return impSaldoInsoluto;
        }

        public void setImpSaldoInsoluto(String impSaldoInsoluto) {
            this.impSaldoInsoluto = impSaldoInsoluto;
        }

        public String getFolio() {
            return folio;
        }

        public void setFolio(String folio) {
            this.folio = folio;
        }
    }

    protected enum FORMA_PAGO_SAT {
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

        private final String descripcion;
        private final String id;

        FORMA_PAGO_SAT(String descripcion, String id) {
            this.descripcion = descripcion;
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getId() {
            return id;
        }
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFormaDePagoP() {
        String formaPagoCompleto = null;
        for(FORMA_PAGO_SAT forma : FORMA_PAGO_SAT.values()) {
            if(formaDePagoP.equals(forma.getId())) {
                formaPagoCompleto = formaDePagoP.concat(" - ").concat(forma.getDescripcion());
            }
        }
        return formaPagoCompleto != null ? formaPagoCompleto : formaDePagoP ;
    }

    public void setFormaDePagoP(String formaDePagoP) {
        this.formaDePagoP = formaDePagoP;
    }

    public String getMonedaP() {
        return monedaP;
    }

    public void setMonedaP(String monedaP) {
        this.monedaP = monedaP;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getRfcEmisorCtaBen() {
        return rfcEmisorCtaBen;
    }

    public void setRfcEmisorCtaBen(String rfcEmisorCtaBen) {
        this.rfcEmisorCtaBen = rfcEmisorCtaBen;
    }

    public List<DoctoRelacionado> getDoctoRelacionado() {
        return doctoRelacionado;
    }

    public void setDoctoRelacionado(List<DoctoRelacionado> doctoRelacionado) {
        this.doctoRelacionado = doctoRelacionado;
    }

    public String getCtaBeneficiario() {
        return ctaBeneficiario;
    }

    public void setCtaBeneficiario(String ctaBeneficiario) {
        this.ctaBeneficiario = ctaBeneficiario;
    }

    public String getRfcEmisorCtaOrd() {
        return rfcEmisorCtaOrd;
    }

    public void setRfcEmisorCtaOrd(String rfcEmisorCtaOrd) {
        this.rfcEmisorCtaOrd = rfcEmisorCtaOrd;
    }

    public String getCtaOrdenante() {
        return ctaOrdenante;
    }

    public void setCtaOrdenante(String ctaOrdenante) {
        this.ctaOrdenante = ctaOrdenante;
    }
}

