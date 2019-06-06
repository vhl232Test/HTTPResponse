package httpRenponse;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class CheckResponse {
    public static void main(String[] args) {

        String url = "http://github.com/";

        Util util = new Util();
        HtmlElement htmlElement;
        WebClient webClient = new WebClient();

        webClient.getOptions().setCssEnabled(false);// enable css
        webClient.getOptions().setJavaScriptEnabled(false);//enable JavaScript

        System.out.println( util.response(url));

        if(util.response(url)>=200 || util.response(url) <300){
            try {
                HtmlPage htmlPage = webClient.getPage(url);//set url
                //get title
                String title = htmlPage.getTitleText();
                System.out.println(title);

                //get meta-description
                htmlElement = htmlPage.getFirstByXPath("//meta[@name = 'description']");
                String mataDescrip = htmlElement.getAttribute("content");
                System.out.println(mataDescrip);


                // get text from H1
                htmlElement =  htmlPage.getFirstByXPath("//h1[@class = 'h000-mktg text-white lh-condensed-ultra mb-3']");
                String textFromH1 = htmlElement.getTextContent();
                System.out.println(textFromH1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (util.response(url)>= 300 || util.response(url)<400){
            System.out.println("request is redirect ");
        }
        else if (util.response(url)>=400){
            System.out.println();
        }

    }


}
