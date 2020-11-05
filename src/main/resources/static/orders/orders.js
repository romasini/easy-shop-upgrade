angular.module('app').controller('ordersController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

        $scope.fillTableOrders = function (pageIndex = 1) {
            $http({
                url: contextPath + '/api/v1/orders',
                method: 'GET',
                params: {
                    p: pageIndex
                }
            })
                .then(function (response) {
                    $scope.OrdersPage = response.data;
                    $scope.PaginationArray = $scope.generatePagesInd(1, $scope.OrdersPage.totalPages);
                });
        };

        $scope.generatePagesInd = function(startPage, endPage) {
            let arr = [];
            for (let i = startPage; i < endPage + 1; i++) {
                arr.push(i);
            }
            return arr;
        }


        $scope.fillTableOrders();
});