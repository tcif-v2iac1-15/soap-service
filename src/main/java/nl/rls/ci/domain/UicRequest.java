package nl.rls.ci.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author berend.wilkens
 * 
 *         The SOAP Body contains the TAF/TAP-TSI message payload, the encoding
 *         definition and optional digital signature. As it can be seen in the
 *         wsdl, the Soap body contains the type uicm:UICMessage
 *         (xmlns:uicm=http://uic.cc.org/UICMessage ). The UICMessage contains
 *         four elements as described below.
 */
@ToString
@Entity
@NoArgsConstructor
@Getter
@Setter
public class UicRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * This element contains the actual TAF/TAPTSI message. If the message is
	 * compressed, encrypted or singed, then it should be base64 encoded.
	 */
	@Lob
	private String message;
	/**
	 * Message can be digitally signed for security purpose. For signing, you have
	 * to obtain a client certificate from RNE. If messages are signed, then the
	 * signature field should contain the digital signature. The client certificate
	 * (public key) and the alias name you obtain needs be shared with your CI
	 * partner. For more details on signing, refer to the section 5.7 on message
	 * signing.
	 */
	private String signature;
	/**
	 * The CI partner needs import that certificate into their SSL truststore
	 * including the senderAllias. This alias name should be filled in the
	 * senderAlias field.
	 */
	private String senderAlias = "trains24";
	/**
	 * The encoding field should contain the char encoding used for the message. CI
	 * supports the following char encodings: UTF-8
	 */
	private String encoding = "UTF-8";

}
