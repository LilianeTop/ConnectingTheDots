package database.couchDB;

import model.Story;
import org.junit.jupiter.api.Test;

import java.util.List;

class CouchDBStoryDAOTest {
    CouchDBAccess couchDBAccess = new CouchDBAccess();
    CouchDBStoryDAO couchDBStoryDAO = new CouchDBStoryDAO(couchDBAccess);
    public static List<Story> storyTestList;

    @Test
    void saveAStory() {

    }

    @Test
    void getAStoryByDocId() {
    }

    @Test
    void updateAStoryByDocId() {
    }

    @Test
    void getAllStories() {
    }

    @Test
    void getAllStoriesByDate() {
    }

    @Test
    void getAllStoriesBySubject() {
    }

    @Test
    void getAllStoriesByStoryteller() {
    }

    @Test
    void getAllStoriesByTitle() {
    }
}