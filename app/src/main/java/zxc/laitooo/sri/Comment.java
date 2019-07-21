package zxc.laitooo.sri;

/**
 * Created by Zizo on 2/5/2018.
 */
public class Comment {

    private int Id_post;
    private int Id_user;
    private String Image;
    private String Name;
    private String Date;
    private String Time;
    private String Content;

    public Comment(int id_post, int id_user, String image, String name, String date, String time, String content) {
        Id_post = id_post;
        Id_user = id_user;
        Image = image;
        Name = name;
        Date = date;
        Time = time;
        Content = content;
    }

    public int getId_post() {
        return Id_post;
    }

    public void setId_post(int id_post) {
        Id_post = id_post;
    }

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int id_user) {
        Id_user = id_user;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
