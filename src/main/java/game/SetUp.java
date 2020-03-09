package game;

import UI.layout.LayoutManager;
import UI.myComponents.MyComponentsManager;
import game.states.MakeBetsState;
import javafx.scene.Scene;

public class SetUp
{
    public SetUp()
    {
        m_layoutManager = new LayoutManager(m_componentsManager);
        //ControlFlow.getInstance().setComponentManager(m_componentsManager);
        ControlFlowContext.getInstance().setComponentManager(m_componentsManager);
        ControlFlowContext.getInstance().changeState(new MakeBetsState());
    }

    public Scene getScene()
    {
        return m_layoutManager.getScene();
    }

    private MyComponentsManager m_componentsManager = new MyComponentsManager();
    private LayoutManager m_layoutManager;
}
