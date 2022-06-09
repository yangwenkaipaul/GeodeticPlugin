package cordova.plugin.geodetic;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class GeodeticPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getDistance")) {
            try {
                Double latitudeFrom = args.getDouble(0);
                Double longitudeFrom = args.getDouble(1);
                Double latitudeTo = args.getDouble(2);
                Double longitudeTo = args.getDouble(3);
                double distance = GlobalCoordinatesUtils.getDistance(longitudeFrom, latitudeFrom, longitudeTo, latitudeTo);
                callbackContext.success(Double.toString(distance));
            } catch (Exception e) {
                callbackContext.error(e.getMessage());
            }
            return true;
        }
        return false;
    }

}
