package com.nnhh.practice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.nnhh.practice.model.Notice;
import com.nnhh.practice.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class noticeController {

	private final NoticeService noticeService;

	// 메인화면(공고리스트 보여주기)
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("notices", noticeService.getNoticeList());
		return "index";
	}

	// 공고 등록 페이지
	@GetMapping("/notice/saveForm")
	public String saveForm() {
		// /WEB-INF/views/index.jsp
		return "noticeSaveForm";
	}

	// 상세보기 페이지
	@GetMapping("/notice/{id}")
	public String showDetail(@RequestParam int comId, @PathVariable int id, Model model) {
		model.addAttribute("notice", noticeService.getNoticeDetail(id));
		model.addAttribute("noticebycom", noticeService.getNoticeByComId(comId));

		return "noticeDetail";
	}

	// 공고수정 페이지
	@GetMapping("/notice/{id}/updateForm")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("notice", noticeService.getNoticeDetail(id));
		return "noticeUpdateForm";
	}

	// 검색결과 페이지
	@GetMapping("/search")
	public String searchNotices(@RequestParam String keyword, Model model) {

		List<Notice> notices = noticeService.searchNotices(keyword);
		if (notices.isEmpty()) {
			model.addAttribute("keyword", keyword);
			return "searchResult";
		} else {
			model.addAttribute("notices", notices);
			return "index";
		}
	}

}
