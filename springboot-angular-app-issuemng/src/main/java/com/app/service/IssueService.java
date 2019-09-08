package com.app.service;

import org.springframework.data.domain.Pageable;

import com.app.dto.IssueDto;
import com.app.util.TPage;

public interface IssueService {
	
	IssueDto save(IssueDto issue);	
	
	
	IssueDto getById(Long id);	
	
	TPage<IssueDto> getAllPageable(Pageable pageable);
	
	Boolean delete(Long issueId);
	
	IssueDto update(Long id, IssueDto issuDto);

}
