package insanebikesteam.insanebikes;

import insanebikesteam.insanebikes.BikeStand;
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

public class FetchStandHandler implements java.io.Serializable, WorkItemHandler
{

   public void abortWorkItem(WorkItem workItem, WorkItemManager manager)
   {
   }

   public void executeWorkItem(WorkItem workItem, WorkItemManager manager)
   {

      String urlID = (String) workItem.getParameter("Url");
      BikeStand closestStand = new BikeStand();
      closestStand.setBikes_in_stand(new ArrayList<Bike>());
      
      String url = "https://insane-e88b5.firebaseio.com/bikeStands/" + urlID + ".json";
      closestStand.setFbid(urlID);

      String response = "";

      try
      {
         response = IOUtils.toString(new URL(url), (Charset) null);

      }
      catch (Exception e)
      {
         System.out.println("############## Fetch Stand Chyba: " + e.getMessage());
      }

      try
      {
         JSONObject jsonStand = new JSONObject(response);
         closestStand.setCapacity(jsonStand.getInt("capacity"));
         closestStand.setLocation(jsonStand.getString("location"));

      }
      catch (JSONException ex)
      {
          System.out.println("############## FETCH JSON Chyba: " + ex.getMessage());
      }

      Map<String, Object> results = new HashMap<String, Object>();
      results.put("bikeStand", closestStand);

      manager.completeWorkItem(workItem.getId(), results);
   }

}