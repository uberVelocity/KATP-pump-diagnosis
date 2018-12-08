package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;

import sample.controller.Controller;
import sample.drools.KB;
import sample.model.Model;
import sample.view.View;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        View view = new View(primaryStage);
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }

    /*
    Whenever the main java program starts it calls launch(args) and sets up the program
    as a JavaFX application. The app will call the method start().
     */
    public static void main(String[] args) {
        try {
            KnowledgeBase knowledgeBase = KB.readKnowledgeBase();
            StatefulKnowledgeSession ksession = knowledgeBase.newStatefulKnowledgeSession();
            ksession.fireAllRules();
            launch(args);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
