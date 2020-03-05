package UI.myControllers.buttons;

import UI.myControllers.MyControllersInterface;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class FoldButton extends Button implements MyControllersInterface
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
