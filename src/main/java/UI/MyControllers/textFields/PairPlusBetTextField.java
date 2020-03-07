package UI.myControllers.textFields;

import UI.myControllers.Events;
import UI.myControllers.MyControllersInterface;
import UI.myControllers.Publisher;
import javafx.scene.control.TextField;

public class PairPlusBetTextField extends TextField implements MyControllersInterface
{
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

    private Publisher m_publisher;
}
