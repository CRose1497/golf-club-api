package com.qap.golf.golfclub.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private BigDecimal entryFee;
    private BigDecimal cashPrize;

    @ManyToMany
    private List<Member> members = new ArrayList<>();

    public Tournament() {}

    public Tournament(LocalDate startDate, LocalDate endDate, String location, BigDecimal entryFee, BigDecimal cashPrize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
    }

    public Long getId() { return id; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public BigDecimal getEntryFee() { return entryFee; }
    public void setEntryFee(BigDecimal entryFee) { this.entryFee = entryFee; }

    public BigDecimal getCashPrize() { return cashPrize; }
    public void setCashPrize(BigDecimal cashPrize) { this.cashPrize = cashPrize; }

    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }
}
