package com.nnhh.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnhh.practice.dto.NoticeReqDto;
import com.nnhh.practice.model.Company;
import com.nnhh.practice.model.Notice;
import com.nnhh.practice.repository.CompanyRepository;
import com.nnhh.practice.repository.NoticeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;
	private final CompanyRepository companyRepository;

	// 저장하기
	@Transactional
	public void saveNoticeForm(NoticeReqDto dto) {

		Company company1 = new Company();
		company1.setComId(1);
		company1.setName("NH Company");
		company1.setNation("Korea");
		company1.setArea("Seoul");

		Company company2 = new Company();
		company2.setComId(2);
		company2.setName("SSS ");
		company2.setNation("Korea");
		company2.setArea("Busan");

		companyRepository.save(company1);
		companyRepository.save(company2);

		Company selectedCompany = companyRepository.findById(dto.getComId())
				.orElseThrow(() -> new IllegalArgumentException("ID가 없습니다."));

		Notice notice = Notice.builder()
				.position(dto.getPosition())
				.compensation(dto.getCompensation())
				.content(dto.getContent())
				.skill(dto.getSkill())
				.company(selectedCompany).build();
		noticeRepository.save(notice);
	}

	// 목록가져오기
	@Transactional(readOnly = true)
	public List<Notice> getNoticeList() {
		return noticeRepository.findAll();
	}

	// 상세한 공고 보기
	@Transactional(readOnly = true)
	public Notice getNoticeDetail(int id) {
		return noticeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("공고 찾기실패: 아이디를 찾을 수 없습니다."));
	}

	@Transactional(readOnly = true)
	public List<Notice> getNoticeByComId(int id) {
		return noticeRepository.findByCompany_ComId(id);
	}

	// 삭제하기
	@Transactional
	public void deleteNotice(int id) {
		if (noticeRepository.existsById(id)) {
			noticeRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("공고 찾기실패: 아이디를 찾을 수 없습니다.");
		}
	}

	// 수정하기
	@Transactional
	public void updateNotice(int id, Notice requestNotice) {

		Notice notice = noticeRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("공고 찾기실패: 아이디를 찾을 수 없습니다.");
		});

		notice.setPosition(requestNotice.getPosition());
		notice.setCompensation(requestNotice.getCompensation());
		notice.setContent(requestNotice.getContent());
		notice.setSkill(requestNotice.getSkill());
	}

	// 검색하기
	@Transactional(readOnly = true)
	public List<Notice> searchNotices(String keyword) {
		if (keyword == null || keyword.trim().isEmpty()) {
			throw new IllegalArgumentException("검색어를 입력하세요.");
		}
		return noticeRepository.findByContentContainingOrPositionContainingOrSkillContaining(keyword, keyword, keyword);
	}

}
