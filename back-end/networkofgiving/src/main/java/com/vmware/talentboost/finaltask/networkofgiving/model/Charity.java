package com.vmware.talentboost.finaltask.networkofgiving.model;

import javax.persistence.*;

@Entity
@Table(name = "charities")
public class Charity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    @Column
    private long donationRequired;
    @Column
    private long donationCollected;
    @Column
    private long volunteersRequired;
    @Column
    private long volunteersCollected;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDonationRequired() {
        return this.donationRequired;
    }

    public void setDonationRequired(long donationRequired) {
        this.donationRequired = donationRequired;
    }

    public long getDonationCollected() {
        return this.donationCollected;
    }

    public void setDonationCollected(long donationCollected) {
        this.donationCollected = donationCollected;
    }

    public long getVolunteersRequired() {
        return this.volunteersRequired;
    }

    public void setVolunteersRequired(long volunteersRequired) {
        this.volunteersRequired = volunteersRequired;
    }

    public long getVolunteersCollected() {
        return this.volunteersCollected;
    }

    public void setVolunteersCollected(long volunteersCollected) {
        this.volunteersCollected = volunteersCollected;
    }
}
