package com.qap.golf.golfclub.service;

import com.qap.golf.golfclub.model.Tournament;
import com.qap.golf.golfclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    // Get all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Get a tournament by ID
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    // Add a new tournament
    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Update an existing tournament
    public Tournament updateTournament(Long id, Tournament updatedTournament) {
        Optional<Tournament> existingTournamentOpt = tournamentRepository.findById(id);

        if (existingTournamentOpt.isPresent()) {
            Tournament existing = existingTournamentOpt.get();
            existing.setStartDate(updatedTournament.getStartDate());
            existing.setEndDate(updatedTournament.getEndDate());
            existing.setLocation(updatedTournament.getLocation());
            existing.setEntryFee(updatedTournament.getEntryFee());
            existing.setCashPrize(updatedTournament.getCashPrize());
            return tournamentRepository.save(existing);
        } else {
            return null;
        }
    }

    // Delete a tournament
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}
