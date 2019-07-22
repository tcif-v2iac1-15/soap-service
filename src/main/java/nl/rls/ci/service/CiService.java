package nl.rls.ci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nl.rls.ci.domain.CiMessage;
import nl.rls.ci.domain.UicResponse;
import nl.rls.ci.repository.CiRepository;
import nl.rls.ci.soap.dto.LIReceiveMessageService;
import nl.rls.ci.soap.dto.UICMessage;
import nl.rls.ci.soap.dto.UICMessageResponse;
import nl.rls.ci.soap.dto.UICReceiveMessage;
import nl.rls.ci.soap.dto.mapper.CiDtoMapper;

@Component
public class CiService {
	private static final Logger log = LoggerFactory.getLogger(CiService.class);
	@Autowired
	private CiRepository ciRepository;

	@Transactional
	public boolean sendMessage(CiMessage ciMessage) {
		log.info("sendMessage (ciMessage): " + ciMessage);
		UICMessage uicMessage = CiDtoMapper.map(ciMessage.getUicRequest());
		log.info("sendMessage (uicMessage): " + uicMessage);
		LIReceiveMessageService liReceiveMessageService = new LIReceiveMessageService();
		UICReceiveMessage uicReceiveMessage = liReceiveMessageService.getUICReceiveMessagePort();
		UICMessageResponse uicMessageResponse = uicReceiveMessage.uicMessage(uicMessage,
				ciMessage.getUicHeader().getMessageIdentifier(), ciMessage.getUicHeader().getMessageLiHost(),
				ciMessage.getUicHeader().isCompressed(), ciMessage.getUicHeader().isEncrypted(),
				ciMessage.getUicHeader().isSigned());
		log.info("sendMessage (uicMessageResponse): " + uicMessageResponse.getReturn());
		UicResponse uicResponse = CiDtoMapper.map(uicMessageResponse);
		ciMessage.setUicResponse(uicResponse);
		log.info("sendMessage (uicResponse): " + uicResponse);
		ciRepository.save(ciMessage);
		return true;

	}

}
