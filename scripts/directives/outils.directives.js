angular
    .module('portail.controllers')
    .directive('ngElevateZoom', function() {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                attrs.$observe('zoomImage', function () {
                    linkElevateZoom();
                });

                function linkElevateZoom () {
                //Check if its not empty
                    if (!attrs.zoomImage) 
                    return;
                    element.attr('data-zoom-image', attrs.zoomImage);
                    $(element).elevateZoom({
                        cursor: "crosshair",
                        scrollZoom : true,
                        zoomWindowWidth : 1200,
                        zoomWindowHeight : 600
                    });
                }
                linkElevateZoom();
            }
        };
    });