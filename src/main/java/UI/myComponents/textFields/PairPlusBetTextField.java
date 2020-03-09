package UI.myComponents.textFields;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import UI.myComponents.textAreas.HistoryTextArea;
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


    public boolean isTextValid(HistoryTextArea histoty)
    {
        String text = getText();

        if(text.isEmpty())
        {
            return true;
        }

        int number;
        try
        {
            number = Integer.parseInt(text);
        }
        catch (NumberFormatException nfe)
        {
            histoty.prependText("All wagers must be numbersS\n");
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
        if(getText().isEmpty())
            return 0;

        return Integer.parseInt(getText());
    }

    private Publisher m_publisher;
}
