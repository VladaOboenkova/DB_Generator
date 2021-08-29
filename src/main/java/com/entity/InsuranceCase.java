package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "insurance_case")
public class InsuranceCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_person_insurance")
    private PersonInsurance id_person_insurance;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_insurance_type")
    private InsuranceType id_insurance_type;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "payout")
    private BigDecimal payout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonInsurance getId_person_insurance() {
        return id_person_insurance;
    }

    public void setId_person_insurance(PersonInsurance id_person_insurance) {
        this.id_person_insurance = id_person_insurance;
    }

    public InsuranceType getId_insurance_type() {
        return id_insurance_type;
    }

    public void setId_insurance_type(InsuranceType id_insurance_type) {
        this.id_insurance_type = id_insurance_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPayout() {
        return payout;
    }

    public void setPayout(BigDecimal payout) {
        this.payout = payout;
    }
}
