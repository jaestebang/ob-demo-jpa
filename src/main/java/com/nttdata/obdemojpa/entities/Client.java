package com.nttdata.obdemojpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Getter
    @Setter
    @EmbeddedId
    private ClientId clientId;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "second_name")
    private String secondName;

    @Getter
    @Setter
    @Column(name = "first_lastname")
    private String firstLastName;

    @Getter
    @Setter
    @Column(name = "second_lastname")
    private String secondLastName;

    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;

    /**
     * Constructor empty
     */
    public Client() {
    }

    /**
     * Init Client
     * @param clientId
     * @param firstName
     * @param secondName
     * @param firstLastName
     * @param secondLastName
     * @param phone
     * @param address
     * @param city
     */
    public Client(ClientId clientId, String firstName, String secondName, String firstLastName, String secondLastName, String phone, String address, String city) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
