
package nl.rls.ci.soap.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.trains24.ci.soapinterface package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Signed_QNAME = new QName("http://uic.cc.org/UICMessage/Header", "signed");
    private final static QName _UICMessage_QNAME = new QName("http://uic.cc.org/UICMessage", "UICMessage");
    private final static QName _Compressed_QNAME = new QName("http://uic.cc.org/UICMessage/Header", "compressed");
    private final static QName _UICMessageResponse_QNAME = new QName("http://uic.cc.org/UICMessage", "UICMessageResponse");
    private final static QName _MessageLiHost_QNAME = new QName("http://uic.cc.org/UICMessage/Header", "messageLiHost");
    private final static QName _Encrypted_QNAME = new QName("http://uic.cc.org/UICMessage/Header", "encrypted");
    private final static QName _MessageIdentifier_QNAME = new QName("http://uic.cc.org/UICMessage/Header", "messageIdentifier");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.trains24.ci.soapinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UICMessage }
     * 
     */
    public UICMessage createUICMessage() {
        return new UICMessage();
    }

    /**
     * Create an instance of {@link UICMessageResponse }
     * 
     */
    public UICMessageResponse createUICMessageResponse() {
        return new UICMessageResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uic.cc.org/UICMessage/Header", name = "signed")
    public JAXBElement<Boolean> createSigned(Boolean value) {
        return new JAXBElement<Boolean>(_Signed_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UICMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uic.cc.org/UICMessage", name = "UICMessage")
    public JAXBElement<UICMessage> createUICMessage(UICMessage value) {
        return new JAXBElement<UICMessage>(_UICMessage_QNAME, UICMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uic.cc.org/UICMessage/Header", name = "compressed")
    public JAXBElement<Boolean> createCompressed(Boolean value) {
        return new JAXBElement<Boolean>(_Compressed_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UICMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uic.cc.org/UICMessage", name = "UICMessageResponse")
    public JAXBElement<UICMessageResponse> createUICMessageResponse(UICMessageResponse value) {
        return new JAXBElement<UICMessageResponse>(_UICMessageResponse_QNAME, UICMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uic.cc.org/UICMessage/Header", name = "messageLiHost")
    public JAXBElement<String> createMessageLiHost(String value) {
        return new JAXBElement<String>(_MessageLiHost_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uic.cc.org/UICMessage/Header", name = "encrypted")
    public JAXBElement<Boolean> createEncrypted(Boolean value) {
        return new JAXBElement<Boolean>(_Encrypted_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uic.cc.org/UICMessage/Header", name = "messageIdentifier")
    public JAXBElement<String> createMessageIdentifier(String value) {
        return new JAXBElement<String>(_MessageIdentifier_QNAME, String.class, null, value);
    }

}
