package UI.myControllers.card;

import UI.myControllers.MyControllersInterface;

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
        setOptimalScale();
        attachHandlers();
    }

    public void changeCard(Card newCard)
    {
       loadCardImage(newCard);
    }

    public void loadCardImage(Card card)
    {
        try {
            m_face = new Image(new FileInputStream(CardDatabase.getInstance().getCardFileName(card)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        m_faceIsActive = true;
        setImage(m_face);

        try {
            m_back = new Image(new FileInputStream("src/res/Cards/13C.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void attachHandlers()
    {
        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("Tile pressed ");
                flip();
                event.consume();
            }
            });
    }

    private void setOptimalScale()
    {
        setScaleX(CardConstants.OPTIMAL_SCALE_X);
        setScaleY(CardConstants.OPTIMAL_SCALE_Y);
    }

    private void flip()
    {
        ScaleTransition part1 = new ScaleTransition(Duration.millis(300), this);
        part1.setFromX(CardConstants.OPTIMAL_SCALE_X);
        part1.setToX(CardConstants.OPTIMAL_SCALE_X * 0.15);

        ScaleTransition part2 = new ScaleTransition(Duration.millis(300), this);
        part2.setFromX(CardConstants.OPTIMAL_SCALE_X * 0.15);
        part2.setToX(CardConstants.OPTIMAL_SCALE_X);

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
}
