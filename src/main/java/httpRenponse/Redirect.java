package httpRenponse;

public class Redirect {
    public static void main(String[] args) {

        String url = "http://github.com/";
        String url200 = "https://github.com/";
        String url400 = "https://github.com/testlololo";
        Util util = new Util();

        

        System.out.println( util.response(url));
        System.out.println(util.response(url200));
        System.out.println(util.response(url400));

    }


}
