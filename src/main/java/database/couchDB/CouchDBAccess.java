package database.couchDB;

import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.Response;

public class CouchDBAccess {
    private CouchDbClient couchDbClient;

    public void setUpConnection() {
        CouchDbProperties properties = new CouchDbProperties();
        properties.setDbName("connecting_the_dots");
        properties.setCreateDbIfNotExist(true);
        properties.setHost("localhost");
        properties.setPort(5984);
        properties.setProtocol("http");
        properties.setUsername("admin");
        properties.setPassword("Toppertje");

        couchDbClient = new CouchDbClient(properties);
    }
    public CouchDbClient getCouchDbClient() {
        setUpConnection();
        return couchDbClient;
    }

    public String saveDocument(JsonObject mpDocument){
        setUpConnection();
        Response response = couchDbClient.save(mpDocument);
        return response.getId();
    }

    public String updateDocument(JsonObject mpDocument){
        Response response = couchDbClient.update(mpDocument);
        return response.getId();
    }

    public String deleteDocument(JsonObject mpDocument){
        Response response = couchDbClient.remove(mpDocument);
        return response.getId();
    }
}
