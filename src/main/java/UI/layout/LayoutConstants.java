package UI.layout;

import UI.Constants;

public interface LayoutConstants
{
    ComponentGroupPosition P1_CARDS_POSITION = new ComponentGroupPosition(250, 10);
    ComponentGroupPosition P2_CARDS_POSITION = new ComponentGroupPosition(800, 10);
    ComponentGroupPosition DEALER_CARDS_POSITION = new ComponentGroupPosition(250, 400);

    ComponentGroupPosition P1_BUTTONS_POSITION = new ComponentGroupPosition(250, 200);
    ComponentGroupPosition P2_BUTTONS_POSITION = new ComponentGroupPosition(800, 200);

    ComponentGroupPosition P1_TEXT_FIELDS_POSITION = new ComponentGroupPosition(250, 250);
    ComponentGroupPosition P2_TEXT_FIELDS_POSITION = new ComponentGroupPosition(800, 250);

    ComponentGroupPosition MAKE_BETS_BUTTON_POSITION = new ComponentGroupPosition(250, 590);
    ComponentGroupPosition DEAL_CARDS_BUTTON_POSITION = new ComponentGroupPosition(400, 590);
    ComponentGroupPosition NEW_ROUND_BUTTON_POSITION = new ComponentGroupPosition(550, 590);

    ComponentGroupPosition HISTORY_AREA = new ComponentGroupPosition(10, 10);

    int CARDS_SPACING = 10;
    int BUTTONS_SPACING = 10;
    int TEXT_FIELDS_SPACING = 10;

    int NO_SPACING = 0;
}
