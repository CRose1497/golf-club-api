package com.qap.golf.golfclub.repository;

import com.qap.golf.golfclub.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContainingIgnoreCase(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
    List<Member> findByMembershipTypeIgnoreCase(String membershipType);
    List<Member> findByStartDate(String startDate);
}
