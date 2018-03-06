package lt.swedbank.itacademy.tasks.domain;

import java.util.Date;

/**
 * @author Lukas
 */
public class HouseLoan extends RealEstateLoan {

    private int floorCount;
    private Date constructionDate;

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public Date getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }
}
