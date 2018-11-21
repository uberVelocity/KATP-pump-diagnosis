package sample.model;

public class Model {

    private User user;

    public Model() {
        user = new User();
    }

    public Model(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
