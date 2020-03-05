package UI.myControllers.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class FoldButton extends Button
{
    public FoldButton()
    {
        setText("FOLD");
    }

    private void setEventListeners()
    {
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //m_handlersManager.getPlayerHandlers().foldButtonPressed();
            }
        });
    }

}
