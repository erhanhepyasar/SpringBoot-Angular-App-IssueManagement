package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}
