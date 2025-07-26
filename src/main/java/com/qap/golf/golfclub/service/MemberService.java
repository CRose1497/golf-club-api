package com.qap.golf.golfclub.service;

import com.qap.golf.golfclub.model.Member;
import com.qap.golf.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        return memberRepository.findById(id).map(existing -> {
            existing.setName(updatedMember.getName());
            existing.setAddress(updatedMember.getAddress());
            existing.setEmail(updatedMember.getEmail());
            existing.setPhoneNumber(updatedMember.getPhoneNumber());
            existing.setMembershipStartDate(updatedMember.getMembershipStartDate());
            existing.setMembershipDuration(updatedMember.getMembershipDuration());
            return memberRepository.save(existing);
        }).orElse(null);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    // Search functionality
    public List<Member> findByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Member> findByStartDate(LocalDate date) {
        return memberRepository.findByStartDate(date);
    }

    public List<Member> findByDuration(int duration) {
        return memberRepository.findByDuration(duration);
    }

    public List<Member> findByPhone(String phone) {
        return memberRepository.findByPhone(phone);
    }

}
