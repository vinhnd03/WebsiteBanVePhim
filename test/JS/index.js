var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        // .when("/", {
        //     templateUrl: "", // Template cho trang chính
        //     controller: "HomeController"
        // })
        .when("/showtime", {
            templateUrl: "./Layout/Lichchieu.html", // Template cho trang chính
            controller: "ShowwtimeController"
        })
        .when("/discount", {
            templateUrl: "./Layout/Khuyenmai.html", // Template cho trang "about"
            controller: "DiscountController"
        })
        .when("/contact", {
            templateUrl: "./Layout/Lienhe.html", // Template cho trang "contact"
            controller: "ContactController"
        })
        .when("/qna", {
            templateUrl: "./Layout/Hoidap.html", // Template cho trang "contact"
            controller: "QnaController"
        })
        .when("/about", {
            templateUrl: "./Layout/Dichvu.html", // Template cho trang "contact"
            controller: "AboutController"
        })
        .when("/login", {
            templateUrl: "./Layout/Login.html", // Template cho trang "contact"
            controller: "LoginController"
        })
        .when("/register", {
            templateUrl: "./Layout/Register.html", // Template cho trang "contact"
            controller: "RegisterController"
        })
        .otherwise({
            redirectTo: "/" // Trang mặc định khi không có định tuyến khớp
        });
});