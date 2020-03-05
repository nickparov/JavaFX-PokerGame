package UI.layout;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class BackgroundLayout implements LayoutInterface {

    public BackgroundLayout() {
        initializeUIComponents();
    }

    @Override
    public HBox getLayout() {
        HBox backgroundLayout = new HBox();
        backgroundLayout.setAlignment(Pos.CENTER);
        backgroundLayout.getChildren().addAll(m_table);

        return backgroundLayout;
    }

    private void initializeUIComponents() {
        m_table = new Rectangle(400, 400);
        m_table.setFill(Color.BLACK);
    }

    private Rectangle m_table;
}
