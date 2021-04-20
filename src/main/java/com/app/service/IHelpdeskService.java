package com.app.service;

import java.util.List;

import com.app.beans.Helpdesk;

public interface IHelpdeskService {
	public List<Helpdesk> getAllHelpDesk();
	
	Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery);
	
	void updateHelpDeskQuery(int applicantId, Helpdesk helpDeskQuery);
	
	List<Helpdesk> getHelpdesk(int userId);
	
	void deleteHelpDesk(int userId);
}