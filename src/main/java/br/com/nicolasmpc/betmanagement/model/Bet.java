package br.com.nicolasmpc.betmanagement.model;

import br.com.nicolasmpc.betmanagement.enums.BetResult;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_BET")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = false, nullable = true)
    private String teamOne;

    @Column(unique = false, nullable = true)
    private String teamTwo;

    @Column(unique = false, nullable = true)
    private LocalDate gameDay;

    @Column(unique = false, nullable = false)
    private Double unit;

    @Column(unique = false, nullable = false)
    private Double odd;

    @Column(unique = false, nullable = true)
    private BetResult result;

    @Column(unique = false, nullable = true)
    private Double unitResult;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @OneToOne
    @JoinColumn(name = "market_id")
    private Market market;

    public Market getMarket() {
        return market;
    }

    public Bet() {
    }

    public Bet(UUID id,
               String teamOne,
               String teamTwo,
               LocalDate gameDay,
               Double unit,
               Double odd,
               BetResult result,
               Double unitResult,
               User user,
               Competition competition,
               Market market) {
        this.id = id;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.gameDay = gameDay;
        this.unit = unit;
        this.odd = odd;
        this.result = result;
        this.unitResult = unitResult;
        this.user = user;
        this.competition = competition;
        this.market = market;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public LocalDate getGameDay() {
        return gameDay;
    }

    public void setGameDay(LocalDate gameDay) {
        this.gameDay = gameDay;
    }

    public Double getUnit() {
        return unit;
    }

    public void setUnit(Double unit) {
        this.unit = unit;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    public BetResult getResult() {
        return result;
    }

    public void setResult(BetResult result) {
        this.result = result;
    }

    public Double getUnitResult() {
        return unitResult;
    }

    public void setUnitResult(Double unitResult) {
        this.unitResult = unitResult;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }


}
