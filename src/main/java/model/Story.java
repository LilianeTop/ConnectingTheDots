package model;

public class Story {
    private int storyID;
    private String title;
    private String subTitle;
    private String summary;
    private String content;
    private User storyTeller;

    public Story(int storyID, String title, String subTitle, String summary, String content, User storyTeller) {
        super();
        this.storyID = storyID;
        this.title = title;
        this.subTitle = subTitle;
        this.summary = summary;
        this.content = content;
        this.storyTeller = storyTeller;
    }

    //constructor without ID for DAO
    public Story(String title, String subTitle, String summary, String content, User storyTeller) {
        this(0, title,subTitle, summary, content, storyTeller);
    }

    public int getStoryID() {
        return storyID;
    }

    public void setStoryID(int storyID) {
        this.storyID = storyID;
    }

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

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder("");
        resultString.append(storyID + " ");
        resultString.append(title + " ");
        resultString.append("story by " + storyTeller.getLastName());
        return resultString.toString();
    }
}
