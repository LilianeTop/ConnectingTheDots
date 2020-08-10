package model;

public class Story {
    private int storyID;
    private String title;
    private String subTitle;
    private String subject;
    private String summary;
    private String content;
    private User storyTeller;
    private String date;

    public Story(String title, String subTitle, String subject, String date, String summary, String content, User storyTeller) {
        super();
        //this.storyID = storyID;
        this.title = title;
        this.subTitle = subTitle;
        this.subject = subject;
        this.summary = summary;
        this.content = content;
        this.storyTeller = storyTeller;
        this.date = date;
    }

    /*public Story(int storyID, String title, String subTitle, String subject, String date, String summary, String content, User storyTeller) {
        super();
        this.storyID = storyID;
        this.title = title;
        this.subTitle = subTitle;
        this.subject = subject;
        this.summary = summary;
        this.content = content;
        this.storyTeller = storyTeller;
        this.date = date;
    }

    //constructor without ID for DAO CouchDB must create an ID and publishing date
    public Story(String title, String subTitle, String subject, String date, String summary, String content, User storyTeller) {
        this(0, title, subTitle, subject, date, summary, content, storyTeller);
    }*/



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getStoryTeller() {
        return storyTeller;
    }

    public void setStoryTeller(User storyTeller) {
        this.storyTeller = storyTeller;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder("");
        resultString.append(title + " ");
        resultString.append("story by " + storyTeller.getFirstName() + " " + storyTeller.getLastName());
        return resultString.toString();
    }


}
