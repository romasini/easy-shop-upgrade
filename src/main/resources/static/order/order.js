angular.module('app').controller('orderController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8189/market';

        $scope.getOrder = function () {
            $http({
                url: contextPath + '/api/v1/orders/' + $routeParams.orderId,
                method: 'GET',
            })
            .then(function (response) {
                $scope.Order = response.data;
            });
        };

        $scope.getOrder();
});