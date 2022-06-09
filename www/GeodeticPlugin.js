var exec = require('cordova/exec');

const Geodetic = {
    getDistance: function (inLat, inLng, outLat, outLng, success, error) {
        exec(success, error, 'GeodeticPlugin', 'getDistance', [inLat, inLng, outLat, outLng]);
    }
}

module.exports = Geodetic;
