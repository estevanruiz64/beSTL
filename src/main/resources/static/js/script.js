function myMap() {
    var mapOptions = {
        center: new google.maps.LatLng(38.651553, -90.258962),
        zoom:15,
        mapTypeId: google.maps.MapTypeId.ROAD
    };
var map = new google.maps.Map(document.getElementById("map"), mapOptions);
};