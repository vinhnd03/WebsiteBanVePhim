app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
        .when("/product", {
            templateUrl: "/Admin/Product/index.html",
            controller: "product-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/assets/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/unathorized", {
            templateUrl: "/assets/admin/authority/unauthorize.html",
            controller: "authority-ctrl"
        })
        .otherwise({
            template: "<h1 class='text-center'>FPT Polytechnic Adminitration</h1>"
        })
});