package sample.model;

public class Pump {

    private boolean isVibrating = false;
    private boolean isOperating = false;

    public Pump() {

    }

    public void setOperating(boolean operating) {
        isOperating = operating;
    }

    public void setVibrating(boolean vibrating) {
        isVibrating = vibrating;
    }

    public boolean isVibrating() {
        return isVibrating;
    }

    public boolean isOperating() {
        return isOperating;
    }
}
