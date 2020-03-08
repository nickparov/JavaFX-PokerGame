package UI.myComponents.buttons;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import game.ControlFlow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RevealCardsButton extends Button implements MyComponentsInterface
{
    public RevealCardsButton()
    {
        setText("REVEAL");
        attachEventListeners();

        setDisable(true);
    }

    @Override
    public void update(Events event)
    {
        if (event == Events.PLAY_BUTTON_1_CLICKED)
        {
            m_counter++;
            m_player1_plays = true;
        }

        else if(event == Events.PLAY_BUTTON_2_CLICKED)
        {
            m_counter++;
            m_player2_plays = true;
        }

        else if(event == Events.FOLD_BUTTON_1_CLICKED)
        {
            m_counter++;
            m_player1_plays = false;
        }

        else if(event == Events.FOLD_BUTTON_2_CLICKED)
        {
            m_counter++;
            m_player2_plays = false;
        }

        if(m_counter == 2)
            setDisable(false);
    }

    @Override
    public void attachEventListeners()
    {
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                m_counter = 0;
                ControlFlow.getInstance().revealAndCalculate(m_player1_plays, m_player2_plays);
                m_publisher.notifyControllers(Events.REVEAL_CARDS_BUTTON_CLICKED);
            }
        });
    }

    @Override
    public void setPublisher(Publisher publisher)
    {
        m_publisher = publisher;
    }

    private Publisher m_publisher;

    private boolean m_player1_plays = false;
    private boolean m_player2_plays = false;

    private int m_counter = 0;
}
