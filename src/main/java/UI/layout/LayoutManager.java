package UI.layout;

import UI.Constants;

import UI.myComponents.MyComponentsManager;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LayoutManager
{
    public LayoutManager(MyComponentsManager myComponentsManager)
    {
        m_backgroundLayout = new BackGroundLayout();
        m_gameFieldLayout = new GameFieldLayout(myComponentsManager);
        m_menuLayout = new MenuLayout(m_backgroundLayout);

        buildFinalLayout();
        buildScene();
    }

    public Scene getScene()
    {
        return m_scene;
    }

    private void buildScene()
    {
        m_scene = new Scene(m_finalLayout, Constants.SCENE_MIN_WIDTH, Constants.SCENE_MIN_HEIGHT);
    }

    private void buildFinalLayout()
    {
        m_finalLayout = new StackPane(m_backgroundLayout.getLayout(), new VBox(new HBox(m_menuLayout.getLayout()), m_gameFieldLayout.getLayout()));
    }

    private Scene m_scene;
    private StackPane m_finalLayout;

    private BackGroundLayout m_backgroundLayout;
    private MenuLayout m_menuLayout;
    private GameFieldLayout m_gameFieldLayout;
}
