
package library.soapsms;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


@WebService(name = "smsnn", targetNamespace = "http://sms/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Smsnn {


    /**
     * 
     * @param msg
     * @param gsm
     * @param password
     * @param bayikodu
     * @param header
     * @param company
     * @param encoding
     * @param startdate
     * @param stopdate
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "sms_gonder_nn")
    @WebResult(targetNamespace = "SMS")
    @RequestWrapper(localName = "sms_gonder_nn", targetNamespace = "http://sms/", className = "sms.SmsGonderNn")
    @ResponseWrapper(localName = "sms_gonder_nnResponse", targetNamespace = "http://sms/", className = "sms.SmsGonderNnResponse")
    @Action(input = "http://sms/smsnn/sms_gonder_nnRequest", output = "http://sms/smsnn/sms_gonder_nnResponse")
    public String smsGonderNn(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "company", targetNamespace = "")
        String company,
        @WebParam(name = "header", targetNamespace = "")
        String header,
        @WebParam(name = "msg", targetNamespace = "")
        List<String> msg,
        @WebParam(name = "gsm", targetNamespace = "")
        List<String> gsm,
        @WebParam(name = "encoding", targetNamespace = "")
        String encoding,
        @WebParam(name = "startdate", targetNamespace = "")
        String startdate,
        @WebParam(name = "stopdate", targetNamespace = "")
        String stopdate,
        @WebParam(name = "bayikodu", targetNamespace = "")
        String bayikodu);

    /**
     * 
     * @param msg
     * @param gsm
     * @param filter
     * @param password
     * @param bayikodu
     * @param header
     * @param encoding
     * @param startdate
     * @param stopdate
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "smsGonderNNV2", targetNamespace = "http://sms/", className = "sms.SmsGonderNNV2")
    @ResponseWrapper(localName = "smsGonderNNV2Response", targetNamespace = "http://sms/", className = "sms.SmsGonderNNV2Response")
    @Action(input = "http://sms/smsnn/smsGonderNNV2Request", output = "http://sms/smsnn/smsGonderNNV2Response")
    public String smsGonderNNV2(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "header", targetNamespace = "")
        String header,
        @WebParam(name = "msg", targetNamespace = "")
        List<String> msg,
        @WebParam(name = "gsm", targetNamespace = "")
        List<String> gsm,
        @WebParam(name = "encoding", targetNamespace = "")
        String encoding,
        @WebParam(name = "startdate", targetNamespace = "")
        String startdate,
        @WebParam(name = "stopdate", targetNamespace = "")
        String stopdate,
        @WebParam(name = "bayikodu", targetNamespace = "")
        String bayikodu,
        @WebParam(name = "filter", targetNamespace = "")
        int filter);

    /**
     * 
     * @param msg
     * @param gsm
     * @param password
     * @param bayikodu
     * @param header
     * @param company
     * @param encoding
     * @param startdate
     * @param stopdate
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "sms_gonder_1n")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sms_gonder_1n", targetNamespace = "http://sms/", className = "sms.SmsGonder1N")
    @ResponseWrapper(localName = "sms_gonder_1nResponse", targetNamespace = "http://sms/", className = "sms.SmsGonder1NResponse")
    @Action(input = "http://sms/smsnn/sms_gonder_1nRequest", output = "http://sms/smsnn/sms_gonder_1nResponse")
    public String smsGonder1N(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "company", targetNamespace = "")
        String company,
        @WebParam(name = "header", targetNamespace = "")
        String header,
        @WebParam(name = "msg", targetNamespace = "")
        String msg,
        @WebParam(name = "gsm", targetNamespace = "")
        List<String> gsm,
        @WebParam(name = "encoding", targetNamespace = "")
        String encoding,
        @WebParam(name = "startdate", targetNamespace = "")
        String startdate,
        @WebParam(name = "stopdate", targetNamespace = "")
        String stopdate,
        @WebParam(name = "bayikodu", targetNamespace = "")
        String bayikodu);

    /**
     * 
     * @param msg
     * @param gsm
     * @param filter
     * @param password
     * @param bayikodu
     * @param header
     * @param encoding
     * @param startdate
     * @param stopdate
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "smsGonder1NV2", targetNamespace = "http://sms/", className = "sms.SmsGonder1NV2")
    @ResponseWrapper(localName = "smsGonder1NV2Response", targetNamespace = "http://sms/", className = "sms.SmsGonder1NV2Response")
    @Action(input = "http://sms/smsnn/smsGonder1NV2Request", output = "http://sms/smsnn/smsGonder1NV2Response")
    public String smsGonder1NV2(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "header", targetNamespace = "")
        String header,
        @WebParam(name = "msg", targetNamespace = "")
        String msg,
        @WebParam(name = "gsm", targetNamespace = "")
        List<String> gsm,
        @WebParam(name = "encoding", targetNamespace = "")
        String encoding,
        @WebParam(name = "startdate", targetNamespace = "")
        String startdate,
        @WebParam(name = "stopdate", targetNamespace = "")
        String stopdate,
        @WebParam(name = "bayikodu", targetNamespace = "")
        String bayikodu,
        @WebParam(name = "filter", targetNamespace = "")
        int filter);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "kredi", targetNamespace = "http://sms/", className = "sms.Kredi")
    @ResponseWrapper(localName = "krediResponse", targetNamespace = "http://sms/", className = "sms.KrediResponse")
    @Action(input = "http://sms/smsnn/krediRequest", output = "http://sms/smsnn/krediResponse")
    public String kredi(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "paketkampanya", targetNamespace = "http://sms/", className = "sms.Paketkampanya")
    @ResponseWrapper(localName = "paketkampanyaResponse", targetNamespace = "http://sms/", className = "sms.PaketkampanyaResponse")
    @Action(input = "http://sms/smsnn/paketkampanyaRequest", output = "http://sms/smsnn/paketkampanyaResponse")
    public String paketkampanya(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param bulkid
     * @param version
     * @param username
     * @param status
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "rapor", targetNamespace = "http://sms/", className = "sms.Rapor")
    @ResponseWrapper(localName = "raporResponse", targetNamespace = "http://sms/", className = "sms.RaporResponse")
    @Action(input = "http://sms/smsnn/raporRequest", output = "http://sms/smsnn/raporResponse")
    public String rapor(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "bulkid", targetNamespace = "")
        String bulkid,
        @WebParam(name = "status", targetNamespace = "")
        int status,
        @WebParam(name = "version", targetNamespace = "")
        int version);

    /**
     * 
     * @param password
     * @param bulkid
     * @param detail
     * @param version
     * @param telno
     * @param username
     * @param status
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "rapor_v2")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "rapor_v2", targetNamespace = "http://sms/", className = "sms.RaporV2")
    @ResponseWrapper(localName = "rapor_v2Response", targetNamespace = "http://sms/", className = "sms.RaporV2Response")
    @Action(input = "http://sms/smsnn/rapor_v2Request", output = "http://sms/smsnn/rapor_v2Response")
    public String raporV2(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "bulkid", targetNamespace = "")
        String bulkid,
        @WebParam(name = "status", targetNamespace = "")
        int status,
        @WebParam(name = "version", targetNamespace = "")
        int version,
        @WebParam(name = "telno", targetNamespace = "")
        List<String> telno,
        @WebParam(name = "detail", targetNamespace = "")
        int detail);

    /**
     * 
     * @param password
     * @param bulkid
     * @param header
     * @param detail
     * @param startdate
     * @param type
     * @param stopdate
     * @param telno
     * @param username
     * @param status
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "raporV3", targetNamespace = "http://sms/", className = "sms.RaporV3")
    @ResponseWrapper(localName = "raporV3Response", targetNamespace = "http://sms/", className = "sms.RaporV3Response")
    @Action(input = "http://sms/smsnn/raporV3Request", output = "http://sms/smsnn/raporV3Response")
    public String raporV3(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "bulkid", targetNamespace = "")
        String bulkid,
        @WebParam(name = "telno", targetNamespace = "")
        List<String> telno,
        @WebParam(name = "header", targetNamespace = "")
        String header,
        @WebParam(name = "startdate", targetNamespace = "")
        String startdate,
        @WebParam(name = "stopdate", targetNamespace = "")
        String stopdate,
        @WebParam(name = "type", targetNamespace = "")
        int type,
        @WebParam(name = "status", targetNamespace = "")
        int status,
        @WebParam(name = "detail", targetNamespace = "")
        int detail);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "gondericiadlari", targetNamespace = "http://sms/", className = "sms.Gondericiadlari")
    @ResponseWrapper(localName = "gondericiadlariResponse", targetNamespace = "http://sms/", className = "sms.GondericiadlariResponse")
    @Action(input = "http://sms/smsnn/gondericiadlariRequest", output = "http://sms/smsnn/gondericiadlariResponse")
    public String gondericiadlari(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "gelensms", targetNamespace = "http://sms/", className = "sms.Gelensms")
    @ResponseWrapper(localName = "gelensmsResponse", targetNamespace = "http://sms/", className = "sms.GelensmsResponse")
    @Action(input = "http://sms/smsnn/gelensmsRequest", output = "http://sms/smsnn/gelensmsResponse")
    public String gelensms(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param password
     * @param startdate
     * @param type
     * @param stopdate
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "gelensmsV2", targetNamespace = "http://sms/", className = "sms.GelensmsV2")
    @ResponseWrapper(localName = "gelensmsV2Response", targetNamespace = "http://sms/", className = "sms.GelensmsV2Response")
    @Action(input = "http://sms/smsnn/gelensmsV2Request", output = "http://sms/smsnn/gelensmsV2Response")
    public String gelensmsV2(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "startdate", targetNamespace = "")
        String startdate,
        @WebParam(name = "stopdate", targetNamespace = "")
        String stopdate,
        @WebParam(name = "type", targetNamespace = "")
        int type);

}
