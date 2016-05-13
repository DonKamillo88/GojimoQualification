package com.donkamillo.gojimoqualification.ui.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class QualificationModel implements Serializable {

    private String id;
    private String name;
    private String link;
    private Country country;
    private List<Subject> subjects;
    //  private List<DefaultProduct> default_products;


    public QualificationModel(String id, String name, String link, Country country, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.country = country;
        this.subjects = subjects;
    }

    public QualificationModel() {
    }

    public Country getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public class Subject implements Serializable {

        private String id;
        private String title;
        private String link;
        private String colour;

        public Subject(String id, String title, String link, String colour) {
            this.id = id;
            this.title = title;
            this.link = link;
            this.colour = colour;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getColour() {
            return colour;
        }
    }

    public class Country implements Serializable {
        private String code;
        private String name;
        private String createdAt;
        private String updatedAt;
        private String link;

        public Country() {
        }

        public Country(String code, String name, String createdAt, String updatedAt, String link) {
            this.code = code;
            this.name = name;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.link = link;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public String getLink() {
            return link;
        }
    }
}
