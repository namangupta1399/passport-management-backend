package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Helpdesk;
import com.app.beans.User;
import com.app.exception.HelpdeskQueryListEmptyException;
import com.app.exception.HelpdeskQueryNotFoundException;
import com.app.exception.UserNotFoundException;
import com.app.repository.HelpdeskRepository;

@Service
@Transactional
public class HelpdeskServiceImpl implements IHelpdeskService {
	
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
		 User user = userService.viewUser(helpDeskQuery.getUser().getId());
		 helpDeskQuery.setUser(user);
		return helpdeskRepository.save(helpDeskQuery);
		
	}

	public void updateHelpDeskQuery(Helpdesk helpDeskQuery) {
		User user = userService.viewUser(helpDeskQuery.getUser().getId());
		if(user != null) {			
			Helpdesk query = getHelpDesk(helpDeskQuery.getHelpdeskId());
			helpdeskRepository.save(helpDeskQuery);
		}
		
	}
	
	@Override
	public List<Helpdesk> getAllHelpDesk() {
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
		// TODO Auto-generated method stub
//		helpdeskRepository.deleteByHelpdeskId(queryId);
		helpdeskRepository.deleteById(queryId);
		return;
	}
}
