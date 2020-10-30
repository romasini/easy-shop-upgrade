angular.module('app').controller('addOrderController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.cartContentRequest = function () {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET'
        })
            .then(function (response) {
                console.log("response.data");
                $scope.cart = response.data;
                $scope.newOrder.price = $scope.cart.amount;
                $scope.newOrder.name = null;
                $scope.newOrder.phone = null;
                $scope.newOrder.address = null;

            });
    };

    $scope.submitCreateNewOrder = function () {
           $http.post(contextPath + '/api/v1/orders', $scope.newOrder)
               .then(function (response) {
                    alert("response.data");
                    $scope.cartContentRequest();

               });
    };

    $scope.cartContentRequest();
});