package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Address;
import com.app.beans.ApplicationStatus;
import com.app.beans.Document;
import com.app.beans.PassportApplication;
import com.app.repository.AddressRepository;
import com.app.repository.DocumentRepository;
import com.app.repository.PassportApplicationRepository;

@Service
@Transactional
public class PassportApplicationServiceImpl implements IPassportApplicationService {
	
	@Autowired
	private PassportApplicationRepository applicationRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private DocumentRepository docsRepository;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private PassportApplicationServiceImpl appService;
	
	
	public PassportApplication addPassportApplication(PassportApplication application) {
//		Storing address in db
		Address address = application.getAddress();
		application.setAddress(addressRepository.save(address));
		
//		Storing docs in db
		List<Document> docs = application.getDocuments();
		List<Document> insertedDocs = new ArrayList<>();
		docs.forEach(doc -> insertedDocs.add(docsRepository.save(doc)));
		application.setDocuments(insertedDocs);
		
//		Fetching user from db
		application.setUser(userService.viewUser(application.getUser().getId()));
		
		return applicationRepository.save(application);
		
	}

	 
	public void deletePassportApplication(int applicationNo) {
		
		applicationRepository.deleteById(applicationNo);
	}

	
	public void updatePassportApplication(int userId, PassportApplication application) {
		applicationRepository.save(application);
		
	}
	
	 
	public PassportApplication viewPassportApplication(int appNo) {
		
		return applicationRepository.findById(appNo).get();
	}
	
	@Override
	public List<PassportApplication> getAllPassportApplications() {
		ArrayList<PassportApplication> list = new ArrayList<>();
		Collection<PassportApplication> passportApplicationList = applicationRepository.findAll();
		for (PassportApplication passportApplication : passportApplicationList) {
			list.add(passportApplication);
		}
		return list;
	}

	@Override
	public PassportApplication updateApplicationStatus(boolean status, int appNo) {
		PassportApplication app = appService.viewPassportApplication(appNo);
		app.setApplicationStatus(status);
		return applicationRepository.save(app);
	}

	@Override
	public ApplicationStatus getApplicationStatus(int appNo) {
		ApplicationStatus status = new ApplicationStatus(appNo, appService.viewPassportApplication(appNo).getApplicationStatus());
		return status;
	}
}
