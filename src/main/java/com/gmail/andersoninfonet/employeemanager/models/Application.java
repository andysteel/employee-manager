package com.gmail.andersoninfonet.employeemanager.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "application", schema = "employee_actuator")
public class Application implements Serializable {
    
    private static final long serialVersionUID = 7562798311513697310L;

    @Id
    @SequenceGenerator(name = "seq_application", schema = "employee_actuator", sequenceName = "seq_application",  allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_application")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String context;

    @Column(nullable = false)
    private String monitoringUrl;

    @Column(nullable = false)
    private Boolean isActive;

    /**
     * 
     */
    public Application() {
    }

    /**
     * @param id
     * @param name
     * @param context
     * @param monitoringUrl
     * @param isActive
     */
    public Application(Long id, String name, String context, String monitoringUrl, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.context = context;
        this.monitoringUrl = monitoringUrl;
        this.isActive = isActive;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * @return the monitoringUrl
     */
    public String getMonitoringUrl() {
        return monitoringUrl;
    }

    /**
     * @param monitoringUrl the monitoringUrl to set
     */
    public void setMonitoringUrl(String monitoringUrl) {
        this.monitoringUrl = monitoringUrl;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((monitoringUrl == null) ? 0 : monitoringUrl.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Application other = (Application) obj;
        if (context == null) {
            if (other.context != null)
                return false;
        } else if (!context.equals(other.context))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (isActive == null) {
            if (other.isActive != null)
                return false;
        } else if (!isActive.equals(other.isActive))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (monitoringUrl == null) {
            if (other.monitoringUrl != null)
                return false;
        } else if (!monitoringUrl.equals(other.monitoringUrl))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Application [context=" + context + ", id=" + id + ", isActive=" + isActive + ", name=" + name + ", monitoringUrl="
                + monitoringUrl + "]";
    }
    
    
}
