package UI.myComponents;

import Core.Game.Card.Card;

import UI.myComponents.buttons.FoldButton;
import UI.myComponents.buttons.NewRoundButton;
import UI.myComponents.buttons.PlayButton;
//import UI.myComponents.card.Card;
import UI.myComponents.card.CardView;
import UI.myComponents.textFields.AnteBetTextField;
import UI.myComponents.textFields.PairPlusBetTextField;

public class MyComponentsManager
{
    public MyComponentsManager()
    {
        initializeComponents();
        linkComponents();
    }

    private void initializeComponents()
    {
        for(int i = 0; i < m_cards_p1.length; i++)
            m_cards_p1[i] = new CardView(new Card('C', 13));

        for(int i = 0; i < m_cards_p2.length; i++)
            m_cards_p2[i] = new CardView(new Card('C', 13));

        for(int i = 0; i < m_cards_dealer.length; i++)
            m_cards_dealer[i] = new CardView(new Card('C', 13));
    }

    private void linkComponents()
    {
        m_ControllersManager.addComponents(
                m_fold_p1,
                m_fold_p2,
                m_play_p1,
                m_play_p2,
                m_anteBet_p1,
                m_anteBet_p2,
                m_pairPlus_p1,
                m_pairPlus_p2
        );

        m_ControllersManager.addComponents(m_cards_p1);
        m_ControllersManager.addComponents(m_cards_p2);
        m_ControllersManager.addComponents(m_cards_dealer);
    }



    public FoldButton m_fold_p1 = new FoldButton();
    public FoldButton m_fold_p2 = new FoldButton();

    public PlayButton m_play_p1 = new PlayButton();
    public PlayButton m_play_p2 = new PlayButton();

    public NewRoundButton m_newRoundButton = new NewRoundButton();

    public AnteBetTextField m_anteBet_p1 = new AnteBetTextField();
    public AnteBetTextField m_anteBet_p2 = new AnteBetTextField();

    public PairPlusBetTextField m_pairPlus_p1 = new PairPlusBetTextField();
    public PairPlusBetTextField m_pairPlus_p2 = new PairPlusBetTextField();

    public CardView[] m_cards_p1 = new CardView[3];
    public CardView[] m_cards_p2 = new CardView[3];
    public CardView[] m_cards_dealer = new CardView[3];

    public Publisher m_ControllersManager = new Publisher();
}
