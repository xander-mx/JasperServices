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

    public enum REGIMEN {
        REGIMEN_601(601,"General de Ley Personas Morales"), REGIMEN_603(603, "Personas Morales con Fines no Lucrativos"),
        REGIMEN_605(605, "Sueldos y Salarios e Ingresos Asimilados a Salarios"), REGIMEN_606(606, "Arrendamiento"),
        REGIMEN_607(607,"Régimen de Enajenación o Adquisición de Bienes"), REGIMEN_608(608, "Demás ingresos"),
        REGIMEN_609(609, "Consolidación"), REGIMEN_611(611, "Ingresos por Dividendos (socios y accionistas)"),
        REGIMEN_612(612, "Personas Físicas con Actividades Empresariales y Profesionales"), REGIMEN_614(614, "Ingresos por intereses"),
        REGIMEN_615(615, "Régimen de los ingresos por obtención de premios"), REGIMEN_616(616, "Sin obligaciones fiscales"),
        REGIMEN_620(620, "Sociedades Cooperativas de Producción que optan por Diferir sus Ingresos"), REGIMEN_622(622, "Actividades Agrícolas, Ganaderas, Silvícolas y Pesqueras"),
        REGIMEN_623(623, "Opcional para Grupos de Sociedades"), REGIMEN_624(624, "Coordinados"),
        REGIMEN_628(628, "Hidrocarburos"), REGIMEN_629(629, "De los Regímenes Fiscales Preferentes y de las Empresas Multinacionales"),
        REGIMEN_630(630, "Enajenación de acciones en bolsa de valores");

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
        G01("G01", "Adquisición de mercancías"), G02("G02", "Devoluciones, descuentos o bonificaciones"),
        G03("G03", "Gastos en general"), I01("I01", "Construcciones"),
        I02("I02", "Mobiliario y equipo de oficina por inversiones"), I03("I03", "Equipo de transporte"),
        I04("I04", "Equipo de cómputo y accesorios"), I05("I05","Dados, troqueles, moldes, matrices y herramental"),
        I06("I06","Comunicaciones telefónicas"), I07("I07","Comunicaciones satelitales"),
        I08("I08","Otra maquinaria y equipo"), D01("D01","Honorarios médicos, dentales y gastos hospitalarios."),
        D02("D02","Gastos médicos por incapacidad o discapacidad"), D03("D03","Gastos funerales."),
        D04("D04","Donativos"), D05("D05","Intereses reales efectivamente pagados por créditos hipotecarios (casa habitación)."),
        D06("D06","Aportaciones voluntarias al SAR."), D07("D07","Primas por seguros de gastos médicos"),
        D08("D08","Gastos de transportación escolar obligatoria."), D09("D09","Depósitos en cuentas para el ahorro, primas que tengan como base planes de pensiones."),
        D10("D10","Pagos por servicios educativos (colegiaturas)"), P01("P01","Por definir"),
        S01("S01", "Sin efectos fiscales");

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

