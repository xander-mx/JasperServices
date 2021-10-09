package mx.com.bmv.jasperpdfservices.controllers;

import com.google.zxing.WriterException;
import mx.com.bmv.jasperpdfservices.services.InvoiceJasperService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.io.IOException;

@RestController
@RequestMapping("/JasperService")
public class JasperCtrl {

    private final InvoiceJasperService invoiceJasperService;

    @Inject
    public JasperCtrl(InvoiceJasperService invoiceJasperService){
        this.invoiceJasperService = invoiceJasperService;
    }

    @PostMapping(path="/invoice")
    public @ResponseBody ResponseEntity<String> invoiceConverter(@RequestBody byte[] xmlToTransform) throws JRException, IOException, WriterException {
        return new ResponseEntity<>(invoiceJasperService.generateInvoiceJasperPdf(xmlToTransform), HttpStatus.OK);
    }
}
