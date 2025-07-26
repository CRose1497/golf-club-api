package com.qap.golf.golfclub.service;

import com.qap.golf.golfclub.model.Tournament;
import com.qap.golf.golfclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament updateTournament(Long id, Tournament updatedTournament) {
        return tournamentRepository.findById(id).map(existing -> {
            existing.setStartDate(updatedTournament.getStartDate());
            existing.setEndDate(updatedTournament.getEndDate());
            existing.setLocation(updatedTournament.getLocation());
            existing.setEntryFee(updatedTournament.getEntryFee());
            existing.setCashPrize(updatedTournament.getCashPrize());
            existing.setMembers(updatedTournament.getMembers());
            return tournamentRepository.save(existing);
        }).orElse(null);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    // Search functionality
    public List<Tournament> findByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> findByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Tournament> findByMembers_Id(Long memberId) {
        return tournamentRepository.findByMembers_Id(memberId);
    }
}
