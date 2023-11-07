app = angular.module("user-app", ["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
        .when("/information_management", {
            templateUrl: "/user/information_management/information_management.html",
            controller: "user_ctrl"
        })
        .when("/change_password", {
            templateUrl: "/user/change_password/change_password.html",
            controller: "password_ctrl"
        })

});


// app.controller("setusername", function($scope, $window){
//     var username = $window.localStorage.getItem('username');
//     $scope.un = username;
// })