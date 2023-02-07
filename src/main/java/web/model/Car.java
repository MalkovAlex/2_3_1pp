package web.model;

public class Car {

    private int id;
    private String model;
    private Integer generation;

    public Car(int id, String model, Integer generation) {
        this.id = id;
        this.model = model;
        this.generation = generation;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", generation=" + generation +
                '}';
    }

}
