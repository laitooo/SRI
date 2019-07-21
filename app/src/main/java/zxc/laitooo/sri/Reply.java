package zxc.laitooo.sri;

/**
 * Created by Laitooo San on 10/06/2019.
 */

public class Reply {

    private int Id_question;
    private int Id_user;
    private String Content;
    private String Date;
    private String Time;
    private String Name;
    private String Image;

    public Reply(int id_question, int id_user, String content, String date, String time, String name, String image) {
        Id_question = id_question;
        Id_user = id_user;
        Content = content;
        Date = date;
        Time = time;
        Name = name;
        Image = image;
    }

    public int getId_question() {
        return Id_question;
    }

    public void setId_question(int id_question) {
        Id_question = id_question;
    }

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int id_user) {
        Id_user = id_user;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
