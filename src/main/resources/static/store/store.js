angular.module('app').controller('storeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

        $scope.fillTable = function (pageIndex = 1) {
            $http({
                url: contextPath + '/api/v1/products',
                method: 'GET',
                params: {
                    titlePart: $scope.filter ? $scope.filter.title_part : null,
                    minPrice: $scope.filter ? $scope.filter.min_price : null,
                    maxPrice: $scope.filter ? $scope.filter.max_price : null,
                    category: $scope.filter ? $scope.filter.category : null,
                    p: pageIndex
                }
            })
                .then(function (response) {
                    $scope.ProductsPage = response.data;
                    $scope.PaginationArray = $scope.generatePagesInd(1, $scope.ProductsPage.totalPages);
                });
        };

        $scope.cleanFilter = function(){
                    $scope.filter = null;
                    $scope.fillTable();
                }

        $scope.generatePagesInd = function(startPage, endPage) {
            let arr = [];
            for (let i = startPage; i < endPage + 1; i++) {
                arr.push(i);
            }
            return arr;
        }

        $scope.addToCart = function (productId) {
                $http({
                    url: contextPath + '/api/v1/cart/add/' + productId,
                    method: 'GET'
                });
        }

        $scope.fillCategories = function(){
                $http({
                    url: contextPath + '/api/v1/category',
                    method: 'GET'
                })
                    .then(function (response) {
                    $scope.categories = response.data;
                });
        }

        $scope.fillCategories();
        $scope.fillTable();
});