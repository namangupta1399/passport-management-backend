package com.app.service;

import java.util.List;

import com.app.beans.Helpdesk;

public interface IHelpdeskService {
	
	public Helpdesk getHelpDesk(int helpdeskId);
	
	public List<Helpdesk> getAllHelpDesk();
	
	Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery);
	
	void updateHelpDeskQuery(Helpdesk helpDeskQuery);
	
	List<Helpdesk> getHelpdesk(int userId);
}
