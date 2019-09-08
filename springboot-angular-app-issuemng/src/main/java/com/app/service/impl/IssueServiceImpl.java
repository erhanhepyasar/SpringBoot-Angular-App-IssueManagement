package com.app.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.dto.IssueDto;
import com.app.entity.Issue;
import com.app.repository.IssueRepository;
import com.app.service.IssueService;
import com.app.util.TPage;

@Service
public class IssueServiceImpl implements IssueService {	
	
	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	
	// Constructor injection (adviced by Spring) 
	public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
		this.issueRepository = issueRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public IssueDto save(IssueDto issueDto) {
		if(issueDto.getDate() == null) {
			throw new IllegalArgumentException("Issue date can not be null");
		}
		
		Issue issue = modelMapper.map(issueDto, Issue.class);
		issue = issueRepository.save(issue);
		return modelMapper.map(issue, IssueDto.class);
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue = issueRepository.getOne(id);
		return modelMapper.map(issue, IssueDto.class);
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> page = issueRepository.findAll(pageable);
		TPage<IssueDto> tPage = new TPage<IssueDto>();
		IssueDto[] dtos = modelMapper.map(page.getContent(), IssueDto[].class);
		tPage.setStat(page, Arrays.asList(dtos));
		return tPage;
	}

	@Override
	public Boolean delete(Long issueId) {
		issueRepository.deleteById(issueId);
		return true;
	}

	@Override
	public IssueDto update(Long id, IssueDto issuDto) {
		// TODO Auto-generated method stub
		return null;
	}



}
