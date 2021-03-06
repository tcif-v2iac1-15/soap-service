
package nl.rls.ci.soap.dto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "UICReceiveMessage", targetNamespace = "http://uic.cc.org/UICMessage")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UICReceiveMessage {


    /**
     * 
     * 				This operation is used to send the message to the Remote CI.
     * 			
     * 
     * @param encrypted
     * @param messageIdentifier
     * @param signed
     * @param compressed
     * @param messageLiHost
     * @param parameters
     * @return
     *     returns nl.trains24.ci.soapinterface.UICMessageResponse
     */
    @WebMethod(operationName = "UICMessage")
    @WebResult(name = "UICMessageResponse", targetNamespace = "http://uic.cc.org/UICMessage", partName = "parameters")
    public UICMessageResponse uicMessage(
        @WebParam(name = "UICMessage", targetNamespace = "http://uic.cc.org/UICMessage", partName = "parameters")
        UICMessage parameters,
        @WebParam(name = "messageIdentifier", targetNamespace = "http://uic.cc.org/UICMessage/Header", header = true, partName = "messageIdentifier")
        String messageIdentifier,
        @WebParam(name = "messageLiHost", targetNamespace = "http://uic.cc.org/UICMessage/Header", header = true, partName = "messageLiHost")
        String messageLiHost,
        @WebParam(name = "compressed", targetNamespace = "http://uic.cc.org/UICMessage/Header", header = true, partName = "compressed")
        boolean compressed,
        @WebParam(name = "encrypted", targetNamespace = "http://uic.cc.org/UICMessage/Header", header = true, partName = "encrypted")
        boolean encrypted,
        @WebParam(name = "signed", targetNamespace = "http://uic.cc.org/UICMessage/Header", header = true, partName = "signed")
        boolean signed);

}
