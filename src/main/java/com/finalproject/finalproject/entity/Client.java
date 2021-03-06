package com.finalproject.finalproject.entity;

import com.fasterxml.jackson.annotation.*;

import com.finalproject.finalproject.entity.Lawyer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneHome;
    private String phoneCell;
    private String phoneWork;
    private String email;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    //REMOVE AND JUST HAVE THE INTERSECTION BETWEEN LAWYERS AND CLIENTS BE THE CLIENT MATTER?
    @JsonProperty("lawyers")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "client", "clientMatter"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "lawyer_clients",
            joinColumns = @JoinColumn(name = "clientid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lawyerid", referencedColumnName = "id")
    )
    private Set<Lawyer> lawyer;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "lawyer", "client"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Set<ClientMatter> ClientMatters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneCell() {
        return phoneCell;
    }

    public void setPhoneCell(String phoneCell) {
        this.phoneCell = phoneCell;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Set<Lawyer> getLawyer() {
        return lawyer;
    }

    public void setLawyer(Set<Lawyer> lawyer) {
        this.lawyer = lawyer;
    }

    public Set<ClientMatter> getClientMatter() {
        return ClientMatters;
    }

    public void setClientMatter(Set<ClientMatter> clientMatters) {
        this.ClientMatters = ClientMatters;
    }
}
