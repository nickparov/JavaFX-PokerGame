package UI.myControllers.buttons;

import UI.myControllers.Events;
import UI.myControllers.MyControllersInterface;
import UI.myControllers.Publisher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class NewRoundButton extends Button implements MyControllersInterface
{
    public NewRoundButton()
    {
        setText("ROUND");
        attachEventListeners();
    }

    @Override
    public void update(Events event)
    {

    }

    @Override
    public void attachEventListeners()
    {
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //m_publisher.notifyControllers(Events.FOLD_BUTTON_1_CLICKED);
            }
        });
    }

    @Override
    public void setPublisher(Publisher publisher)
    {
        m_publisher = publisher;
    }


    private Publisher m_publisher;
}
