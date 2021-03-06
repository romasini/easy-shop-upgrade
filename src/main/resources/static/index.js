(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider, $httpProvider) {
        $routeProvider

            .when('/auth', {
                templateUrl: 'auth/auth.html',
                controller: 'authController'
            })
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/orders', {
                templateUrl: 'orders/orders.html',
                controller: 'ordersController'
            })
            .when('/orders/:orderId', {
                templateUrl: 'order/order.html',
                controller: 'orderController'
            })
            .when('/add_order', {
                templateUrl: 'add_order/add_order.html',
                controller: 'addOrderController'
            })
            .when('/profile', {
                 templateUrl: 'profile/profile.html',
                 controller: 'profileController'
            })
            .when('/cart', {
                templateUrl: 'cart/cart.html',
                controller: 'cartController'
            })
            .otherwise({
                redirectTo: "/"
            });

        $httpProvider.interceptors.push(function ($q, $location) {
            return {
                'responseError': function (rejection, $localStorage, $http) {
                    var defer = $q.defer();
                    if (rejection.status == 401 || rejection.status == 403) {
                        console.log('error: 401-403');
                        $location.path('/auth');
                        if (!(localStorage.getItem("localUser") === null)) {
                            delete $localStorage.currentUser;
                            $http.defaults.headers.common.Authorization = '';
                            console.log('zxc');
                        }
                        console.log(rejection.data);
                        var answer = JSON.parse(rejection.data);
                        console.log(answer);

                    }
                    defer.reject(rejection);
                    return defer.promise;
                }
            };
        });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }
    }
})();