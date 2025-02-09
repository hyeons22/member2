package com.example.memberpractice2.repository;

import com.example.memberpractice2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
