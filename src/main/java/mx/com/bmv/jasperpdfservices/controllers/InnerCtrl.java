package mx.com.bmv.jasperpdfservices.controllers;

import com.google.zxing.WriterException;
import mx.com.bmv.jasperpdfservices.models.dtos.CfdiRequest;
import mx.com.bmv.jasperpdfservices.services.InvoiceJasperService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping("/core")
public class InnerCtrl {

  private final InvoiceJasperService invoiceJasperService;

  @Inject
  public InnerCtrl(InvoiceJasperService invoiceJasperService){
    this.invoiceJasperService = invoiceJasperService;
  }

  @PostMapping(path="/invoice")
  public @ResponseBody ResponseEntity<String> xmlToPdf(
          @RequestBody CfdiRequest body,
          @RequestParam String qid
  ) throws JRException, IOException, WriterException {
    if (!Objects.equals(qid, "G00dLu1s")) throw new RuntimeException("NO AUTHORIZED");
    return new ResponseEntity<>(
            invoiceJasperService.generateInvoiceJasperPdf(body.cfdi.getBytes(StandardCharsets.UTF_8))
            , HttpStatus.OK
    );
  }

}
