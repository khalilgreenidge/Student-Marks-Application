/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkBookApp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author khalil
 */
@Entity
@Table(name = "COURSEMARKS", catalog = "", schema = "TUTOR")
@NamedQueries({
    @NamedQuery(name = "Coursemarks.findAll", query = "SELECT c FROM Coursemarks c"),
    @NamedQuery(name = "Coursemarks.findById", query = "SELECT c FROM Coursemarks c WHERE c.id = :id"),
    @NamedQuery(name = "Coursemarks.findByFirstName", query = "SELECT c FROM Coursemarks c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Coursemarks.findByLastName", query = "SELECT c FROM Coursemarks c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Coursemarks.findByTest1", query = "SELECT c FROM Coursemarks c WHERE c.test1 = :test1"),
    @NamedQuery(name = "Coursemarks.findByTest2", query = "SELECT c FROM Coursemarks c WHERE c.test2 = :test2"),
    @NamedQuery(name = "Coursemarks.findByAssignment", query = "SELECT c FROM Coursemarks c WHERE c.assignment = :assignment"),
    @NamedQuery(name = "Coursemarks.findByProject", query = "SELECT c FROM Coursemarks c WHERE c.project = :project"),
    @NamedQuery(name = "Coursemarks.findByPaper1", query = "SELECT c FROM Coursemarks c WHERE c.paper1 = :paper1"),
    @NamedQuery(name = "Coursemarks.findByPaper2", query = "SELECT c FROM Coursemarks c WHERE c.paper2 = :paper2")})
public class Coursemarks implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEST1")
    private Double test1;
    @Column(name = "TEST2")
    private Double test2;
    @Column(name = "ASSIGNMENT")
    private Double assignment;
    @Column(name = "PROJECT")
    private Double project;
    @Column(name = "PAPER1")
    private Double paper1;
    @Column(name = "PAPER2")
    private Double paper2;

    public Coursemarks() {
    }

    public Coursemarks(Integer id) {
        this.id = id;
    }

    public Coursemarks(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public Double getTest1() {
        return test1;
    }

    public void setTest1(Double test1) {
        Double oldTest1 = this.test1;
        this.test1 = test1;
        changeSupport.firePropertyChange("test1", oldTest1, test1);
    }

    public Double getTest2() {
        return test2;
    }

    public void setTest2(Double test2) {
        Double oldTest2 = this.test2;
        this.test2 = test2;
        changeSupport.firePropertyChange("test2", oldTest2, test2);
    }

    public Double getAssignment() {
        return assignment;
    }

    public void setAssignment(Double assignment) {
        Double oldAssignment = this.assignment;
        this.assignment = assignment;
        changeSupport.firePropertyChange("assignment", oldAssignment, assignment);
    }

    public Double getProject() {
        return project;
    }

    public void setProject(Double project) {
        Double oldProject = this.project;
        this.project = project;
        changeSupport.firePropertyChange("project", oldProject, project);
    }

    public Double getPaper1() {
        return paper1;
    }

    public void setPaper1(Double paper1) {
        Double oldPaper1 = this.paper1;
        this.paper1 = paper1;
        changeSupport.firePropertyChange("paper1", oldPaper1, paper1);
    }

    public Double getPaper2() {
        return paper2;
    }

    public void setPaper2(Double paper2) {
        Double oldPaper2 = this.paper2;
        this.paper2 = paper2;
        changeSupport.firePropertyChange("paper2", oldPaper2, paper2);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coursemarks)) {
            return false;
        }
        Coursemarks other = (Coursemarks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MarkBookApp.Coursemarks[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
