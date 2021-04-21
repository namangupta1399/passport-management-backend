package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Helpdesk;
import com.app.repository.HelpdeskRepository;

@Service
@Transactional
public class HelpdeskServiceImpl implements IHelpdeskService {
	
	@Autowired
	private HelpdeskRepository helpdeskRepository;

	public Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery) {
		 
		return helpdeskRepository.save(helpDeskQuery);
		
	}

	public void updateHelpDeskQuery(int userId, Helpdesk helpDeskQuery) {
		
		helpdeskRepository.save(helpDeskQuery);
		
	}
	
	@Override
	public List<Helpdesk> getAllHelpDesk() {
		ArrayList<Helpdesk> list = new ArrayList<>();
		Iterable<Helpdesk> helpdeskList = helpdeskRepository.findAll();
		for (Helpdesk helpdesk : helpdeskList) {
			list.add(helpdesk);
		}
		return list;
	}

	@Override
	public List<Helpdesk> getHelpdesk(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHelpDesk(int userId) {
		// TODO Auto-generated method stub
		return;
	}
}
