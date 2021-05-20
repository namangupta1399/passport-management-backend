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
	
	/**
	 * The method is used to get helpdesk query using id
	 * @param helpdesk id
	 * @return Helpdesk
	 * @throws HelpdeskQueryNotFoundException
	 */
	public Helpdesk getHelpDesk(int helpdeskId) {
		Optional<Helpdesk> query = helpdeskRepository.findById(helpdeskId);
		if(query.isPresent()) {
			return query.get();
		}
		throw new HelpdeskQueryNotFoundException("Query not found!");
	}

	/**
	 * The method is used to create helpdesk query
	 * @param Helpdesk query to be inserted
	 * @return the new helpdesk query object
	 */
	public Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery) {
		logger.info("addHelpDeskQuery() called");

		 User user = userService.getUser(helpDeskQuery.getUser().getId());
		 helpDeskQuery.setUser(user);

		 queryValidation.validateUserQuery(helpDeskQuery);
		return helpdeskRepository.save(helpDeskQuery);
		
	}

	/**
	 * The method is used to get update helpdesk query - used in admin controller to update solution and query status
	 * @param Helpdesk query object - updated
	 * @return updated Helpdesk object
	 * @throws HelpdeskQueryNotFoundException
	 */
	public Helpdesk updateHelpDeskQuery(Helpdesk helpDeskQuery) {
		logger.info("updateHelpDeskQuery() called");

		Helpdesk query = getHelpDesk(helpDeskQuery.getHelpdeskId());
		if(query != null) {
			queryValidation.validateAdminResponse(helpDeskQuery);
			return helpdeskRepository.save(helpDeskQuery);
		}
		return query;
	}
	
	/**
	 * The method is used to get all helpdesk queries - used in admin controller to get all user queries
	 * @param nothing
	 * @return List of all helpdesk queries
	 * @throws HelpdeskQueryListEmptyException
	 */
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

	/**
	 * The method is used to get all helpdesk queries of a specific user
	 * @param user id to get helpdesk queries of a specific user
	 * @return List of helpdesk queries
	 * @throws HelpdeskQueryListEmptyException
	 */
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
