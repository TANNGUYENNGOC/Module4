package com.example.demo.model.contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContractDetail {
    @Id
    private int id;
    @ManyToOne
    private Contract contractId;
    @ManyToOne
    private AttachFacility attachFacility;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(Contract contractId, AttachFacility attachFacility, int quantity) {
        this.contractId = contractId;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
