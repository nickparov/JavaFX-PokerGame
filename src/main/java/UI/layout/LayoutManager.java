package UI.layout;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class LayoutManager implements LayoutInterface {

    public LayoutManager() {
        initializeLayouts();
    }

    @Override
    public StackPane getLayout() {
        StackPane finalLayout = new StackPane();
        finalLayout.getChildren().addAll(m_intermediateLayout.getLayout());
        return finalLayout;
    }


    private void initializeLayouts()
    {
        m_intermediateLayout = new IntermediateLayout();
        m_backgroundLayout = new BackgroundLayout();
    }

    private IntermediateLayout m_intermediateLayout;
    private BackgroundLayout m_backgroundLayout;
}
