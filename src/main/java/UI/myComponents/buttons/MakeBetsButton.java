package UI.myComponents.buttons;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.MyComponentsManager;
import UI.myComponents.Publisher;
import game.ControlFlow;
import game.ControlFlowContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MakeBetsButton extends Button implements MyComponentsInterface
{
    public MakeBetsButton()
    {
        setText("MAKE BETS");
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
            public void handle(ActionEvent actionEvent)
            {
                ControlFlowContext.getInstance().processState();
                //ControlFlow.getInstance().makeBets();
                m_publisher.notifyControllers(Events.MAKE_BETS_BUTTON_CLICKED);
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
