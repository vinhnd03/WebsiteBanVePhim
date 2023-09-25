var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        // .when("/", {
        //     templateUrl: "", // Template cho trang chính
        //     controller: "HomeController"
        // })
        .when("/showtime", {
            templateUrl: "Lichchieu.html", // Template cho trang chính
            controller: "ShowwtimeController"
        })
        .when("/discount", {
            templateUrl: "Khuyenmai.html", // Template cho trang "about"
            controller: "DiscountController"
        })
        .when("/contact", {
            templateUrl: "Lienhe.html", // Template cho trang "contact"
            controller: "ContactController"
        })
        .when("/qna", {
            templateUrl: "Hoidap.html", // Template cho trang "contact"
            controller: "QnaController"
        })
        .when("/about", {
            templateUrl: "Dichvu.html", // Template cho trang "contact"
            controller: "AboutController"
        })
        .when("/login", {
            templateUrl: "Login.html", // Template cho trang "contact"
            controller: "LoginController"
        })
        .when("/register", {
            templateUrl: "Register.html", // Template cho trang "contact"
            controller: "RegisterController"
        })
        .otherwise({
            redirectTo: "/" // Trang mặc định khi không có định tuyến khớp
        });
});