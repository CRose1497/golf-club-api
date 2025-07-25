package com.qap.golf.golfclub.service;

import com.qap.golf.golfclub.model.Member;
import com.qap.golf.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Get all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get a member by ID
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    // Add a new member
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    // Update an existing member
    public Member updateMember(Long id, Member updatedMember) {
        Optional<Member> existingMemberOpt = memberRepository.findById(id);

        if (existingMemberOpt.isPresent()) {
            Member existing = existingMemberOpt.get();
            existing.setName(updatedMember.getName());
            existing.setEmail(updatedMember.getEmail());
            return memberRepository.save(existing);
        } else {
            return null; // or throw an exception if preferred
        }
    }

    // Delete a member
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
