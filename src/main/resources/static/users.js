angular.module('app', []).controller('usersController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/market/api/v2';

    // http://localhost:8190/market/api/v2/users

    $scope.fillTableUsers = function () {
        $http.get(contextPath + '/users')
            .then(function (response) {
                console.log(response);
            $scope.UsersList = response.data;
        });
    };

    $scope.fillTableUsers();
});
