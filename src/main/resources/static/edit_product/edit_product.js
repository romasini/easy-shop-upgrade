angular.module('app').controller('editProductController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    @scope.updateProduct = function(){
         $http.put(contextPath + '/api/v1/products', $scope.product)
         .then(function (response) {
              $scope.product = null;
         });

    }

    @scope.fillProduct = function(){
        $http({
            url: contextPath + '/api/v1/product/',
            method: 'GET'
        })
        .then(function (response) {
            $scope.product = response.data;
        });

    }

    @scope.fillProduct();
});