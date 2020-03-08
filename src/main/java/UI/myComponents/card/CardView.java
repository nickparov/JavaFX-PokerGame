package UI.myComponents.card;

import Core.Game.Card.Card;

import Core.Game.Player.PlayerType;
import UI.myComponents.Events;
import UI.myComponents.MyComponentsInterface;

import UI.myComponents.Publisher;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CardView extends ImageView implements MyComponentsInterface {
    public CardView(Card card, PlayerType playerType)
    {
        m_card = card;

        m_playerType = playerType;

        loadCardImage(card);
        attachEventListeners();
    }

    @Override
    public void update(Events event)
    {
        if(event == Events.FOLD_BUTTON_1_CLICKED && m_playerType == PlayerType.PLAYER_1)
        {
            m_cardFolded = true;
            shrinkCard();
        }
        else if(event == Events.FOLD_BUTTON_2_CLICKED && m_playerType == PlayerType.PLAYER_2)
        {
            m_cardFolded = true;
            shrinkCard();
        }
        else if(event == Events.NEW_ROUND_BUTTON_CLICKED)
        {
            m_cardFolded = false;

        }
    }

    @Override
    public void attachEventListeners()
    {
       addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(m_cardFolded == true) return;
                flip();
            }
        });


        addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(m_cardFolded == true) return;
                setScaleX(1.1);
                setScaleY(1.1);
            }
        });

        addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(m_cardFolded == true) return;
                setScaleX(1.0);
                setScaleY(1.0);
            }
        });
    }

    @Override
    public void setPublisher(Publisher publisher)
    {
        m_publisher = publisher;
    }


    public void loadCardImage(Card card)
    {
        try {
            m_face = new Image(new FileInputStream(CardDatabase.getInstance().getCardFileName(card)));
            m_back = new Image(new FileInputStream("src/res/Cards/14C.png"));
            //m_back = new Image(new FileInputStream(CardDatabase.getInstance().getCardFileName(new Card('S', 13))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.setFitWidth(m_face.getWidth() * CardConstants.OPTIMAL_SCALE_X);
        this.setFitHeight(m_face.getHeight() * CardConstants.OPTIMAL_SCALE_Y);

        m_faceIsActive = false;
        setImage(m_back);
    }


    public Card getCard()
    {
        return m_card;
    }

    public void changeCard(Card newCard)
    {
        m_card = newCard;
        loadCardImage(newCard);
    }

    public void flip()
    {
        ScaleTransition part1 = new ScaleTransition(Duration.millis(CardConstants.FLIP_ANIMATION_TIME / 2), this);
        part1.setFromX(1.0);
        part1.setToX(0.15);

        ScaleTransition part2 = new ScaleTransition(Duration.millis(CardConstants.FLIP_ANIMATION_TIME / 2), this);
        part2.setFromX(0.15);
        part2.setToX(1.0);

        part1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if ((m_faceIsActive == true)) {
                    setImage(m_back);
                    m_faceIsActive = false;
                } else {
                    setImage(m_face);
                    m_faceIsActive = true;
                }
                part2.play();
            }
        });

        part1.play();
    }

    private void shrinkCard()
    {
        setScaleX(0.8);
        setScaleY(0.8);
    }

    private void normalizeCard()
    {
        setScaleX(1.0);
        setScaleY(1.0);
    }

    private Card m_card;

    private Image m_face = null;
    private Image m_back = null;
    private boolean m_faceIsActive;

    private boolean m_cardFolded = false;

    private PlayerType m_playerType;

    private Publisher m_publisher;
}
