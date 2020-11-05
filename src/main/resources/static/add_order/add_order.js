angular.module('app').controller('addOrderController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.cartContentRequestOrder = function () {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET'
        })
            .then(function (response) {
                $scope.cart = response.data;
                $scope.newOrder = null;
            });
    };

    $scope.submitCreateNewOrder = function () {
        $http({
             url: contextPath + '/api/v1/orders',
             method: 'POST',
             params: {
                name: $scope.newOrder ? $scope.newOrder.name : null,
                phone: $scope.newOrder ? $scope.newOrder.phone : null,
                address: $scope.newOrder ? $scope.newOrder.address : null
             }
             })
            .then(function (response) {
                alert('Заказ оформлен');
                $scope.cartContentRequestOrder();
            });
    };

    $scope.cartContentRequestOrder();
});