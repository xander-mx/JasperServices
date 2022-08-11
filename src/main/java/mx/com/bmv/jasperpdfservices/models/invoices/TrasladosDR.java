package mx.com.bmv.jasperpdfservices.models.invoices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TrasladosDR {

  @JsonProperty("TrasladoDR")
  private TrasladoDR trasladoDR;

  public TrasladoDR getTrasladoDR() {
    return trasladoDR;
  }

  public void setTrasladoDR(TrasladoDR trasladoDR) {
    this.trasladoDR = trasladoDR;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class TrasladoDR {

    @JsonProperty("BaseDR")
    private String baseDR;

    @JsonProperty("ImpuestoDR")
    private String impuestoDR;

    @JsonProperty("TipoFactorDR")
    private String tipoFactorDR;

    @JsonProperty("TasaOCuotaDR")
    private String tasaOCuotaDR;

    @JsonProperty("ImporteDR")
    private String importeDR;

    public String getBaseDR() {
      return baseDR;
    }

    public void setBaseDR(String baseDR) {
      this.baseDR = baseDR;
    }

    public String getImpuestoDR() {
      for (IMPUESTOS impuesto : IMPUESTOS.values()) {
        if(impuestoDR.equals(impuesto.getId()))
          return  impuesto.getDescripcion();
      }
      return impuestoDR;
    }

    public void setImpuestoDR(String impuestoDR) {
      this.impuestoDR = impuestoDR;
    }

    public String getTipoFactorDR() {
      return tipoFactorDR;
    }

    public void setTipoFactorDR(String tipoFactorDR) {
      this.tipoFactorDR = tipoFactorDR;
    }

    public String getTasaOCuotaDR() {
      return tasaOCuotaDR;
    }

    public void setTasaOCuotaDR(String tasaOCuotaDR) {
      this.tasaOCuotaDR = tasaOCuotaDR;
    }

    public String getImporteDR() {
      return importeDR;
    }

    public void setImporteDR(String importeDR) {
      this.importeDR = importeDR;
    }

    protected enum IMPUESTOS {
      ISR("ISR", "001"),
      IVA("IVA", "002"),
      IEPS("IEPS", "003");

      private final String descripcion;
      private final String id;

      IMPUESTOS(String descripcion, String id) {
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
  }
}
