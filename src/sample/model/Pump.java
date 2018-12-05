package sample.model;

/**
 * Class which holds the information of the centrifugal pump.
 */
public class Pump {

    private boolean isVibrating = false;
    private boolean isOperating = false;

    private String recommendation;

    /* RPM parameter used by Mihai for testing field inputs. */
    private int rpm;

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

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }
}
