package org.academiadecodigo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

    @Entity
    @Table(name = "customer")
    public class Customer {

        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private Integer password;
        private CulturalChallenge culturalChallenge;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Integer getPassword() {
            return password;
        }

        public void setPassword(Integer password) {
            this.password = password;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public CulturalChallenge getCulturalChallenge() {
            return culturalChallenge;
        }

        public void setCulturalChallenge(CulturalChallenge culturalChallenge) {
            this.culturalChallenge = culturalChallenge;
        }
    }
