package insanebikesteam.insanebikes;

import insanebikesteam.insanebikes.Bike;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.ws.rs.core.UriBuilder;
import org.apache.commons.io.IOUtils;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class ChargeCreditCardHandler implements java.io.Serializable, WorkItemHandler
{
    
    static final int PIN_MIN_VALUE_2 = 1;
    static final int PIN_MAX_VALUE_2 = 10;

   public void abortWorkItem(WorkItem workItem, WorkItemManager manager)
   {
   }

   public void executeWorkItem(WorkItem workItem, WorkItemManager manager)
   {

      User currentUser = (User) workItem.getParameter("currentUser");
      Integer calculatedPrice = (Integer) workItem.getParameter("calculatedPrice");

      String response = "";
      
      String url = "https://insane-e88b5.firebaseio.com/users/" + currentUser.getFbid() + ".json";
      
      Random rand = new Random();
      Integer randNum = (rand.nextInt(PIN_MAX_VALUE_2) + PIN_MIN_VALUE_2);
      
      Integer previousCredit = currentUser.getCredit();
      
      Integer newCredit = previousCredit - calculatedPrice;
      
      if (randNum > 5) {
        currentUser.setCredit(newCredit);
      } else {
        throw new ChargeException("Charge failed!");
      }
      
      Map<String, Object> results = new HashMap<String, Object>();
      results.put("currentUser", currentUser);
      results.put("currentUserUrl", url);

      manager.completeWorkItem(workItem.getId(), results);
   }

}