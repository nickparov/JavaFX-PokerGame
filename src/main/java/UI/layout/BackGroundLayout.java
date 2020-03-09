package UI.layout;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class BackGroundLayout implements LayoutInterface<StackPane>
{
    BackGroundLayout()
    {
        m_layout = new StackPane();
        m_layout.setBackground(new Background(new BackgroundFill(m_color1, CornerRadii.EMPTY, Insets.EMPTY)));
        isColor1Active = true;
    }

    void switchBackGround()
    {
        if(isColor1Active)
        {
            m_layout.setBackground(new Background(new BackgroundFill(m_color2, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else
        {
            m_layout.setBackground(new Background(new BackgroundFill(m_color1, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        isColor1Active = !isColor1Active;
    }


    @Override
    public StackPane getLayout()
    {
        return m_layout;
    }


    boolean isColor1Active = true;
    Color m_color1 = Color.WHITE;
    Color m_color2 = Color.LIGHTCORAL;

    StackPane m_layout;
}
