package UI.myComponents.buttons;

import Core.Game.Player.PlayerType;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;

import UI.myComponents.MyComponentsManager;
import UI.myComponents.Publisher;
import game.ControlFlow;
import javafx.event.Event;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class DealButton extends Button implements MyComponentsInterface
{
    public DealButton()
    {
        setText("DEAL CARDS");
        attachEventListeners();

        setDisable(true);
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
                ControlFlow.getInstance().dealCards();
                m_publisher.notifyControllers(Events.DEAL_BUTTON_CLICKED);
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

