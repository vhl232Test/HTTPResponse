package httpRenponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Util {

    protected int response(String url){
        // Create Object and pass the url
        HttpUriRequest request = new HttpGet(url);
        HttpResponse httpResponse;
        int responseCode = 0;
        // send the response or execute the request
        try {
             httpResponse = HttpClientBuilder.create().build().execute(request);
             responseCode = httpResponse.getStatusLine().getStatusCode();
            // return  responseCode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseCode;
    }
}
