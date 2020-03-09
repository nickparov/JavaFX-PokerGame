package UI.myComponents.textFields;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import javafx.scene.control.TextField;

public class PlayWager extends TextField implements MyComponentsInterface
{
    public PlayWager()
    {
        setPromptText("play wager");
        setMaxWidth(getPromptText().length() * 9);

        setEditable(false);
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

    // Assumed the text is an integer
    public int getInt()
    {
        if(getText().isEmpty())
            return 0;

        return Integer.parseInt(getText());
    }



    private Publisher m_publisher;
}
