import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
        
public class Search {

  private String keyword;
  private boolean searchForSubString;

  private void preprocessKeyword() {
    /* Remove single quotes only on word boundary */
    keyword = keyword.replaceAll("' | '", " ");
    keyword = keyword.replaceAll("^'|'$", "");
    if(!searchForSubString) {
      keyword = keyword.replaceAll("\"'|'\"", "\"");
    }
    keyword = keyword.replaceAll("[^\'a-zA-Z0-9 ]", "");
  }

  private String preprocessText(String text) {
    /* Remove single quotes only on word boundary */
    text = text.replaceAll("' | '", " ");
    text = text.replaceAll("^'|'$", "");
    text = text.replaceAll("[^'a-zA-Z0-9 ]", "");

    return text;
  }

  private boolean findKeyword(String text) {
    /* Preprocess text */
    text = preprocessText(text);
  
    /* Case-Insensitive comparison */
    if (searchForSubString) {
      if (text.toLowerCase().contains(keyword.toLowerCase())) {
        return true;
      }
    } else {
      /* 
       * Enforcing word boundary on keyword if input keyword is enclosed in double quotes
       * i.e., searchForSubString is set to false 
       */
      text = " " + text + " ";
      if (text.toLowerCase().contains(" " + keyword.toLowerCase() + " ")) {
        return true;
      }  
    }
    return false;
  }

  /* For Junit Test purpose */
  /* Search for word in text */
  public boolean test(String text, String word) {
    if (word.startsWith("\"") && word.endsWith("\"")) {
        searchForSubString = false;
      } else {
        searchForSubString = true;
      }

    /* Preprocess keyword */
    keyword = word;
    preprocessKeyword();

    /* Search for keyword in the text */
    return findKeyword(text);
  }

  private void search(String filename, String word) throws FileNotFoundException {
    File file = new File(filename);
    Scanner sc = new Scanner(file);
    /* Using '. ' as delimiter */
    sc.useDelimiter("\\. |\\n");

    /* 
     * If the given keyword is enclosed in double quotes, then the user
     * wants exact keyword match, not substring matches. Thus,
     * set searchForSubString to false
     */
    keyword = word;
    if (keyword.startsWith("\"") && keyword.endsWith("\"")) {
      searchForSubString = false;
    } else {
      searchForSubString = true;
    }

    /* Preprocess keyword */
    preprocessKeyword();
    
    boolean matchFoundAtleastOnce = false;

    while (sc.hasNext()) {
      String text = sc.next();

      /* Search for keyword in the text */
      if (findKeyword(text)) {
        if (!matchFoundAtleastOnce) {
          matchFoundAtleastOnce = true;
        }
        System.out.println(text);
      }
    }

    if (!matchFoundAtleastOnce) {
      System.out.println("No results found");
    }
    sc.close();
  }

  public static void main(String[] args) throws FileNotFoundException {
    if (args.length != 2) {
      System.err.println("Expecting filepath and search keyword as input via commandline");
      return; 
    }

    Search searchObj = new Search();
    searchObj.search(args[0],args[1]);

  }   
}
