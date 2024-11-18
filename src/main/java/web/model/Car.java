package web.model;

public class Car {
    private String madeIn;
    private String model;
    private int year;

    public Car(String madeIn, String model, int year) {
        this.madeIn = madeIn;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return madeIn;
    }

    public void setMake(String make) {
        this.madeIn = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return madeIn + "\t" + model + "\t" + year;
    }
}
