package com.adoptdifferently.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String country;
    private String city;
    private String postcode;
    private static long userId;
    private static Set<CatListing> catListings = new HashSet<>(); // <1>

    User(String name, String email, String phoneNumber, String password, String country, String city, String postcode, long userId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.country = country;
        this.city = city;
        this.postcode = postcode;
        User.userId = userId;
    }
    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       if (isValidEmail(email)) {
           this.email = email;
       } else {
        throw new IllegalArgumentException("Invalid email address");
       }   
    }
    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public boolean isAdmin() {
        return false;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        User.userId = userId;
    }

    public static Set<CatListing> getCatListings() {
        catListings.forEach(catListing -> catListing.setId(userId));
        Set<CatListing> list = catListings;
        return list;
    }

    public void setCatListings(Set<CatListing> catListings) {
        User.catListings = catListings;
    }

    // add and remove from catListings
    public void addCatListing(CatListing newCatListing1) {
        catListings.add((CatListing) newCatListing1);
    }

    public void removeCatListing(CatListing newCatListing1) {
        catListings.remove(newCatListing1);
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password
                + ", country=" + country + ", city=" + city + ", postcode=" + postcode + ", userId=" + userId
                + ", catListings=" + catListings + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @SuppressWarnings("static-access")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return userId == other.userId;
    }
    public boolean isValid() {
        return true;
    }
    public User orElse(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'orElse'");
    }

}

