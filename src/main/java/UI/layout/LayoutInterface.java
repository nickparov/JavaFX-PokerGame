package UI.layout;

import javafx.scene.layout.Pane;

interface LayoutInterface {
    <T extends Pane> T getLayout();
}
