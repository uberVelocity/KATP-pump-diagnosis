package sample.model;


/**
 * The model of the program. It has a pump. Deal with it.
 */
public class Model {

    private Pump pump;

    public Model() {
        pump = new Pump();
    }

    public Model(Pump pump) {
        this.pump = pump;
    }

    public void setPump(Pump pump) {
        this.pump = pump;
    }

    public Pump getPump() {
        return pump;
    }
}
