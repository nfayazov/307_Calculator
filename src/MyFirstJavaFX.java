import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;

public class MyFirstJavaFX extends Application{

	Label label1;
	//Button button1;
	String[][]buttons = new String [][]{
		{ "1", "4", "7", "*"},
		{ "2", "5", "8", "0"},
		{ "3", "6", "9", "-"},
		{ "+", "-", "="}
	};
   
    @Override
    public void start(Stage stage) throws Exception {
    	
    	StringBuilder text = new StringBuilder("");
    	
        stage.setTitle("My First Calculator");
        label1 = new Label("0");
        VBox labelBox = new VBox();
        labelBox.getChildren().add(label1);
        
        VBox root = new VBox();
        root.getChildren().add(labelBox);
        
        HBox numbers = new HBox();
        root.getChildren().add(numbers);
        
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        
        for (int col = 0; col < buttons.length; col++) {
        		VBox column = new VBox();//vertical box
            column.setSpacing(5);

            
            for (int i = 0; i < buttons[col].length; i++) {
	        		Button button = new Button(buttons[col][i]);
	        		final String val = new String(buttons[col][i]);
	        		button.setOnAction(new EventHandler<ActionEvent>() {
	            		public void handle(ActionEvent event) {
	            			text.append(val);
	            			
	            			if (val.equals(buttons[3][2])) {
	            				int a = Character.getNumericValue(text.charAt(0));
            					int b = Character.getNumericValue(text.charAt(2));
            					Integer result = new Integer(0);
            					
            					OperatorFactory of = new OperatorFactory();
            					Operator op = of.getOperator(text.charAt(1));
            					result = op.calculate(a,b);
	            				
            					label1.setText(result.toString()); 
	            			}
	            			else {
	            				label1.setText(text.toString());
	            			}
	            		}
	            });
	        		column.getChildren().addAll(button);
            }
            
            numbers.getChildren().add(column);

        }
        stage.show();
    }
 public static void main(String[] args) {
        launch(args);
    }
}