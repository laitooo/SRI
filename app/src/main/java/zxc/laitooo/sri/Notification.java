package zxc.laitooo.sri;

/**
 * Created by Zizo on 12/11/2017.
 */
public class Notification {

    private int Image;
    private String Content;

    public Notification(int image,String content){
        this.Image = image;
        this.Content = content;
    }

    public int getImage() {
        return Image;
    }

    public String getContent() {
        return Content;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setContent(String content) {
        Content = content;
    }
}
