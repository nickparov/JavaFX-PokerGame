package UI.myComponents.labels;

import Core.Game.Player.PlayerType;
import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import javafx.scene.control.Label;

public class TotalWinnings extends Label implements MyComponentsInterface
{
    public TotalWinnings(PlayerType playerType)
    {
        m_playerType = playerType;

        updateText();
    }

    public void add(int currentWin)
    {
        m_totalWinnings += currentWin;

        updateText();
    }

    private void updateText()
    {
        if(m_playerType == PlayerType.PLAYER_1)
            setText("   PLAYER 1\n   TOTAL WINNINGS = " + m_totalWinnings);
        else if(m_playerType == PlayerType.PLAYER_2)
            setText("   PLAYER 2\n   TOTAL WINNINGS = " + m_totalWinnings);
    }

    @Override
    public void update(Events event)
    {

    }

    @Override
    public void attachEventListeners()
    {

    }

    @Override
    public void setPublisher(Publisher publisher)
    {
        m_publisher = publisher;
    }


    private PlayerType m_playerType;
    private int m_totalWinnings = 0;
    private Publisher m_publisher;
}
