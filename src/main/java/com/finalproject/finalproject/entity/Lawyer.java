package com.finalproject.finalproject.entity;

import java.util.Set;

public class Lawyer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private double hourlyRate;
    private Set<Client> Client;
    private Set<ClientMatter> ClientMatter;

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

    public Set<com.finalproject.finalproject.entity.Client> getClient() {
        return Client;
    }

    public void setClient(Set<com.finalproject.finalproject.entity.Client> client) {
        Client = client;
    }

    public Set<com.finalproject.finalproject.entity.ClientMatter> getClientMatter() {
        return ClientMatter;
    }

    public void setClientMatter(Set<com.finalproject.finalproject.entity.ClientMatter> clientMatter) {
        ClientMatter = clientMatter;
    }
}
