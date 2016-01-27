package no.vestein.luafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import no.vestein.luafx.event.EventBus;
import no.vestein.luafx.fx.SimpleStackPane;

/**
 * Created by Vestein on 25.01.2016.
 */
public class LuaFX extends Application {

  public static SimpleStackPane root;
  public static EventBus EVENT_BUS;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    EVENT_BUS = new EventBus();

    primaryStage.setTitle("Hello World!");
    Button btn = new Button();
    btn.setText("Say 'Hello World'");
    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        System.out.println("Hello World!");
      }
    });

    root = new SimpleStackPane();
    root.getChildren().add(btn);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();

    testLua();
  }

  public void testLua() {
    LuaRunnable runnable = new LuaRunnable("src/main/resources/lua/test.lua");
    runnable.addLib("src/main/resources/lua/os.lua");
    Thread threadLua = new Thread(runnable);

    threadLua.start();
  }
}
