package insanebikesteam.insanebikes;

import insanebikesteam.insanebikes.User;
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

public class LockUserHandler implements java.io.Serializable, WorkItemHandler
{

   public void abortWorkItem(WorkItem workItem, WorkItemManager manager)
   {
   }

   public void executeWorkItem(WorkItem workItem, WorkItemManager manager)
   {

      User currentUser = (User) workItem.getParameter("currentUser");
      
      String url = "https://insane-e88b5.firebaseio.com/users/" + currentUser.getFbid() + ".json";

      currentUser.setLocked(true);
      
      Map<String, Object> results = new HashMap<String, Object>();
      results.put("currentUser", currentUser);
      results.put("currentUserUrl", url);
      
      System.out.println("************************ results: " + results);

      manager.completeWorkItem(workItem.getId(), results);
   }

}