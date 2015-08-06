package com.tigers.listeners;


import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FacesListener implements PhaseListener {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = LoggerFactory.getLogger(FacesListener.class.getName());
	 

	@Override
	public void afterPhase(PhaseEvent event) {
		LOGGER.info("Después:{0}"+event.getPhaseId(),event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		LOGGER.info("Antés:{0}"+event.getPhaseId(), event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	
}
