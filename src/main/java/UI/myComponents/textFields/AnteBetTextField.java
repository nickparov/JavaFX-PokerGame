package UI.myComponents.textFields;

import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;
import UI.myComponents.Publisher;
import javafx.beans.InvalidationListener;
import javafx.scene.control.TextField;

public class AnteBetTextField extends TextField implements MyComponentsInterface
{
    public AnteBetTextField()
    {
        setPromptText("ante bet");
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

    void setEventListeners()
    {
        textProperty().addListener((observable, oldValue, newValue ) -> {
            // TODO
        });

    }

    private Publisher m_publisher;
}
