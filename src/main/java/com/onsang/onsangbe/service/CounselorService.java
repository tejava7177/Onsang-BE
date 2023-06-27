package com.onsang.onsangbe.service;

import com.onsang.onsangbe.domain.Counselor;
import com.onsang.onsangbe.domain.CounselorDto;
import com.onsang.onsangbe.repository.CounselorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounselorService {
    private final CounselorRepository counselorRepository;

    public Long createCounselor(CounselorDto counselorDto) {
        Counselor counselor = CounselorDto.counselorMapper(counselorDto);
        Counselor newCounselor = counselorRepository.save(counselor);
        return newCounselor.getId();
    }
    public List<Counselor> getAllCounselors() {
        return counselorRepository.findAll();
    }

    public Counselor getCounselorById(Long id) {
        return counselorRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 상담사입니다."));
    }

    @Transactional
    public Long updateCounselor(Long id, CounselorDto counselorDto) {
        Counselor counselor = this.getCounselorById(id);
        counselor.update(counselorDto);
        return counselor.getId();
    }

    public void deleteCounselor(Long id) {
        counselorRepository.deleteById(id);
    }

}
