package com.example.memberpractice2.controller;

import com.example.memberpractice2.dto.MemberRequestDto;
import com.example.memberpractice2.dto.MemberResponseDto;
import com.example.memberpractice2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberResponseDto> save(@RequestBody MemberRequestDto dto){
        return ResponseEntity.ok(memberService.save(dto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberResponseDto> update(@PathVariable Long memberId, @RequestBody MemberRequestDto dto){
        return ResponseEntity.ok(memberService.update(memberId,dto));
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteById(@PathVariable Long memberId){
        memberService.deleteById(memberId);
    }

}
