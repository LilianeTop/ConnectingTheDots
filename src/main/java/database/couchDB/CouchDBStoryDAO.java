package database.couchDB;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Story;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class CouchDBStoryDAO {
    protected CouchDBAccess couchDBAccess;
    private Gson gson;

    public CouchDBStoryDAO(CouchDBAccess couchDBAccess) {
        super();
        this.couchDBAccess = couchDBAccess;
        gson = new Gson();
    }

    public String saveAStory(Story mpStory) {
        String jstring = gson.toJson(mpStory);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jstring).getAsJsonObject();
        String doc_Id = couchDBAccess.saveDocument(jsonObject);
        return doc_Id;
    }

    //or should it not be a story but a JsonObject?
    public Story getAStoryByDocId(String docId) {
        JsonObject jsonObject = couchDBAccess.getCouchDbClient().find(JsonObject.class, docId);
        Story result = gson.fromJson(jsonObject, Story.class);
        return result;
    }

    public Story updateAStoryByDocId(String docId) {
        //JsonObject jsonObject = couchDBAccess.getCouchDbClient().
        return null;
    }

    private void deleteAStoryByDocId(String docId) {
        Story story = getAStoryByDocId(docId);
        if (docId != null) {
            couchDBAccess.getCouchDbClient().remove(story);
        }
    }

   /* private void deleteAStoryByStoryTeller(String mpStoryteller, String mpStoryTitle) {
        List<Story> storiesByStorytellerList = getStoriesByStoryteller(mpStoryteller);
        for (Story story : storiesByStorytellerList)
            if (story.getTitle().equals(mpStoryTitle)) {
                couchDBAccess.getCouchDbClient().remove(story);
            }
    }*/

   /* private void deleteAllStoriesByStoryteller(String mpStoryteller) {
        List<Story> storiesByStorytellerList = getStoriesByStoryteller(mpStoryteller);
        for (Story story : storiesByStorytellerList)
            couchDBAccess.getCouchDbClient().remove(story);
    }*/


    public List<JsonObject> getAllStories() {
        return couchDBAccess.getCouchDbClient().view("_all_docs").includeDocs(true).query(JsonObject.class);
    }

    /*public List<Story> getAllStoriesByDate(String mpDate) {
        Story result = null;
        List<Story> storiesByDateList = new ArrayList<>();
        for (JsonObject jsonObject : getAllStories()) {
            result = gson.fromJson(jsonObject, Story.class);
            if (result.getDate().equals(mpDate)) {
                storiesByDateList.add(result);
            }
        }
        return storiesByDateList;
    }*/

    /*public List<Story> getAllStoriesBySubject(String mpSubject) {
        Story result = null;
        List<Story> storiesBySubjectList = new ArrayList<>();
        for (JsonObject jsonObject : getAllStories()) {
            result = gson.fromJson(jsonObject, Story.class);
            if (result.getSubject().equals(mpSubject)) {
                storiesBySubjectList.add(result);
            }
        }
        return storiesBySubjectList;
    }*/

    public List<Story> getStoriesByStoryteller(User mpStoryteller) {
        List<Story> result = new ArrayList<>();
        Story tempStory;
        for (JsonObject jsonObject : getAllStories()) {
            if (jsonObject.has("storyTeller")) {
                tempStory = gson.fromJson(jsonObject, Story.class);
                if (tempStory.getStoryTeller().equals(mpStoryteller)) {
                    result.add(tempStory);
                }
            }
        }
        return result;
    }

   /* public List<Story> getAllStoriesByTitle(String mpTitle) {
        Story result = null;
        List<Story> storiesByTitleList = new ArrayList<>();
        for (JsonObject jsonObject : getAllStories()) {
            result = gson.fromJson(jsonObject, Story.class);
            if (result.getTitle().equals(mpTitle)) {
                storiesByTitleList.add(result);
            }
        }
        return storiesByTitleList;
    }*/
}
