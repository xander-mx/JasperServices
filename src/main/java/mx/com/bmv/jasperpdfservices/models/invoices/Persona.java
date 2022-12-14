package mx.com.bmv.jasperpdfservices.models.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {
    @JsonProperty("Nombre")
    private String nombre;

    @JsonProperty("RegimenFiscal")
    private String regimenFiscal;

    @JsonProperty("Rfc")
    private String rfc;

    @JsonProperty("UsoCFDI")
    private String usoCFDI;

    @JsonProperty("RegimenFiscalReceptor")
    private String regimenFiscalReceptor;

    @JsonProperty("DomicilioFiscalReceptor")
    private String domicilioFiscalReceptor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(int regimenFiscal) {
        REGIMEN regimen = Arrays.stream(REGIMEN.values()).filter(reg -> reg.getCode() == regimenFiscal).findFirst().orElse(null);
        this.regimenFiscal = (regimen == null ? String.valueOf(regimenFiscal) : regimen.getCodeDescription());
    }

    public void setRegimenFiscalReceptor(int regimenFiscalReceptor) {
        REGIMEN regimen = Arrays.stream(REGIMEN.values()).filter(reg -> reg.getCode() == regimenFiscalReceptor).findFirst().orElse(null);
        this.regimenFiscalReceptor = (regimen == null ? String.valueOf(regimenFiscalReceptor) : regimen.getCodeDescription());
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getUsoCFDI() {
        return usoCFDI;
    }

    public void setUsoCFDI(String usoCFDI) {
        this.usoCFDI = USO_CFDI.valueOf(usoCFDI).getCodeDescription();
    }

    public String getRegimenFiscalReceptor() {
        return regimenFiscalReceptor;
    }

    public void setRegimenFiscalReceptor(String regimenFiscalReceptor) {
        this.regimenFiscalReceptor = regimenFiscalReceptor;
    }

    public String getDomicilioFiscalReceptor() {
        return domicilioFiscalReceptor;
    }

    public void setDomicilioFiscalReceptor(String domicilioFiscalReceptor) {
        this.domicilioFiscalReceptor = domicilioFiscalReceptor;
    }

    public enum REGIMEN {
        REGIMEN_601(601,"General de Ley Personas Morales"), REGIMEN_603(603, "Personas Morales con Fines no Lucrativos"),
        REGIMEN_605(605, "Sueldos y Salarios e Ingresos Asimilados a Salarios"), REGIMEN_606(606, "Arrendamiento"),
        REGIMEN_607(607,"R??gimen de Enajenaci??n o Adquisici??n de Bienes"), REGIMEN_608(608, "Dem??s ingresos"),
        REGIMEN_609(609, "Consolidaci??n"), REGIMEN_611(611, "Ingresos por Dividendos (socios y accionistas)"),
        REGIMEN_612(612, "Personas F??sicas con Actividades Empresariales y Profesionales"), REGIMEN_614(614, "Ingresos por intereses"),
        REGIMEN_615(615, "R??gimen de los ingresos por obtenci??n de premios"), REGIMEN_616(616, "Sin obligaciones fiscales"),
        REGIMEN_620(620, "Sociedades Cooperativas de Producci??n que optan por Diferir sus Ingresos"), REGIMEN_622(622, "Actividades Agr??colas, Ganaderas, Silv??colas y Pesqueras"),
        REGIMEN_623(623, "Opcional para Grupos de Sociedades"), REGIMEN_624(624, "Coordinados"),
        REGIMEN_628(628, "Hidrocarburos"), REGIMEN_629(629, "De los Reg??menes Fiscales Preferentes y de las Empresas Multinacionales"),
        REGIMEN_630(630, "Enajenaci??n de acciones en bolsa de valores");

        private int code;
        private String description;
        private String codeDescription;

        REGIMEN(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCodeDescription() {
            return this.code+ " - "+ this.description;
        }
    }

    public enum USO_CFDI {
        G01("G01", "Adquisici??n de mercanc??as"), G02("G02", "Devoluciones, descuentos o bonificaciones"),
        G03("G03", "Gastos en general"), I01("I01", "Construcciones"),
        I02("I02", "Mobiliario y equipo de oficina por inversiones"), I03("I03", "Equipo de transporte"),
        I04("I04", "Equipo de c??mputo y accesorios"), I05("I05","Dados, troqueles, moldes, matrices y herramental"),
        I06("I06","Comunicaciones telef??nicas"), I07("I07","Comunicaciones satelitales"),
        I08("I08","Otra maquinaria y equipo"), D01("D01","Honorarios m??dicos, dentales y gastos hospitalarios."),
        D02("D02","Gastos m??dicos por incapacidad o discapacidad"), D03("D03","Gastos funerales."),
        D04("D04","Donativos"), D05("D05","Intereses reales efectivamente pagados por cr??ditos hipotecarios (casa habitaci??n)."),
        D06("D06","Aportaciones voluntarias al SAR."), D07("D07","Primas por seguros de gastos m??dicos"),
        D08("D08","Gastos de transportaci??n escolar obligatoria."), D09("D09","Dep??sitos en cuentas para el ahorro, primas que tengan como base planes de pensiones."),
        D10("D10","Pagos por servicios educativos (colegiaturas)"), P01("P01","Por definir"),
        S01("S01", "Sin efectos fiscales"),
        CP01("CP01", "Pagos");

        private String code;
        private String description;
        private String codeDescription;

        USO_CFDI(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCodeDescription() {
            return this.code + " - " +this.description;
        }
    }
}

