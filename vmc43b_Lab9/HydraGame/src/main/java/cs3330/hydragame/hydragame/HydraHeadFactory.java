package cs3330.hydragame.hydragame;
import javafx.scene.image.Image;

public class HydraHeadFactory
{
    private static Image headSize1;
    private static Image headSize2;
    private static Image headSize3;
    private static Image headSize4;
    private static Image headSize5;
    private static Image headSize6;

    private HydraHeadFactory() {
        // Private constructor as noted in UML
    }

    static {
        // Initialize the static images using resource paths
        headSize1 = new Image(HydraHeadFactory.class.getResourceAsStream("/cs3330/hydragame/hydragame/HeadSize1.png"));
        headSize2 = new Image(HydraHeadFactory.class.getResourceAsStream("/cs3330/hydragame/hydragame/HeadSize2.png"));
        headSize3 = new Image(HydraHeadFactory.class.getResourceAsStream("/cs3330/hydragame/hydragame/HeadSize3.png"));
        headSize4 = new Image(HydraHeadFactory.class.getResourceAsStream("/cs3330/hydragame/hydragame/HeadSize4.png"));
        headSize5 = new Image(HydraHeadFactory.class.getResourceAsStream("/cs3330/hydragame/hydragame/HeadSize5.png"));
        headSize6 = new Image(HydraHeadFactory.class.getResourceAsStream("/cs3330/hydragame/hydragame/HeadSize6.png"));
    }

    public static Image getHead(int size)
    {
        // TODO: Return appropriate HydraHead based on size
        if (size == 1)
            return headSize1;
        else if (size == 2)
            return headSize2;
        else if (size == 3)
            return headSize3;
        else if (size == 4)
            return headSize4;
        else if (size == 5)
            return headSize5;
        else if (size == 6)
            return headSize6;
        else return null;
    }
}
