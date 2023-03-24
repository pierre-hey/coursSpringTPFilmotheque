package fr.eni.movielibrary.mmi.converter;

import fr.eni.movielibrary.bll.ParticipantService;
import fr.eni.movielibrary.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToParticipantConverter implements Converter<String, Participant> {
	// Injection des services
	private final ParticipantService service;

	@Autowired
	public StringToParticipantConverter(ParticipantService service) {
		this.service = service;
	}

	@Override
	public Participant convert(String id) {
		Integer theId = Integer.parseInt(id);
		return service.findParticipantById(theId);
	}
}