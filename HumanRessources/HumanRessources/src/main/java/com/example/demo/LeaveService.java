package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepository leaveRepository;
	

	public Leave addLeave(Leave leave) {
		return leaveRepository.save(leave);
	}
	public Leave updateLeave(int id, Leave newLeave) {
		if (leaveRepository.findById(id).isPresent()) {
			Leave existingLeave = leaveRepository.findById(id).get();
			existingLeave.setStartDate(newLeave.getStartDate());
			existingLeave.setEndDate(newLeave.getEndDate());
			

			return leaveRepository.save(existingLeave);
		} else
			return null;
	}
	public String deleteLeave(int id) {
		if (leaveRepository.findById(id).isPresent()) {
			leaveRepository.deleteById(id);
			return "leave deleted";
		} else
			return "leave not deleted";
	}
	

}
