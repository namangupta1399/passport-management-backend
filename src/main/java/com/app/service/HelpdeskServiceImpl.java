package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Helpdesk;
import com.app.beans.User;
import com.app.exception.HelpdeskQueryListEmptyException;
import com.app.exception.HelpdeskQueryNotFoundException;
import com.app.repository.HelpdeskRepository;

@Service
@Transactional
public class HelpdeskServiceImpl implements IHelpdeskService {
	
	Logger logger = LoggerFactory.getLogger(HelpdeskServiceImpl.class);
	
	@Autowired
	private HelpdeskRepository helpdeskRepository;
	
	@Autowired
	private UserServiceImpl userService;
	
	public Helpdesk getHelpDesk(int helpdeskId) {
		Optional<Helpdesk> query = helpdeskRepository.findById(helpdeskId);
		if(query.isPresent()) {
			return query.get();
		}
		throw new HelpdeskQueryNotFoundException("Query not found!");
	}

	public Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery) {
		logger.info("addHelpDeskQuery() called");

		 User user = userService.viewUser(helpDeskQuery.getUser().getId());
		 helpDeskQuery.setUser(user);

		return helpdeskRepository.save(helpDeskQuery);
		
	}

	public void updateHelpDeskQuery(Helpdesk helpDeskQuery) {
		logger.info("updateHelpDeskQuery() called");
		
		User user = userService.viewUser(helpDeskQuery.getUser().getId());
		if(user != null) {			
			Helpdesk query = getHelpDesk(helpDeskQuery.getHelpdeskId());
			helpdeskRepository.save(helpDeskQuery);
		}
	}
	
	@Override
	public List<Helpdesk> getAllHelpDesk() {
		
		logger.info("getAllHelpDesk() called");
		
		ArrayList<Helpdesk> list = new ArrayList<>();
		List<Helpdesk> helpdeskList = helpdeskRepository.findAll();
		if(helpdeskList.size() <= 0) {
			throw new HelpdeskQueryListEmptyException("No queries found!");
		}
		for (Helpdesk helpdesk : helpdeskList) {
			list.add(helpdesk);
		}
		return list;
	}

	@Override
	public List<Helpdesk> getHelpdesk(int userId) {
		
		logger.info("getHelpdesk() called");
		// TODO Auto-generated method stub
		User user = userService.viewUser(userId);
		if(user != null) {
			List<Helpdesk> queries = helpdeskRepository.findAllByUserId(userId);
			if(queries.size() <= 0) {
				throw new HelpdeskQueryListEmptyException("No queries found!");
			}
			return queries;
		}
		return null;
	}

	@Override
	public void deleteHelpDesk(int queryId) {
		logger.info("deleteHelpDesk() called");

//		helpdeskRepository.deleteByHelpdeskId(queryId);
		helpdeskRepository.deleteById(queryId);
		return;
	}
}
