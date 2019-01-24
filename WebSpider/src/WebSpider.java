import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.net.URL;

/**
 * WebSpider takes a URL and searches that site for emails and other URLS.
 * The emails are stored in a set, and the URLS are stored in a Hashmap.
 * Every time a new URL is visited, that boolean hashmap value is set to true
 * So the spider doesn't visit the same site twice.
 * @author Madi Binyon
 * @version 1.23.19
 */
public class WebSpider {
  private static Set<String> emails = new HashSet<>();
  private static HashMap<String, Boolean> URLS = new HashMap<>();

  /**
   * The URL WhitworthCS leads the spider to the WU Math and Computer Science faculty directory.
   * A variable count is initialized so every time a new site is added to the Hashmap, count++.
   * The spider will exit after gathering 100 websites in the Hashmap.
   * By using RegEx, the spider searches the sites for the email Pattern and the websites Pattern to add items to emails and URLS respectively.
   * When the spider has gone through every line on the current site, it goes to the next site in the Hashmap that has a boolean value of "false,"
   * sets its value to true, and then crawls through that site to find more emails and urls.  At the end, output all the emails collected.
   */
  public static void main(String[] args) {
    try {
      String WhitworthCS = "https://www.whitworth.edu/academic/faculty/directory/index.aspx?Department=MACS";
      URL url = new URL(WhitworthCS);
      URLS.put(WhitworthCS, true);
      int count = 0;
      while (url != null && count < 100) {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = rdr.readLine();
        while (line != null) {
          Pattern email = Pattern.compile("\"mailto:(.*?)\"");
          Matcher matcher = email.matcher(line);
          if (matcher.find())
            emails.add(matcher.group(1));
          Pattern websites = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
          Matcher siteMatch = websites.matcher(line);
          if (siteMatch.find()) {
            URLS.put(siteMatch.group(1), false);
          }
          line = rdr.readLine();
        }
        Iterator it = URLS.entrySet().iterator();

        while (it.hasNext()) {
          it.next();
          Map.Entry pair = (Map.Entry) it.next();
          System.out.println(pair.getKey() + " = " + pair.getValue());
          if (pair.getValue() == Boolean.FALSE) {
            url = new URL((String) pair.getKey());
            URLS.put((String) pair.getKey(), true);
            break;
          }
        }
        count++;
      }
    } catch (Exception ex) {
      System.out.printf("Oops: %s", ex.getMessage());
    }

    for (String p : emails) {
      System.out.println(p);
    }

  }


}
