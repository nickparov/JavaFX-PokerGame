package game.states;

import game.ControlFlowContext;

abstract public class GameState <T>
{
    abstract public void processState(T ...args);

    abstract public void startState();
    abstract void finishState();

    abstract void gotoNextState();
}
