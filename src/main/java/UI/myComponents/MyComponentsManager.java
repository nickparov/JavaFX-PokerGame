package UI.myComponents;

import Core.Game.Card.Card;

import Core.Game.Player.PlayerType;
import UI.myComponents.buttons.*;

import UI.myComponents.card.CardView;
import UI.myComponents.labels.TotalWinnings;
import UI.myComponents.textAreas.HistoryTextArea;
import UI.myComponents.textFields.AnteBetTextField;
import UI.myComponents.textFields.PairPlusBetTextField;
import UI.myComponents.textFields.PlayWager;

import java.util.ArrayList;

public class MyComponentsManager
{
    public MyComponentsManager()
    {
        initializeComponents();
        linkComponents();
    }

    public void setHand(ArrayList<Card> newHand, PlayerType playerType)
    {
        if(playerType == PlayerType.PLAYER_1)
            for(int i = 0; i < m_cards_p1.length; i++)
                m_cards_p1[i].changeCard(newHand.get(i));// = new CardView(newHand.get(i), PlayerType.PLAYER_1);

        else if(playerType == PlayerType.PLAYER_2)
            for(int i = 0; i < m_cards_p2.length; i++)
                m_cards_p2[i].changeCard(newHand.get(i));// = new CardView(newHand.get(i), PlayerType.PLAYER_2);

        else if(playerType == PlayerType.DEALER)
            for(int i = 0; i < m_cards_dealer.length; i++)
                m_cards_dealer[i].changeCard(newHand.get(i));// = new CardView(newHand.get(i), PlayerType.DEALER);
    }

    private void initializeComponents()
    {
        for(int i = 0; i < m_cards_p1.length; i++)
            m_cards_p1[i] = new CardView(new Card('C', 13), PlayerType.PLAYER_1);

        for(int i = 0; i < m_cards_p2.length; i++)
            m_cards_p2[i] = new CardView(new Card('C', 13), PlayerType.PLAYER_2);

        for(int i = 0; i < m_cards_dealer.length; i++)
            m_cards_dealer[i] = new CardView(new Card('C', 13), PlayerType.DEALER);
    }

    private void linkComponents()
    {
        m_ControllersManager.addComponents(
                m_fold_p1,
                m_fold_p2,
                m_total_winnings_p1,
                m_play_p1,
                m_play_p2,
                m_total_winnings_p2,
                m_newRoundButton,
                m_make_bets_button,
                m_reveal_cards_button,
                m_dealButton,
                m_anteBet_p1,
                m_anteBet_p2,
                m_pairPlus_p1,
                m_pairPlus_p2,
                m_playWager_p1,
                m_playWager_p2,
                m_history
        );

        m_ControllersManager.addComponents(m_cards_p1);
        m_ControllersManager.addComponents(m_cards_p2);
        m_ControllersManager.addComponents(m_cards_dealer);
    }



    public FoldButton m_fold_p1 = new FoldButton(PlayerType.PLAYER_1);
    public FoldButton m_fold_p2 = new FoldButton(PlayerType.PLAYER_2);
    public TotalWinnings m_total_winnings_p1 = new TotalWinnings(PlayerType.PLAYER_1);
    public TotalWinnings m_total_winnings_p2 = new TotalWinnings(PlayerType.PLAYER_2);

    public PlayButton m_play_p1 = new PlayButton(PlayerType.PLAYER_1);
    public PlayButton m_play_p2 = new PlayButton(PlayerType.PLAYER_2);

    public NewRoundButton m_newRoundButton = new NewRoundButton();
    public MakeBetsButton m_make_bets_button = new MakeBetsButton();
    public DealButton m_dealButton = new DealButton();
    public RevealCardsButton m_reveal_cards_button = new RevealCardsButton();

    public AnteBetTextField m_anteBet_p1 = new AnteBetTextField();
    public AnteBetTextField m_anteBet_p2 = new AnteBetTextField();
    public PlayWager m_playWager_p1 = new PlayWager();
    public PlayWager m_playWager_p2 = new PlayWager();

    public PairPlusBetTextField m_pairPlus_p1 = new PairPlusBetTextField();
    public PairPlusBetTextField m_pairPlus_p2 = new PairPlusBetTextField();

    public HistoryTextArea m_history = new HistoryTextArea();

    public CardView[] m_cards_p1 = new CardView[3];
    public CardView[] m_cards_p2 = new CardView[3];
    public CardView[] m_cards_dealer = new CardView[3];

    public Publisher m_ControllersManager = new Publisher();
}
