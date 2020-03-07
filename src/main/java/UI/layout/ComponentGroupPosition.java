package UI.layout;

import javafx.geometry.Insets;

// In layout padding are used for positioning the UI components

class ComponentGroupPosition
{
    ComponentGroupPosition(int x, int y)
    {
        m_ins = new Insets(y, 0, 0, x);
    }

    Insets getPos()
    {
        return m_ins;
    }

    private Insets m_ins;
}
