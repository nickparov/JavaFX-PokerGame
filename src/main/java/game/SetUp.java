package game;

import UI.layout.LayoutManager;
import UI.myComponents.MyComponentsManager;
import javafx.scene.Scene;

public class SetUp
{
    public SetUp()
    {
        m_layoutManager = new LayoutManager(m_componentsController);
    }

    public Scene getScene()
    {
        return m_layoutManager.getScene();
    }

    private MyComponentsManager m_componentsController = new MyComponentsManager();
    private LayoutManager m_layoutManager;
}
