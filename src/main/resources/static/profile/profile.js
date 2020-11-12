angular.module('app').controller('profileController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

        $scope.fillProfile = function () {
            $http({
                url: contextPath + '/api/v1/profile',
                method: 'GET'
            })
            .then(function (response) {
                $scope.Profile = response.data;
            });
        };

        $scope.submitUpdateProfile= function () {
             $http({
                 url: contextPath + '/api/v1/profile',
                 method: 'PUT',
                 data: $scope.Profile,
                 params: {
                     password: $scope.password,
                     }
                 })
                 .then(function (response) {
                    alert('Профиль изменен');
                 });
             };

        $scope.fillProfile();
});