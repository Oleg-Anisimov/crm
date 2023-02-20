package me.stepanov.crm.domain;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    abstract Serializable getId();
    protected LocalDateTime created = LocalDateTime.now();

    @UpdateTimestamp
    protected LocalDateTime updated;

}
