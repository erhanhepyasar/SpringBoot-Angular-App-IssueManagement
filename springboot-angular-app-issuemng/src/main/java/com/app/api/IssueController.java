package com.app.api;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.IssueDto;
import com.app.dto.ProjectDto;
import com.app.service.impl.IssueServiceImpl;
import com.app.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")
public class IssueController {
	
	private final IssueServiceImpl issueServiceImpl;
	private final ModelMapper modelMapper;

	public IssueController(IssueServiceImpl issueServiceImpl, ModelMapper modelMapper) {
		this.issueServiceImpl = issueServiceImpl;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id){
		IssueDto issueDto =  issueServiceImpl.getById(id);
		return ResponseEntity.ok(issueDto);
	}
	
	@PostMapping
	@ApiOperation(value = "Create Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> create(@Valid @RequestBody IssueDto issueDto){
		return ResponseEntity.ok(issueServiceImpl.save(issueDto));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Update Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> update(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issueDto){
		return ResponseEntity.ok(issueServiceImpl.update(id, issueDto));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Operation", response = IssueDto.class)
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
		return ResponseEntity.ok(issueServiceImpl.delete(id));
	}
	
}
