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
                 params: {
                        password: $scope.Profile ? $scope.Profile.password : null,
                        firstname: $scope.Profile ? $scope.Profile.firstname : null,
                        lastname: $scope.Profile ? $scope.Profile.lastname : null,
                        phone: $scope.Profile ? $scope.Profile.phone : null,
                        email: $scope.Profile ? $scope.Profile.email : null,
                        birthdate: $scope.Profile ? $scope.Profile.birthdate : null,
                        sex: $scope.Profile ? $scope.Profile.sex : null,
                        address: $scope.Profile ? $scope.Profile.address : null
                        }
                 })
                 .then(function (response) {
                    alert('Профиль изменен');
                 });
             };

        $scope.fillProfile();
});