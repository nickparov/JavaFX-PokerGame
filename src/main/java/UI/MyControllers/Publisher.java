package UI.myControllers;

import java.util.ArrayList;

public class Publisher
{
    public void addController(MyControllersInterface subscriber)
    {
        m_myControllers.add(subscriber);
        subscriber.setPublisher(this);
    }

    public void addControllers(MyControllersInterface ...subscribers)
    {
        for(MyControllersInterface subscriber : subscribers)
        {
            m_myControllers.add(subscriber);
            subscriber.setPublisher(this);
        }
    }

    public void removeController(MyControllersInterface subscriber)
    {
        m_myControllers.remove(subscriber);
        subscriber.setPublisher(null);
    }

    public void removeControllers(MyControllersInterface ...subscribers)
    {
        for(MyControllersInterface subscriber : subscribers)
        {
            m_myControllers.remove(subscriber);
            subscriber.setPublisher(null);
        }
    }



    public void notifyControllers(Events event)
    {
        for(MyControllersInterface myController : m_myControllers)
            myController.update(event);
    }

    private ArrayList<MyControllersInterface> m_myControllers = new ArrayList<>();
}
