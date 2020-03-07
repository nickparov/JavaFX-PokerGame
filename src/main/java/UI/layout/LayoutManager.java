package UI.layout;

import UI.Constants;

import UI.myComponents.MyComponentsManager;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class LayoutManager
{
    public LayoutManager(MyComponentsManager myComponentsManager)
    {
        m_gameFieldLayout = new GameFieldLayout(myComponentsManager);

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
        m_finalLayout = new StackPane(m_gameFieldLayout.getLayout());
    }

    private Scene m_scene;
    private StackPane m_finalLayout;

    private GameFieldLayout m_gameFieldLayout;
}
