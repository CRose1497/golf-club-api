package com.qap.golf.golfclub.repository;

import com.qap.golf.golfclub.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContainingIgnoreCase(String name);
    List<Member> findByMembershipTypeIgnoreCase(String membershipType);
    List<Member> findByStartDate(LocalDate startDate);          
    List<Member> findByDuration(int duration);                  
    List<Member> findByPhone(String phone);                   
}
