package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "person_insurance")
public class PersonInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name="id_tourists")
    private Tourists tourists;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_insurance")
    private Insurance id_insurance;

    @NotNull
    @Column(name = "policy_num")
    private String policy_num;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tourists getTourists() {
        return tourists;
    }

    public void setTourists(Tourists tourists) {
        this.tourists = tourists;
    }

    public Insurance getId_insurance() {
        return id_insurance;
    }

    public void setId_insurance(Insurance id_insurance) {
        this.id_insurance = id_insurance;
    }

    public String getPolicy_num() {
        return policy_num;
    }

    public void setPolicy_num(String policy_num) {
        this.policy_num = policy_num;
    }
}
