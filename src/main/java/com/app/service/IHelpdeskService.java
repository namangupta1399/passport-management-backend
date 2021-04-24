package com.app.service;

import java.util.List;

import com.app.beans.Helpdesk;

public interface IHelpdeskService {
	
	Helpdesk getHelpDesk(int helpdeskId);
	
	List<Helpdesk> getAllHelpDesk();
	
	Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery);
	
	Helpdesk updateHelpDeskQuery(Helpdesk helpDeskQuery);
	
	List<Helpdesk> getHelpdeskByUser(int userId);
}
