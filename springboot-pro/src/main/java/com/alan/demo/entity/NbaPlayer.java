package com.alan.demo.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "nba_player")
public class NbaPlayer {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "countryEn")
    private String countryen;

    @Column(name = "teamName")
    private String teamname;

    @Column(name = "birthDay")
    private Long birthday;

    private String country;

    @Column(name = "teamCityEn")
    private String teamcityen;

    private String code;

    @Column(name = "displayAffiliation")
    private String displayaffiliation;

    @Column(name = "displayName")
    private String displayname;

    @Column(name = "schoolType")
    private String schooltype;

    @Column(name = "teamConference")
    private String teamconference;

    @Column(name = "teamConferenceEn")
    private String teamconferenceen;

    private String weight;

    @Column(name = "teamCity")
    private String teamcity;

    @Column(name = "playYear")
    private Integer playyear;

    @Column(name = "jerseyNo")
    private String jerseyno;

    @Column(name = "teamNameEn")
    private String teamnameen;

    private Integer draft;

    @Column(name = "displayNameEn")
    private String displaynameen;

    @Column(name = "birthDayStr")
    private String birthdaystr;

    @Column(name = "heightValue")
    private BigDecimal heightvalue;

    private String position;

    private Integer age;

    @Column(name = "playerId")
    private String playerid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return countryEn
     */
    public String getCountryen() {
        return countryen;
    }

    /**
     * @param countryen
     */
    public void setCountryen(String countryen) {
        this.countryen = countryen;
    }

    /**
     * @return teamName
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * @param teamname
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    /**
     * @return birthDay
     */
    public Long getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return teamCityEn
     */
    public String getTeamcityen() {
        return teamcityen;
    }

    /**
     * @param teamcityen
     */
    public void setTeamcityen(String teamcityen) {
        this.teamcityen = teamcityen;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return displayAffiliation
     */
    public String getDisplayaffiliation() {
        return displayaffiliation;
    }

    /**
     * @param displayaffiliation
     */
    public void setDisplayaffiliation(String displayaffiliation) {
        this.displayaffiliation = displayaffiliation;
    }

    /**
     * @return displayName
     */
    public String getDisplayname() {
        return displayname;
    }

    /**
     * @param displayname
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    /**
     * @return schoolType
     */
    public String getSchooltype() {
        return schooltype;
    }

    /**
     * @param schooltype
     */
    public void setSchooltype(String schooltype) {
        this.schooltype = schooltype;
    }

    /**
     * @return teamConference
     */
    public String getTeamconference() {
        return teamconference;
    }

    /**
     * @param teamconference
     */
    public void setTeamconference(String teamconference) {
        this.teamconference = teamconference;
    }

    /**
     * @return teamConferenceEn
     */
    public String getTeamconferenceen() {
        return teamconferenceen;
    }

    /**
     * @param teamconferenceen
     */
    public void setTeamconferenceen(String teamconferenceen) {
        this.teamconferenceen = teamconferenceen;
    }

    /**
     * @return weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return teamCity
     */
    public String getTeamcity() {
        return teamcity;
    }

    /**
     * @param teamcity
     */
    public void setTeamcity(String teamcity) {
        this.teamcity = teamcity;
    }

    /**
     * @return playYear
     */
    public Integer getPlayyear() {
        return playyear;
    }

    /**
     * @param playyear
     */
    public void setPlayyear(Integer playyear) {
        this.playyear = playyear;
    }

    /**
     * @return jerseyNo
     */
    public String getJerseyno() {
        return jerseyno;
    }

    /**
     * @param jerseyno
     */
    public void setJerseyno(String jerseyno) {
        this.jerseyno = jerseyno;
    }

    /**
     * @return teamNameEn
     */
    public String getTeamnameen() {
        return teamnameen;
    }

    /**
     * @param teamnameen
     */
    public void setTeamnameen(String teamnameen) {
        this.teamnameen = teamnameen;
    }

    /**
     * @return draft
     */
    public Integer getDraft() {
        return draft;
    }

    /**
     * @param draft
     */
    public void setDraft(Integer draft) {
        this.draft = draft;
    }

    /**
     * @return displayNameEn
     */
    public String getDisplaynameen() {
        return displaynameen;
    }

    /**
     * @param displaynameen
     */
    public void setDisplaynameen(String displaynameen) {
        this.displaynameen = displaynameen;
    }

    /**
     * @return birthDayStr
     */
    public String getBirthdaystr() {
        return birthdaystr;
    }

    /**
     * @param birthdaystr
     */
    public void setBirthdaystr(String birthdaystr) {
        this.birthdaystr = birthdaystr;
    }

    /**
     * @return heightValue
     */
    public BigDecimal getHeightvalue() {
        return heightvalue;
    }

    /**
     * @param heightvalue
     */
    public void setHeightvalue(BigDecimal heightvalue) {
        this.heightvalue = heightvalue;
    }

    /**
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return playerId
     */
    public String getPlayerid() {
        return playerid;
    }

    /**
     * @param playerid
     */
    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }
}