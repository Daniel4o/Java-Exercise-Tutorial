import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");
            URI baseUri = new URI("http://username:password@myserver.com:5000");

            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            URI relativizedURI = baseUri.relativize(resolvedUri2);
            System.out.println("Relative URI = " + relativizedURI);

            // Relative URI

            // Scheme:  The part that occurs before the colon (:) in the URI
            System.out.println("Scheme = " + uri.getScheme());
            // Scheme-specific part: Identifier for the resource that you want to use
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            // Authority: Contains the host or optionally the password and port number
            System.out.println("Authority = " + uri.getAuthority());
            // User info: Contains the username and password (any credentials required to access the resource)
            System.out.println("User info = " + uri.getUserInfo());
            // Host: Contains hostname or ipv4/ipv6
            System.out.println("Host = " + uri.getHost());
            // Port: Contains port number
            System.out.println("Port = " + uri.getPort());
            // Path: Contains the path to the resource on the host
            System.out.println("Path = " + uri.getPath());
            // Query: Separated from the part that comes before it by a ? (often is a set of key value pairs)
            System.out.println("Query = " + uri.getQuery());
            // Fragment: Specifies a secondary resource or location
            System.out.println("Fragment = " + uri.getFragment());

            URL url = uri.toURL();
            System.out.println("URL = " + url);

            URL url1 = resolvedUri1.toURL();
            System.out.println(" URL 1 = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println(" URL 2 = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println(" URL 3 = " + url3);


        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        }
    }

}
 class Main2 {
        public static void main (String[]args){
            try {
                URL url = new URL("http://example.org");
                URLConnection urlConnection = url.openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.connect();

                BufferedReader inputStream = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream()));

                String line ="";
                while(line != null) {
                    line = inputStream.readLine();
                    System.out.println(line);
                }
                inputStream.close();

            } catch(MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
            } catch(IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }