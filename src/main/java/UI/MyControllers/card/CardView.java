package UI.myControllers.card;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CardView extends ImageView {
    public CardView(Card card)
    {
        loadCardImage(card);
        setOptimalScale();
    }

    public void loadCardImage(Card card)
    {
        Image img = null;
        try {
            img = new Image(new FileInputStream(CardDatabase.getInstance().getCardFileName(card)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setImage(img);
    }

    private void setOptimalScale()
    {
        setScaleX(CardConstants.OPTIMAL_SCALE_X);
        setScaleY(CardConstants.OPTIMAL_SCALE_Y);
    }
}
