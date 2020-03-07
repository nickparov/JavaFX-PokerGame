package UI.myComponents.buttons;

import Core.Game.Player.PlayerType;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;

import UI.myComponents.Publisher;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class FoldButton extends Button implements MyComponentsInterface
{
    public FoldButton(PlayerType playerType)
    {
        m_playerType = playerType;

        setText("FOLD");
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
                if(m_playerType == PlayerType.PLAYER_1)
                    m_publisher.notifyControllers(Events.FOLD_BUTTON_1_CLICKED);
                else if(m_playerType == PlayerType.PLAYER_2)
                    m_publisher.notifyControllers(Events.FOLD_BUTTON_2_CLICKED);
            }
        });
    }

    @Override
    public void setPublisher(Publisher publisher)
    {
        m_publisher = publisher;
    }

    private PlayerType m_playerType;
    private Publisher m_publisher;
}
