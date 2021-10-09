package mx.com.bmv.jasperpdfservices.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private String path;
    private int maxFileSize;
    private int maxFilesRetained;
    private String cert;
    private String xml;
    private String jasper;
    private InputStream input;
    private String pathOut;
    private String url;
    private String paymentJasper;

    public ConfigProperties() {
        Properties prop = new Properties();

        try {
            String propFileName = "application.properties";

            input = getClass().getClassLoader().getResourceAsStream(propFileName);
            prop.load(input);
            setPath(prop.getProperty("pojo.esb.logging.path"));
            setXml(prop.getProperty("pojo.esb.loggin.xml"));
            setJasper(prop.getProperty("pojo.esb.loggin.jasper.pdf"));
            setMaxFileSize(Integer.parseInt(prop.getProperty("pojo.esb.logging.maxFileSize")));
            setMaxFilesRetained(Integer.parseInt(  prop.getProperty("pojo.esb.logging.maxFilesRetained")));
            setCert(prop.getProperty("pojo.esb.loggin.cert"));
            setPathOut(prop.getProperty("pojo.esb.loggin.path.out"));
            setUrl(prop.getProperty("pojo.esb.loggin.url"));
            setPaymentJasper(prop.getProperty("pojo.esb.loggin.jasper.payment.pdf"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getPaymentJasper() {
        return paymentJasper;
    }

    public void setPaymentJasper(String paymentJasper) {
        this.paymentJasper = paymentJasper;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPathOut() {
        return pathOut;
    }

    public void setPathOut(String pathOut) {
        this.pathOut = pathOut;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getXml() {
        return xml;
    }

    public String getJasper() {
        return jasper;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public int getMaxFilesRetained() {
        return maxFilesRetained;
    }

    public void setMaxFilesRetained(int maxFilesRetained) {
        this.maxFilesRetained = maxFilesRetained;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public void setJasper(String jasper) {
        this.jasper = jasper;
    }
}
