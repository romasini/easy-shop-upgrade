(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage'])
        .config(config)
        .run();

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/add_product', {
                    templateUrl: 'add_product/add_product.html',
                    controller: 'addProductController'
             })
               .when('/cart', {
                              templateUrl: 'cart/cart.html',
                              controller: 'cartController'
                          })
            ;
    }
})();