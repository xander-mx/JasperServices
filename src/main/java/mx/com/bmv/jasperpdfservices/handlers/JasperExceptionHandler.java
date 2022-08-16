package mx.com.bmv.jasperpdfservices.handlers;

import com.google.zxing.WriterException;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class JasperExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(JasperExceptionHandler.class);

    @ExceptionHandler({JRException.class, IOException.class, WriterException.class})
    public ResponseEntity<Object> handleJRException(Exception ex) {
        logger.error("Error en la generación del reporte: {}" , ex.getMessage());
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("error", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<Object> handleUncaughtException(Exception ex) {
        logger.error("Error inesperado: {}" , ex.getMessage());
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("error", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(),headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
