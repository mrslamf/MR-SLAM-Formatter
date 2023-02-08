/*
 * This class is to query the website for the latest version and then
    check against the version of the executing version and if the executing
    version is older, prompt the user to upgrade via the website.
 */
package JavaManifestFormatter;

import static JavaManifestFormatter.JavaManifestFormatter.versionFilePath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *  rev date 02/02/2023 created method
 * @author tcsma
 */
public class checkVersion {
    
    
    
    public static void checkVersion(){
        String[] inputLine = new String[500];
        int counter = 0;


        try {

            URL targetUrl = new URL (versionFilePath); 
              
            BufferedReader read = new BufferedReader(new InputStreamReader(targetUrl.openStream()));

    
            while ((inputLine[counter] = read.readLine()) != null){
                System.out.println("# " + counter + "  " + inputLine[counter]);
                counter++;
            }
            
            read.close();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(checkVersion.class.getName()).log(Level.SEVERE, null, ex);
            utilities.writeToResultsWindow(1, "MalformedURLException " + ex);            
        }
        catch (IOException ex) {
            Logger.getLogger(checkVersion.class.getName()).log(Level.SEVERE, null, ex);
            utilities.writeToResultsWindow(1, "IOException " + ex);
        }
        
        
        
}
}
