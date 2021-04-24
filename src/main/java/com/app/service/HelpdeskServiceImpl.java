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
import com.app.validation.HelpdeskValidation;

@Service
@Transactional
public class HelpdeskServiceImpl implements IHelpdeskService {
	
	Logger logger = LoggerFactory.getLogger(HelpdeskServiceImpl.class);
	
	@Autowired
	private HelpdeskRepository helpdeskRepository;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private HelpdeskValidation queryValidation;
	
	public Helpdesk getHelpDesk(int helpdeskId) {
		Optional<Helpdesk> query = helpdeskRepository.findById(helpdeskId);
		if(query.isPresent()) {
			return query.get();
		}
		throw new HelpdeskQueryNotFoundException("Query not found!");
	}

	public Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery) {
		logger.info("addHelpDeskQuery() called");

		 User user = userService.getUser(helpDeskQuery.getUser().getId());
		 helpDeskQuery.setUser(user);

		 queryValidation.validateUserQuery(helpDeskQuery);
		return helpdeskRepository.save(helpDeskQuery);
		
	}

	public Helpdesk updateHelpDeskQuery(Helpdesk helpDeskQuery) {
		logger.info("updateHelpDeskQuery() called");

		Helpdesk query = getHelpDesk(helpDeskQuery.getHelpdeskId());
		if(query != null) {
			queryValidation.validateAdminResponse(helpDeskQuery);
			return helpdeskRepository.save(helpDeskQuery);
		}
		return query;
	}
	
	@Override
	public List<Helpdesk> getAllHelpDesk() {
		
		logger.info("getAllHelpDesk() called");
		
		ArrayList<Helpdesk> list = new ArrayList<>();
		List<Helpdesk> helpdeskList = helpdeskRepository.findAll();
		if(helpdeskList.isEmpty()) {
			throw new HelpdeskQueryListEmptyException("No queries found!");
		}
		for (Helpdesk helpdesk : helpdeskList) {
			list.add(helpdesk);
		}
		return list;
	}

	@Override
	public List<Helpdesk> getHelpdeskByUser(int userId) {
		
		logger.info("getHelpdesk() called");

		User user = userService.getUser(userId);
		if(user != null) {
			List<Helpdesk> queries = helpdeskRepository.findAllByUserId(userId);
			if(queries.isEmpty()) {
				throw new HelpdeskQueryListEmptyException("No queries found!");
			}
			return queries;
		}
		return new ArrayList<>();
	}
}
