package nl.hu.iac.soap.impl;

import java.math.BigInteger;

import javax.jws.WebService;

import nl.hu.iac.soap.wsinterface.Fault;
import nl.hu.iac.soap.wsinterface.PowerFault;
import nl.hu.iac.soap.wsinterface.PowerRequest;
import nl.hu.iac.soap.wsinterface.PowerResponse;
import nl.hu.iac.soap.wsinterface.PowerServiceInterface;

@WebService(endpointInterface = "nl.hu.iac.soap.wsinterface.PowerServiceInterface")
public class PowerServiceImpl implements PowerServiceInterface {

	@Override
	public PowerResponse calculatePower(PowerRequest request) throws Fault {
		PowerResponse response = new PowerResponse();
		try {
			Double result = Math.pow(request.getX().doubleValue(), request
					.getPower().doubleValue());
			// x en power zijn altijd gehele getallen dan is er geen afronding
			response.setResult(BigInteger.valueOf(result.longValue()));
		} catch (RuntimeException e) {
			PowerFault x = new PowerFault();
			x.setErrorCode((short) 1);
			x.setMessage("Kan de macht van " + request.getX()
					+ " tot de macht " + request.getPower().toString()
					+ " niet berekenen.");
			Fault fault = new Fault(
					"Er ging iets mis met het berekenen van de macht", x);
			throw fault;
		}
		return response;
	}

}
