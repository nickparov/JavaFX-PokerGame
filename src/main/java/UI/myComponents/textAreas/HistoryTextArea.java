package UI.myComponents.textAreas;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

public class HistoryTextArea extends TextArea implements MyComponentsInterface
{
    public HistoryTextArea()
    {
        setMaxSize(200, 880);
        setEditable(false);
        setWrapText(true);
    }


    public void prependText(String newText)
    {
        String curText = getText();
        clear();
        appendText(newText + curText);
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
