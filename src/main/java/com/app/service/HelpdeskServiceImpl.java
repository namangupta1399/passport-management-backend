package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Helpdesk;
import com.app.repository.HelpdeskRepository;

@Service
@Transactional
public class HelpdeskServiceImpl implements IHelpdeskService {
	
	Logger logger = LoggerFactory.getLogger(HelpdeskServiceImpl.class);
	
	@Autowired
	private HelpdeskRepository helpdeskRepository;

	public Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery) {
		
		logger.info("addHelpDeskQuery() called");
		 
		return helpdeskRepository.save(helpDeskQuery);
		
	}

	public void updateHelpDeskQuery(int userId, Helpdesk helpDeskQuery) {
		
		logger.info("updateHelpDeskQuery() called");
		
		helpdeskRepository.save(helpDeskQuery);
		
	}
	
	@Override
	public List<Helpdesk> getAllHelpDesk() {
		
		logger.info("getAllHelpDesk() called");
		
		ArrayList<Helpdesk> list = new ArrayList<>();
		Iterable<Helpdesk> helpdeskList = helpdeskRepository.findAll();
		for (Helpdesk helpdesk : helpdeskList) {
			list.add(helpdesk);
		}
		return list;
	}

	@Override
	public List<Helpdesk> getHelpdesk(int userId) {
		
		logger.info("getHelpdesk() called");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHelpDesk(int userId) {
		
		logger.info("deleteHelpDesk() called");
		// TODO Auto-generated method stub
		return;
	}
}
