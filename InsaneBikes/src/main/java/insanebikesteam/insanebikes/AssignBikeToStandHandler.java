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

public class AssignBikeToStandHandler implements java.io.Serializable, WorkItemHandler
{

   public void abortWorkItem(WorkItem workItem, WorkItemManager manager)
   {
   }

   public void executeWorkItem(WorkItem workItem, WorkItemManager manager)
   {

      BikeStand closestStand = (BikeStand) workItem.getParameter("closestStand");
      Bike currentBike = (Bike) workItem.getParameter("currentBike");

      String response = "";
      
      String url = "https://insane-e88b5.firebaseio.com/bikeStands/" + closestStand.getFbid() + ".json";
      
      System.out.println("************************ URL: " + url);
      
      currentBike.setAvailable(true);
      
      closestStand.getBikes_in_stand().add(currentBike);
      
      System.out.println("************************ URL: " + url);

      Map<String, Object> results = new HashMap<String, Object>();
      results.put("closestStand", closestStand);
      results.put("standUrl", url);
      
      System.out.println("************************ URL: " + url);
      System.out.println("************************ results: " + results);

      manager.completeWorkItem(workItem.getId(), results);
   }

}