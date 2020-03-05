package UI.player;

public class HandlersManager {
    public HandlersManager()
    {
    }

    public PlayerHandlers getPlayerHandlers()
    {
        return m_playerHandlers;
    }

    private PlayerHandlers m_playerHandlers = new PlayerHandlers();
}
