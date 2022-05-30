package cordova.plugin.geodetic;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;

/**
 * User: FunkyZc
 * Date: 2020/7/16 15:18
 */
public final class GlobalCoordinatesUtils {

	private static class GeodeticCalculatorHolder {
		private static final GeodeticCalculator INSTANCE = new GeodeticCalculator();
	}

	private static GeodeticCalculator getInstance() {
		return GeodeticCalculatorHolder.INSTANCE;
	}

	public static double getDistance(Double longitudeFrom, Double latitudeFrom, Double longitudeTo, Double latitudeTo) {
		GlobalCoordinates source = new GlobalCoordinates(latitudeFrom, longitudeFrom);
		GlobalCoordinates target = new GlobalCoordinates(latitudeTo, longitudeTo);

		return getInstance().calculateGeodeticCurve(Ellipsoid.Sphere, source, target).getEllipsoidalDistance();
	}
}