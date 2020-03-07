package game;


import Core.Game.Dealer;


public class ControlFlow
{
    public void startRound()
    {
        m_dealer.DealHand();
    }

    private Dealer m_dealer = new Dealer();
}
