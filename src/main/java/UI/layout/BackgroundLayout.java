package UI.layout;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import UI.Constants;

class BackgroundLayout implements LayoutInterface {

    public BackgroundLayout() {
        initializeUIComponents();
    }

    @Override
    public StackPane getLayout() {
        StackPane backgroundLayout = new StackPane();
        backgroundLayout.getChildren().addAll(m_table);

        return backgroundLayout;
    }

    private void initializeUIComponents() {
        m_table = new Rectangle(Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT);
        m_table.setFill(Color.BLACK);
    }

    private Rectangle m_table;
}
