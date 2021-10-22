package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "insurance_option", uniqueConstraints =
@UniqueConstraint(columnNames = { "id_insurance", "id_insurance_type" }))
public class InsuranceOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_insurance")
    private Insurance id_insurance;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_insurance_type")
    private InsuranceType id_insurance_type;

    @NotNull
    @Column(name = "sum_insured")
    private BigDecimal sum_insured;

    public Insurance getId_insurance() {
        return id_insurance;
    }

    public void setId_insurance(Insurance id_insurance) {
        this.id_insurance = id_insurance;
    }

    public InsuranceType getId_insurance_type() {
        return id_insurance_type;
    }

    public void setId_insurance_type(InsuranceType id_insurance_type) {
        this.id_insurance_type = id_insurance_type;
    }

    public BigDecimal getSum_insured() {
        return sum_insured;
    }

    public void setSum_insured(BigDecimal sum_insured) {
        this.sum_insured = sum_insured;
    }
}
