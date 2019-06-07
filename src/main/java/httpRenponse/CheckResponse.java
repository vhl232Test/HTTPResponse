package httpRenponse;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class CheckResponse {
    public static void main(String[] args) {

        String url = "http://github.com/";
        String url400 ="https://github.com/testlololo";


        Util util = new Util();
        HtmlElement htmlElement;
        WebClient webClient = new WebClient();

        webClient.getOptions().setCssEnabled(false);// disable css
        webClient.getOptions().setJavaScriptEnabled(false);//disable JavaScript

        System.out.println(util.response(url400));

        if (util.response(url) >= 200 & util.response(url) < 300) {
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
                htmlElement = htmlPage.getFirstByXPath("//h1[@class = 'h000-mktg text-white lh-condensed-ultra mb-3']");
                String textFromH1 = htmlElement.getTextContent();
                System.out.println(textFromH1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (util.response(url)>=100 & util.response(url) < 200 ) {
            System.out.println("Response code 1**. Informational response");
        }
         else if (util.response(url) >= 300 & util.response(url) < 400) {
            System.out.println("Response code 3**. Request is redirect ");
        }
         else if (util.response(url) >= 400 & util.response(url) < 500) {
            System.out.println("Response code 4**. It's clint's error");
        }
         else if (util.response(url)>=500){
            System.out.println("Response code 5**. It's server error");
        }



    }
}
