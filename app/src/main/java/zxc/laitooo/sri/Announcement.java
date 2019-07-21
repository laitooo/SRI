package zxc.laitooo.sri;

/**
 * Created by Zizo on 12/9/2017.
 */
public class Announcement {

    private String AnnouncementTitle;
    private String AnnouncementTime;
    private String AnnouncementContent;

    public Announcement(String title,String time,String content){
        this.AnnouncementTitle = title;
        this.AnnouncementTime = time;
        this.AnnouncementContent = content;
    }

    public String getAnnouncementTitle(){
        return this.AnnouncementTitle;
    }

    public String getAnnouncementTime(){
        return this.AnnouncementTime;
    }

    public String getAnnouncementContent(){
        return this.AnnouncementContent;
    }

    public void setAnnouncementTitle(String title){
        this.AnnouncementTitle = title;
    }

    public void setAnnouncementTime(String time){
        this.AnnouncementTitle = time;
    }

    public void setAnnouncementContent(String content){
        this.AnnouncementTitle = content;
    }

}
