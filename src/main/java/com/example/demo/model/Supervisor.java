package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supervisors", schema = "exam24", catalog = "")
public class Supervisor {
    private int supervisorId;

    @Id
    @Column(name = "supervisorID")
    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supervisor that = (Supervisor) o;

        if (supervisorId != that.supervisorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return supervisorId;
    }
}
