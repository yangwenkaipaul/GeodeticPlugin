package cordova.plugin.geodetic;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.springframework.util.Assert;

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
		Assert.notNull(longitudeFrom, "传入经度不能为空");
		Assert.notNull(latitudeFrom, "传入纬度不能为空");
		Assert.notNull(longitudeTo, "接收经度不能为空");
		Assert.notNull(longitudeFrom, "接收纬度不能为空");
		GlobalCoordinates source = new GlobalCoordinates(latitudeFrom, longitudeFrom);
		GlobalCoordinates target = new GlobalCoordinates(latitudeTo, longitudeTo);

		return getInstance().calculateGeodeticCurve(Ellipsoid.Sphere, source, target).getEllipsoidalDistance();
	}
}