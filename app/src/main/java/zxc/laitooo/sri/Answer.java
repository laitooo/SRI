package zxc.laitooo.sri;

/**
 * Created by Zizo on 2/5/2018.
 */
public class Answer {

    private int Id;
    private int IdQuestion;
    private int IdUser;
    private String Content;
    private String Date;
    private String Time;
    private String Name;
    private String Image;
    private int Votes;

    public Answer(int id, int idQuestion, int idUser, String content, String date, String time, String name, String image, int votes) {
        Id = id;
        IdQuestion = idQuestion;
        IdUser = idUser;
        Content = content;
        Date = date;
        Time = time;
        Name = name;
        Image = image;
        Votes = votes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdQuestion() {
        return IdQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        IdQuestion = idQuestion;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
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

    public int getVotes() {
        return Votes;
    }

    public void setVotes(int votes) {
        Votes = votes;
    }



}
