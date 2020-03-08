package UI.myComponents.textFields;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import javafx.scene.control.TextField;

public class PairPlusBetTextField extends TextField implements MyComponentsInterface
{
    public PairPlusBetTextField()
    {
        setPromptText("pair plus wager");
        setMaxWidth(getPromptText().length() * 9);
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

    private Publisher m_publisher;
}
