package advertisement.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="for_rent")
public class ForRent implements Serializable {

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

    @Column(name="current_expenses",length=50,nullable=false)
    private Long currentExpenses;

    @Column(name="is_smoking",length=1,nullable=false)
    private Long isSmoking;

    @Column(name="is_for_students",length=1,nullable=false)
    private Long isForStudents;

    @Column(name="can_be_moved",nullable=false)
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

    public Long getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(Long currentExpenses) {
        this.currentExpenses = currentExpenses;
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

    /*
    public String getIsSmoking() {
        Long one = 1L;
        if (this.isSmoking.equals(one)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public void setIsSmoking(Long isSmoking) {
        this.isSmoking = isSmoking;
    }

    public String getIsForStudents() {
        Long one = 1L;
        if (this.isForStudents.equals(one)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public void setIsForStudents(Long isForStudents) {
        this.isForStudents = isForStudents;
    }
    */

    public Date getCanBeMoved() {
        return canBeMoved;
    }

    public void setCanBeMoved(Date canBeMoved) {
        this.canBeMoved = canBeMoved;
    }
}
