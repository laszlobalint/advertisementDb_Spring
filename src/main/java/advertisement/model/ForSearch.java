package advertisement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="for_search")
public class ForSearch implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",length=50,nullable=false)
    private Long id;

    @Column(name="user_id",length=50,nullable=false)
    private Long userId;

    @Column(name="text",nullable=false)
    private String text;

    @Column(name="county",length=50,nullable=false)
    private String county;

    @Column(name="caution_months",length=50,nullable=false)
    private Long cautionMonths;

    @Column(name="monthly_rent",length=50,nullable=false)
    private Long monthlyRent;

    @Column(name="is_smoking",length=1,nullable=false)
    private Long isSmoking;

    @Column(name="is_for_students",length=1,nullable=false)
    private Long isForStudents;

    @Column(name="current_inmate",length=50,nullable=false)
    private Long currentInmate;

    @Column(name="is_man",length=1,nullable=false)
    private Long isMan;

    @Column(name="can_be_moved",length=50,nullable=false)
    private Date canBeMoved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Long getCautionMonths() {
        return cautionMonths;
    }

    public void setCautionMonths(Long cautionMonths) {
        this.cautionMonths = cautionMonths;
    }

    public Long getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Long monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Long getIsSmoking() {
        return isSmoking;
    }

    public void setIsSmoking(Long isSmoking) {
        this.isSmoking = isSmoking;
    }

    public Long getIsForStudents() {
        return isForStudents;
    }

    public void setIsForStudents(Long isForStudents) {
        this.isForStudents = isForStudents;
    }

    public Long getCurrentInmate() {
        return currentInmate;
    }

    public void setCurrentInmate(Long currentInmate) {
        this.currentInmate = currentInmate;
    }

    public Long getIsMan() {
        return isMan;
    }

    public void setIsMan(Long isMan) {
        this.isMan = isMan;
    }

    public Date getCanBeMoved() {
        return canBeMoved;
    }

    public void setCanBeMoved(Date canBeMoved) {
        this.canBeMoved = canBeMoved;
    }
}
