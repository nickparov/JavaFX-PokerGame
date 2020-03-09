package UI.myComponents.textFields;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import UI.myComponents.textAreas.HistoryTextArea;
import javafx.scene.control.TextField;

public class AnteBetTextField extends TextField implements MyComponentsInterface
{
    public AnteBetTextField()
    {
        setPromptText("ante wager");
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


    public boolean isTextValid(HistoryTextArea histoty)
    {
        String text = getText();

        if(text.isEmpty())
        {
            histoty.prependText("All ante wagers must be set\n");
            return false;
        }

        int number;
        try
        {
            number = Integer.parseInt(text);
        }
        catch (NumberFormatException nfe)
        {
            histoty.prependText("All wagers must be numbers\n");
            return false;
        }

        if(number < 5 || number > 25) {
            histoty.prependText("Wagers must be between 5 and 25\n");
            return false;
        }

        return true;
    }

    // Assumed to be called after check
    public int getInt()
    {
        return Integer.parseInt(getText());
    }

    private Publisher m_publisher;
}
