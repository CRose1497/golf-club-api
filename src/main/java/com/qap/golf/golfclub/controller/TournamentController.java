package com.qap.golf.golfclub.controller;

import com.qap.golf.golfclub.model.Member;
import com.qap.golf.golfclub.model.Tournament;
import com.qap.golf.golfclub.repository.MemberRepository;
import com.qap.golf.golfclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepo;

    @Autowired
    private MemberRepository memberRepo;

    // Create a new tournament
    @PostMapping
    public Tournament create(@RequestBody Tournament t) {
        return tournamentRepo.save(t);
    }

    // Get all tournaments
    @GetMapping
    public List<Tournament> getAll() {
        return tournamentRepo.findAll();
    }

    // Search tournaments by location or start date
    @GetMapping("/search")
    public List<Tournament> search(
            @RequestParam(required = false) String location,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        if (location != null) return tournamentRepo.findByLocationContainingIgnoreCase(location);
        if (date != null) return tournamentRepo.findByStartDate(date);
        return tournamentRepo.findAll();
    }

    // Add a member to a tournament
    @PostMapping("/{id}/add-member/{memberId}")
    public Tournament addMember(@PathVariable Long id, @PathVariable Long memberId) {
        Tournament t = tournamentRepo.findById(id).orElseThrow();
        Member m = memberRepo.findById(memberId).orElseThrow();
        t.getMembers().add(m);
        return tournamentRepo.save(t);
    }

    // Get all members in a tournament
    @GetMapping("/{id}/members")
    public List<Member> getMembersInTournament(@PathVariable Long id) {
        Tournament t = tournamentRepo.findById(id).orElseThrow();
        return t.getMembers();
    }

    // Get all tournaments for a specific member
    @GetMapping("/member/{memberId}")
    public List<Tournament> getTournamentsForMember(@PathVariable Long memberId) {
        return tournamentRepo.findByMembers_Id(memberId);
    }

@GetMapping("/test")
public String test() {
    return "Tournament Controller is working!";
}

}
