package advertisement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="for_sale")
public class ForSale implements Serializable {

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

    @Column(name="was_built",length=50,nullable=false)
    private Long wasBuilt;

    @Column(name="price",length=50,nullable=false)
    private Long price;

    @Column(name="is_mortgaged",length=1,nullable=false)
    private Long isMortgaged;

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

    public Long getWasBuilt() {
        return wasBuilt;
    }

    public void setWasBuilt(Long wasBuilt) {
        this.wasBuilt = wasBuilt;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getIsMortgaged() {
        return isMortgaged;
    }

    public void setIsMortgaged(Long isMortgaged) {
        this.isMortgaged = isMortgaged;
    }

    public Date getCanBeMoved() {
        return canBeMoved;
    }

    public void setCanBeMoved(Date canBeMoved) {
        this.canBeMoved = canBeMoved;
    }
}
