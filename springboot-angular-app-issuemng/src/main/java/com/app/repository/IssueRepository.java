package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
