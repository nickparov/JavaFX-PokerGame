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
        finalLayout.getChildren().addAll(m_backgroundLayout.getLayout());
        return finalLayout;
    }


    private void initializeLayouts() {
        m_backgroundLayout = new BackgroundLayout();
    }

    private BackgroundLayout m_backgroundLayout;
}
