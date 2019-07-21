package zxc.laitooo.sri;

/**
 * Created by Zizo on 12/15/2017.
 */
public class Webinars {

    private String videoName;
    private String videoDate;
    private int videoImage;
    private String videoInfo;

    public Webinars(String name,String date,int image,String info){
        this.videoName = name;
        this.videoDate = date;
        this.videoImage = image;
        this.videoInfo = info;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoDate() {
        return videoDate;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public String getVideoInfo() {
        return videoInfo;
    }


    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setVideoDate(String videoDate) {
        this.videoDate = videoDate;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }

    public void setVideoInfo(String videoInfo) {
        this.videoInfo = videoInfo;
    }
}
