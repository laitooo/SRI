package zxc.laitooo.sri;

/**
 * Created by Zizo on 12/29/2017.
 */
public class Publications {

    private String PublicationTitle;
    private String PublicationAuthors;
    private String PublicationPublisher;
    private String PublicationDate;

    public Publications(String title,String authors,String publishers,String date){
        this.PublicationTitle = title;
        this.PublicationAuthors = authors;
        this.PublicationPublisher = publishers;
        this.PublicationDate = date;
    }

    public String getPublicationTitle() {
        return PublicationTitle;
    }

    public String getPublicationAuthors() {
        return PublicationAuthors;
    }

    public String getPublicationPublisher() {
        return PublicationPublisher;
    }

    public String getPublicationDate() {
        return PublicationDate;
    }

    public void setPublicationTitle(String publicationTitle) {
        PublicationTitle = publicationTitle;
    }

    public void setPublicationAuthors(String publicationAuthors) {
        PublicationAuthors = publicationAuthors;
    }

    public void setPublicationPublisher(String publicationPublisher) {
        PublicationPublisher = publicationPublisher;
    }

    public void setPublicationDate(String publicationDate) {
        PublicationDate = publicationDate;
    }
}
