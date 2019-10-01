
package library.soapsms;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


@WebServiceClient(name = "SMS", targetNamespace = "http://sms/", wsdlLocation = "http://soap.netgsm.com.tr:8080/Sms_webservis/SMS?wsdl")
public class SMS
    extends Service
{

    private final static URL SMS_WSDL_LOCATION;
    private final static WebServiceException SMS_EXCEPTION;
    private final static QName SMS_QNAME = new QName("http://sms/", "SMS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://soap.netgsm.com.tr:8080/Sms_webservis/SMS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SMS_WSDL_LOCATION = url;
        SMS_EXCEPTION = e;
    }

    public SMS() {
        super(__getWsdlLocation(), SMS_QNAME);
    }

    public SMS(WebServiceFeature... features) {
        super(__getWsdlLocation(), SMS_QNAME, features);
    }

    public SMS(URL wsdlLocation) {
        super(wsdlLocation, SMS_QNAME);
    }

    public SMS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SMS_QNAME, features);
    }

    public SMS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SMS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Smsnn
     */
    @WebEndpoint(name = "smsnnPort")
    public Smsnn getSmsnnPort() {
        return super.getPort(new QName("http://sms/", "smsnnPort"), Smsnn.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Smsnn
     */
    @WebEndpoint(name = "smsnnPort")
    public Smsnn getSmsnnPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://sms/", "smsnnPort"), Smsnn.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SMS_EXCEPTION!= null) {
            throw SMS_EXCEPTION;
        }
        return SMS_WSDL_LOCATION;
    }

}
