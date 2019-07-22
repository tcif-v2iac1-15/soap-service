package nl.rls.ci.server;

import javax.jws.WebService;

import nl.rls.ci.soap.dto.UICMessage;
import nl.rls.ci.soap.dto.UICMessageResponse;
import nl.rls.ci.soap.dto.UICReceiveMessage;

/**
 * @author berend.wilkens
 *
 */
@WebService(endpointInterface = "nl.trains24.ci.soapinterface.UICReceiveMessage")
public class UICReceiveMessageImpl implements UICReceiveMessage {

	/* (non-Javadoc)
	 * @see nl.trains24.ci.soapinterface.UICReceiveMessage#uicMessage(nl.trains24.ci.soapinterface.UICMessage, java.lang.String, java.lang.String, boolean, boolean, boolean)
	 */
	@Override
	public UICMessageResponse uicMessage(UICMessage parameters, String messageIdentifier, String messageLiHost,
			boolean compressed, boolean encrypted, boolean signed) {
		parameters.getMessage();
		// TODO Auto-generated method stub
		return null;
	}

}
