package com.newProject.protectHire.dto.user;

public class CompanyUpdateRequest {
    private String companyName;
    private String location;
    private String description;
    private String website;
    private String phone;
    
    // Constructors, getters, setters
    public CompanyUpdateRequest() {}
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
