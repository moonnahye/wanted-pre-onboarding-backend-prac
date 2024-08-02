package com.nnhh.practice.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nnhh.practice.model.Notice;
import com.nnhh.practice.repository.NoticeRepository;

@RestController
public class testController {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	//id로 select 테스트
	@GetMapping("/test/notice/{id}")
	 public Notice detail(@PathVariable int id) {
		
		
		Notice notice = noticeRepository.findById(id)
				.orElseThrow(()->{
				  return new IllegalArgumentException("해당 사용자는 없습니다.");
				});
		return notice;
	}
	
	// insert 테스트
	@PostMapping("/test/insert")
	public String insert(Notice notice) {
		System.out.println("position :"+notice.getPosition());
		System.out.println("compensation :"+notice.getCompensation());
		System.out.println("content :"+notice.getContent());
		System.out.println("skill :"+notice.getSkill());
		
		noticeRepository.save(notice);
		
		return "공고 등록이 완료되었습니다.";
	}
	
	
	
	
}
