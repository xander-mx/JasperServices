package mx.com.bmv.jasperpdfservices.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.zxing.WriterException;
import mx.com.bmv.jasperpdfservices.services.InvoiceJasperService;
import mx.com.bmv.jasperpdfservices.services.security.CredentialsServ;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/JasperService")
public class JasperCtrl {

    private final InvoiceJasperService invoiceJasperService;
    private final CredentialsServ credentialsServ;

    @Inject
    public JasperCtrl(InvoiceJasperService invoiceJasperService, CredentialsServ credentialsServ){
        this.invoiceJasperService = invoiceJasperService;
        this.credentialsServ = credentialsServ;
    }

    @PostMapping(path="/invoice")
    public @ResponseBody ResponseEntity<String> invoiceConverter(@RequestBody byte[] xmlToTransform) throws JRException, IOException, WriterException {
        return new ResponseEntity<>(invoiceJasperService.generateInvoiceJasperPdf(xmlToTransform), HttpStatus.OK);
    }

    @GetMapping("/refreshToken")
    public @ResponseBody void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String refresh_token = authorizationHeader.substring("Bearer ".length());
            Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
            String username = decodedJWT.getSubject();
            User user = (User) credentialsServ.loadUserByUsername(username);
            String access_token = JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                    .withIssuer(request.getRequestURL().toString())
                    .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .sign(algorithm);
        }else {
            throw new RuntimeException("Refresh token failed");
        }
    }
}
