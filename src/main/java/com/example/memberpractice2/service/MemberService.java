package com.example.memberpractice2.service;

import com.example.memberpractice2.dto.MemberRequestDto;
import com.example.memberpractice2.dto.MemberResponseDto;
import com.example.memberpractice2.entity.Member;
import com.example.memberpractice2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto save(MemberRequestDto dto) {
        Member member = new Member(dto.getName(), dto.getAge());
        Member savedMember = memberRepository.save(member);
        
        return new MemberResponseDto(savedMember.getId(),savedMember.getName(),savedMember.getAge());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponseDto> dtoList = new ArrayList<>();

        for (Member member : members) {
            MemberResponseDto dto = new MemberResponseDto(member.getId(), member.getName(), member.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 멤버가 없습니다.")
        );
        return new MemberResponseDto(member.getId(),member.getName(),member.getAge());
    }

    @Transactional
    public MemberResponseDto update(Long memberId, MemberRequestDto dto) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 멤버가 없습니다.")
        );
        member.update(dto.getName(),dto.getAge());

        return new MemberResponseDto(member.getId(),member.getName(),member.getAge());
    }

    @Transactional
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
