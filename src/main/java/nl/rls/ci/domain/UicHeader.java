package nl.rls.ci.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@NoArgsConstructor
@Getter
@Setter
public class UicHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * This header property should contain a string value, which uniquely identifies
	 * the message. To conform to TAF/TAP-TSI standard, the unique value should be
	 * 16 byte GUID expressed as 36- character string (32 hexadecimal numbers and 4
	 * minus characters). This value should be same as MessageIdentifier used in
	 * TAF-TSI message.
	 */
	private String messageIdentifier;
	/**
	 * This is a string value which should contain the Sender LI IP Address (should
	 * be public IP of LI). For example: 122.109.101.100
	 */
	private String messageLiHost = "";
	/**
	 * This is a Boolean value (true/false). If the message is compressed, then it
	 * should be set to true else it is set to false. For more details on
	 * compression, refer to the section 5.5 on message compression.
	 */
	private boolean compressed = false;
	/**
	 * This is a Boolean value (true/false). If the message is encrypted, then it
	 * should be set to true else it is set to false. For more details on
	 * encryption, refer to the section 5.6 on message encryption.
	 * 
	 */
	private boolean encrypted = false;
	/**
	 * This is a Boolean value (true/false). If the message is signed with a
	 * certificate, then it should be set to true else it is set to false. For more
	 * details on signing, refer to the section 5.7 on message signing.
	 */
	private boolean signed = false;
}
