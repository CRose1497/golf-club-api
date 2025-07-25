package com.qap.golf.golfclub.controller;

import com.qap.golf.golfclub.model.Member;
import com.qap.golf.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    // Get all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get member by ID
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberRepository.findById(id);
    }

    // Add a new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    // Search by name
    @GetMapping("/search/by-name")
    public List<Member> searchByName(@RequestParam String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    // Search by membership type
    @GetMapping("/search/by-type")
    public List<Member> searchByMembershipType(@RequestParam String type) {
        return memberRepository.findByMembershipTypeIgnoreCase(type);
    }

    // Search by phone
    @GetMapping("/search/by-phone")
    public List<Member> searchByPhone(@RequestParam String phone) {
        return memberRepository.findByPhone(phone);  // ✅ FIXED
    }

    // Search by membership start date
    @GetMapping("/search/by-start-date")
    public List<Member> searchByStartDate(@RequestParam String date) {
        return memberRepository.findByStartDate(date);
    }

    @GetMapping("/test")
public String testApi() {
    return "API is alive!";
}

}

