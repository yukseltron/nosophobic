function initMap() {
  var usa = {lat: 39.8282, lng: -98.5795};

  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 4,
    center: usa
  });
}
