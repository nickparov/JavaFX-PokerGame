package UI.layout;

import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IntermediateLayout implements LayoutInterface {
    public IntermediateLayout() {
        initializeUIComponents();
    }


    @Override
    public BorderPane getLayout() {
        return null;
    }

    private void initializeUIComponents() {
        m_startRound = new Button("Start The Round");
        m_fold1 = new Button("Fold");
        m_fold2 = new Button("Fold");
        m_play1 = new Button("Play");
        m_play2 = new Button("Play");
    }

    private Button m_startRound;
    private Button m_fold1;
    private Button m_fold2;
    private Button m_play1;
    private Button m_play2;
}
