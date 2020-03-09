package UI.myComponents.buttons;

import Core.Game.Player.PlayerType;
import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class PlayButton extends Button implements MyComponentsInterface
{
    public PlayButton(PlayerType playerType)
    {
        m_playerType = playerType;

        setText("PLAY");
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
            public void handle(ActionEvent actionEvent) {
                if(m_playerType == PlayerType.PLAYER_1)
                    m_publisher.notifyControllers(Events.PLAY_BUTTON_1_CLICKED);
                else if(m_playerType == PlayerType.PLAYER_2)
                    m_publisher.notifyControllers(Events.PLAY_BUTTON_2_CLICKED);
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
