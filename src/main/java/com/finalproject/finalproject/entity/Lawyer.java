package com.finalproject.finalproject.entity;

import com.finalproject.finalproject.entity.ClientMatter;
import com.finalproject.finalproject.entity.Client;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private double hourlyRate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lawyer")
    private Set<Client> Clients;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "lawyer")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Set<Client> getClient() {
        return Clients;
    }

    public void setClient(Set<Client> client) {
        this.Clients = client;
    }
    //Many to Many???

    public Set<ClientMatter> getClientMatter() {
        return ClientMatters;
    }

    public void setClientMatter(Set<ClientMatter> ClientMatters) {
        this.ClientMatters = ClientMatters;
    }
}
