package UI.layout;

import UI.Constants;

public interface LayoutConstants
{
    ComponentGroupPosition P1_CARDS_POSITION = new ComponentGroupPosition(10, 10);
    ComponentGroupPosition P2_CARDS_POSITION = new ComponentGroupPosition(600, 10);
    ComponentGroupPosition DEALER_CARDS_POSITION = new ComponentGroupPosition(400, 400);

    ComponentGroupPosition P1_BUTTONS_POSITION = new ComponentGroupPosition(10, 200);
    ComponentGroupPosition P2_BUTTONS_POSITION = new ComponentGroupPosition(600, 200);
    ComponentGroupPosition NEW_ROUND_BUTTON_POSITION = new ComponentGroupPosition(400, 700);

    ComponentGroupPosition P1_TEXT_FIELDS_POSITION = new ComponentGroupPosition(10, 250);
    ComponentGroupPosition P2_TEXT_FIELDS_POSITION = new ComponentGroupPosition(600, 250);

    int CARDS_SPACING = 10;
    int BUTTONS_SPACING = 10;
    int TEXT_FIELDS_SPACING = 10;
}
