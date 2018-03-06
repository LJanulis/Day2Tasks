package lt.swedbank.itacademy.tasks.domain;

public class RealEstateLoan extends Loan{

    private String district;
    private float area;
    private RealEstatePurpose purpose;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public RealEstatePurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(RealEstatePurpose purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "RealEstateLoan{" +
                "district='" + district + '\'' +
                ", area=" + area +
                ", purpose=" + purpose +
                '}';
    }
}
