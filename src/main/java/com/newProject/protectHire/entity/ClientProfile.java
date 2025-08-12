package com.newProject.protectHire.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CLIENT")
public class ClientProfile extends User {
    
    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "company_address")
    private String companyAddress;
    
    @Column(name = "contact_person")
    private String contactPerson;
    
    @Column(name = "tax_id")
    private String taxId;
    
    @Column(name = "is_verified")
    private Boolean isVerified = false;
    
    // Constructors, getters, and setters
    public ClientProfile() {}
    
    // Getters and Setters
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public String getCompanyAddress() { return companyAddress; }
    public void setCompanyAddress(String companyAddress) { this.companyAddress = companyAddress; }
    
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    
    public String getTaxId() { return taxId; }
    public void setTaxId(String taxId) { this.taxId = taxId; }
    
    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }
}
