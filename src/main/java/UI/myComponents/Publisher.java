package UI.myComponents;

import java.util.ArrayList;

public class Publisher
{
    public void addComponent(MyComponentsInterface subscriber)
    {
        m_myControllers.add(subscriber);
        subscriber.setPublisher(this);
    }

    public void addComponents(MyComponentsInterface ...subscribers)
    {
        for(MyComponentsInterface subscriber : subscribers)
        {
            m_myControllers.add(subscriber);
            subscriber.setPublisher(this);
        }
    }

    public void removeComponent(MyComponentsInterface subscriber)
    {
        m_myControllers.remove(subscriber);
        subscriber.setPublisher(null);
    }

    public void removeComponents(MyComponentsInterface ...subscribers)
    {
        for(MyComponentsInterface subscriber : subscribers)
        {
            m_myControllers.remove(subscriber);
            subscriber.setPublisher(null);
        }
    }



    public void notifyControllers(Events event)
    {
        for(MyComponentsInterface myController : m_myControllers)
            myController.update(event);
    }

    private ArrayList<MyComponentsInterface> m_myControllers = new ArrayList<>();
}
