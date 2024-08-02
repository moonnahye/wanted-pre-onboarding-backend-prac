package com.nnhh.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnhh.practice.model.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	List<Notice> findByContentContainingOrPositionContainingOrSkillContaining(String content, String position,
			String skill);

	List<Notice> findByCompany_ComId(int comId);
}
