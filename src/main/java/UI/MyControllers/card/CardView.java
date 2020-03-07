package UI.myControllers.card;

import UI.myControllers.Events;
import UI.myControllers.MyControllersInterface;

import UI.myControllers.Publisher;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CardView extends ImageView implements MyControllersInterface {
    public CardView(Card card)
    {
        loadCardImage(card);
        attachEventListeners();
    }

    @Override
    public void update(Events event)
    {
        if(event == Events.FOLD_BUTTON_1_CLICKED)
            flip();
    }

    @Override
    public void attachEventListeners()
    {
        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                flip();
            }
        });


        addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setScaleX(1.1);
                setScaleY(1.1);
            }
        });

        addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.setFitWidth(m_face.getWidth() * CardConstants.OPTIMAL_SCALE_X);
        this.setFitHeight(m_face.getHeight() * CardConstants.OPTIMAL_SCALE_Y);

        m_faceIsActive = false;
        setImage(m_back);
    }

    public void changeCard(Card newCard)
    {
        loadCardImage(newCard);
    }

    private void flip()
    {
        ScaleTransition part1 = new ScaleTransition(Duration.millis(300), this);
        part1.setFromX(1.0);
        part1.setToX(0.15);

        ScaleTransition part2 = new ScaleTransition(Duration.millis(300), this);
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

    private Image m_face = null;
    private Image m_back = null;
    private boolean m_faceIsActive;

    private Publisher m_publisher;
}
