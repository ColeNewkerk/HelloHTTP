import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class HTTPUtils {

    HttpRequestFactory requestFactory;
    String baseURL = "https://todoserver222.herokuapp.com/";
    String todosURL = baseURL + "todos/";

    public HTTPUtils() {
        requestFactory = new NetHttpTransport().createRequestFactory();
    }

    /**
     * @param id
     * @return JSON string of the todoItem with id
     * @throws IOException
     */
    public String getTodoItemJsonString(int id) throws IOException {

        // TODO
        HttpRequest getRequest = requestFactory.buildGetRequest(
                new GenericUrl("https://todoserver222.herokuapp.com/todos/1"));
        String rawResponse = getRequest.execute().parseAsString();
        return rawResponse;
    }


    /**
     * @param note  whatever should be in the todoItem
     * @param owner whoever is the owner of the todoItem
     * @return the ID of the recently added todoItem
     * @throws IOException
     */
    public int addTodoItem(String note, String owner) throws IOException {
        // TODO
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("title", "HelloPostRequest");
        data.put("owner", "hergin");
        HttpContent content = new UrlEncodedContent(data);
        HttpRequest postRequest = requestFactory.buildPostRequest(
                new GenericUrl("https://todoserver222.herokuapp.com/todos"),content);
        String rawResponse = postRequest.execute().parseAsString();
        int id = rawResponse.getInt("id");
        return id;


    }

    /**
     * @param id of the todoItem to delete
     * @return true if succesfully deleted. Otherwise false.
     * @throws IOException
     */
    public boolean deleteTodoItem(int id) throws IOException {
        // TODO
        HttpRequest deleteRequest = requestFactory.buildDeleteRequest(
                new GenericUrl("https://todoserver222.herokuapp.com/todos/3"));
        String rawResponse = deleteRequest.execute().parseAsString();
       if(rawResponse == ""){
           return true;
       }
       else{
           return false;
       }

    }

}
