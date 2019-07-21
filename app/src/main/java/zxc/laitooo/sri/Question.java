package zxc.laitooo.sri;

/**
 * Created by Zizo on 12/12/2017.
 */
public class Question {

    private int Id;
    private int IdUser;
    private String Image;
    private String Title;
    private String Name;
    private String Date;
    private String Time;
    private String Content;
    private int Votes;
    private String Tags;

    public Question(int id, int idUser, String image, String title, String name, String date,
                    String time, String content, int votes,String tags) {
        Id = id;
        IdUser = idUser;
        Image = image;
        Title = title;
        Name = name;
        Date = date;
        Time = time;
        Content = content;
        Votes = votes;
        Tags = tags;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }
}
