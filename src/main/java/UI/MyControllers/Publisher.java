package UI.myControllers;

import java.util.ArrayList;

public class Publisher
{
    public void addControllers(MyControllersInterface subscriber)
    {
        m_myControllers.add(subscriber);
    }

    public void removeControllers(MyControllersInterface subscriber)
    {
        m_myControllers.remove(subscriber);
    }

    public void notifyControllers()
    {

    }

    private ArrayList<MyControllersInterface> m_myControllers = new ArrayList<>();
}
