package UI.layout;

import game.ControlFlowContext;
import game.states.MakeBetsState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import static java.lang.System.exit;

public class MenuLayout extends HBox implements LayoutInterface
{
    public MenuLayout(BackGroundLayout backgroundLayout)
    {
        m_backgroundLayout = backgroundLayout;

        m_exitBtn = new Button("Exit");
        m_freshStart = new Button("Fresh Start");
        m_newLook = new Button("New look");

        attachHandlers();

        this.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(10);
        this.getChildren().addAll(m_freshStart, m_newLook, m_exitBtn);

        m_layout = new StackPane(this);
    }



    void attachHandlers()
    {
        m_exitBtn.setOnAction(e -> exit(0));

        m_freshStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControlFlowContext.getInstance().freshStart();
            }
        });

        m_newLook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                m_backgroundLayout.switchBackGround();
            }
        });

    }


    @Override
    public StackPane getLayout()
    {
        m_layout.setPickOnBounds(false);
        return m_layout;
    }


    private Button m_exitBtn;
    private Button m_freshStart;
    private Button m_newLook;

    private BackGroundLayout m_backgroundLayout;

    private StackPane m_layout;
}
