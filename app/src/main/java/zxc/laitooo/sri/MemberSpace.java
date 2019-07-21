package zxc.laitooo.sri;

/**
 * Created by Zizo on 12/10/2017.
 */
public class MemberSpace {

    private int Id;
    private int IdUser;
    private String MemberImage;
    //private String PostTitle;
    private String MemberName;
    private String PostDate;
    private String PostTime;
    private String PostContent;
    private int PostViews;

    public MemberSpace(int id, int idUser, String memberImage,// String postTitle,
                       String memberName,
                       String postDate, String postTime, String postContent, int postViews) {
        Id = id;
        IdUser = idUser;
        MemberImage = memberImage;
        //PostTitle = postTitle;
        MemberName = memberName;
        PostDate = postDate;
        PostTime = postTime;
        PostContent = postContent;
        PostViews = postViews;
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

    public String getMemberImage() {
        return MemberImage;
    }

    public void setMemberImage(String memberImage) {
        MemberImage = memberImage;
    }

    /*public String getPostTitle() {
        return PostTitle;
    }

    public void setPostTitle(String postTitle) {
        PostTitle = postTitle;
    }*/

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public String getPostTime() {
        return PostTime;
    }

    public void setPostTime(String postTime) {
        PostTime = postTime;
    }

    public String getPostContent() {
        return PostContent;
    }

    public void setPostContent(String postContent) {
        PostContent = postContent;
    }

    public int getPostViews() {
        return PostViews;
    }

    public void setPostViews(int postViews) {
        PostViews = postViews;
    }
}
