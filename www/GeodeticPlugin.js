var exec = require('cordova/exec');

const Geodetic = {
    getDistance: function (inLat, inLng, outLng, outLng, success, error) {
        exec(success, error, 'GeodeticPlugin', 'getDistance', [inLat, inLng, outLng, outLng]);
    }
}

module.exports = Geodetic;
