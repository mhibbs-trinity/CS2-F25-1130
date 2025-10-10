package cs2.graphics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;

public class InteractiveExamples extends Application {

    private Canvas canvas;
    private GraphicsContext g;
    private void clearCanvas(Color c) {
        g.setFill(c);
        g.fillRect(0, 0, 600, 600);
    }
    private void clearCanvas() { clearCanvas(Color.WHITE);}

    // Method reference example for mouse clicks
    private void handleClick(MouseEvent e) {
      if(e.getButton() != MouseButton.PRIMARY) { 
        clearCanvas();
      } else {
        double x = e.getX();
        double y = e.getY();
        g.setFill(Color.BLACK);
        g.fillOval(x-5, y-5, 10, 10);
      }
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) {
        canvas = new Canvas(600, 600);
        Scene scene = new Scene(new StackPane(canvas));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Interactive Examples");
        primaryStage.show();

        g = canvas.getGraphicsContext2D();

        canvas.requestFocus(); 

        int pressCount = 0;

        /* Approach #1 to set up event handlers:
         * Use a lambda expression to define the handle method.
         * This is more concise, but it can be harder to read.
         * It also requires Java 8 or later.
         */
        canvas.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.R) { clearCanvas(Color.RED); }
            if(e.getCode() == KeyCode.G) { clearCanvas(Color.GREEN); }
            if(e.getCode() == KeyCode.B) { clearCanvas(Color.BLUE); }
            
            //Within this scope, you can only use e, not "this",
            //because "this" would refer to the lambda expression itself.
            //To refer to the InteractiveExamples object, use InteractiveExamples.this

            //But access to variables local to the enclosing method is limited.
            //You can read them, but you can't modify them.
            System.out.println("Key pressed " + pressCount + " times."); //This is OK.
            //pressCount++; //This would cause a compile error.
        });

        /* Technically - we're really creating a new class that implements
         * EventHandler<KeyEvent> - but we don't give it a name.
         * Instead, we just define the handle method right here.
         * This is called an "anonymous inner class".
         * It is more verbose than using a lambda expression, but it makes what's
         * happening clearer. It also shows how scope matters more explicitly:
         */
        double priorX = 0;
        double priorY = 0;
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            
            //This is a new class, so it can have its own instance variables.
            private double innerPriorX = 0; //These are NOT the same as priorX and priorY
            private double innerPriorY = 0; //and their scope is limited to this class.

            @Override
            public void handle(MouseEvent e) {
                if(e.getButton() == MouseButton.PRIMARY) {
                    double x = e.getX();
                    double y = e.getY();
                    g.setStroke(Color.BLACK);
                    g.setLineWidth(3);
                    //Access to instance variables of InteractiveExamples is OK:
                    //We can use g, clearCanvas(), and read from priorX, priorY, etc.
                    //g.strokeLine(priorX, priorY, x, y); //This would be OK

                    //But we can't modify priorX or priorY, because they are local variables
                    //priorX = x; //ERROR - cannot assign a value to effectively final variable priorX
                    //priorY = y; //ERROR - cannot assign a value to effectively final variable priorY

                    //We can read and write to instance variables of this inner class:
                    g.strokeLine(innerPriorX, innerPriorY, x, y);
                    innerPriorX = x;
                    innerPriorY = y;
                }
            }
        });
        
        /* Approach #2 - Method Reference
         * Define a method that matches the signature of the handle method,
         * then pass that method as a parameter.
         * This is concise and clear, but it requires Java 8 or later.
         * It also requires that the handler method be defined in advance,
         * which may not always be possible or desirable.
         */
        canvas.setOnMouseClicked(this::handleClick);

    }
  
}
