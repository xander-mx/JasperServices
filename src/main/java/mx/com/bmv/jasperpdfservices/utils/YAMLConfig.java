package mx.com.bmv.jasperpdfservices.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jasperservice")
public class YAMLConfig {

    private String certificate;
    private String path_out;
    private String url;
    private String payment;
    private String invoice;
    private String subReportInvoice;
    private String subReportPayment;

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPath_out() {
        return path_out;
    }

    public void setPath_out(String path_out) {
        this.path_out = path_out;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getSubReportInvoice() {
        return subReportInvoice;
    }

    public void setSubReportInvoice(String subReportInvoice) {
        this.subReportInvoice = subReportInvoice;
    }

    public String getSubReportPayment() {
        return subReportPayment;
    }

    public void setSubReportPayment(String subReportPayment) {
        this.subReportPayment = subReportPayment;
    }
}
