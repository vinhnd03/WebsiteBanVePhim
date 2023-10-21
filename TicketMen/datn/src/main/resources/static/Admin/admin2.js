app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
        .when("/", {
            templateUrl: "/Admin/home/index.html", // Template cho trang chính
        })
        .when("/product", {
            templateUrl: "/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/category", {
            templateUrl: "/admin/category/index.html",
            controller: "category-ctrl"
        })
        .when("/accounts", {
            templateUrl: "/admin/accounts/index.html",
            controller: "accounts-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/admin/authority/index.html",
            controller: "authority-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/admin/authority/unauthorized.html",
            
        })
        .when("/ticket", {
            templateUrl: "/admin/Ticket/index.html",
            // controller: "ticket-ctrl"
        })
        .otherwise({
            template: "<h1 class='text-center'>FPT Polytechnic Adminitration</h1>"
        })

});