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
import javax.ws.rs.core.UriBuilder;
import org.apache.commons.io.IOUtils;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class FetchBikeHandler implements java.io.Serializable, WorkItemHandler
{

   public void abortWorkItem(WorkItem workItem, WorkItemManager manager)
   {
   }

   public void executeWorkItem(WorkItem workItem, WorkItemManager manager)
   {
      String urlID = (String) workItem.getParameter("Url");
      Bike currentBike = new Bike();

      String url = "https://insane-e88b5.firebaseio.com/bikes/" + urlID + ".json";
      String response = "";
      
      currentBike.setFbid(urlID);

      try
      {
         response = IOUtils.toString(new URL(url), (Charset) null);

      }
      catch (Exception e)
      {
         System.out.println("############## Fetch Bike Chyba: " + e.getMessage());
      }

      try
      {
         JSONObject jsonBike = new JSONObject(response);
         currentBike.setType(jsonBike.getString("type"));
         currentBike.setColor(jsonBike.getString("color"));
         currentBike.setLocation(jsonBike.getString("location"));
         currentBike.setAvailable(jsonBike.getBoolean("available"));
         currentBike.setLockCode(jsonBike.getString("lockCode"));

      }
      catch (JSONException ex)
      {
         System.out.println("############## FETCH Bike JSON Chyba: " + ex.getMessage());
      }

      Map<String, Object> results = new HashMap<String, Object>();
      results.put("currentBike", currentBike);

      manager.completeWorkItem(workItem.getId(), results);
   }

}