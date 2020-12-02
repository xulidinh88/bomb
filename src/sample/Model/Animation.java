package sample.Model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Animation {
    long time;
    int frame = 0;
    long delayFrame = 100;
    Image currentFrame;
    ArrayList<Image> Frame;

    public Animation(){
        Frame = new ArrayList<Image>();
        time = System.currentTimeMillis();
    }

    public void add(Image img)
    {
        Frame.add(img);
        if(Frame.size() > 0) this.currentFrame = Frame.get(0);
    }

    public Image getCurrentFrame(long timeDelayFrame) {
        //todo:
        frame = (int)((System.currentTimeMillis() - time)/timeDelayFrame);
        //System.out.println(frame);
        currentFrame = Frame.get(frame%Frame.size());
        return currentFrame;
    }

    public Image getCurrentFrame()
    {
        frame++;
        currentFrame = Frame.get(frame%Frame.size());
        return currentFrame;
    }
}
