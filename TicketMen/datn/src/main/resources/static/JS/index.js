var app = angular.module("myApp", ["ngRoute"]);
app.controller("movie-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];


    $scope.initialize = function () {
        //load products
        $http.get("/rest/movies").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                
            });
        }).catch(error =>{
            console.error("Error: " + error)
        })
        //load categories
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });

    }


    //Khởi đầu
    $scope.initialize();
    $scope.pager = {
        page: 0,
        size: 4,
        get items() {
            var start = this.page * this.size;
            //console.log(start + "..." + this.size);
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },


        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },
        last() {
            this.page = this.count - 1;
        }
    }
});
app.controller("register-ctrl", function($scope) {
    $scope.isDisabled = true; // Mặc định nút sẽ bị vô hiệu hóa

    $scope.checkInput = function() {
        // Kiểm tra tất cả các trường input
        if ($scope.name && $scope.address && $scope.username && $scope.phone
            && $scope.email && $scope.password && $scope.confirmPassword) {
            $scope.isDisabled = false; // Bật nút "Đăng ký"
        } else {
            $scope.isDisabled = true; // Tắt nút "Đăng ký"
            // $scope.
        }
    };
});
app.controller("login-ctrl", function($scope) {
    $scope.isDisabled = true; // Mặc định nút sẽ bị vô hiệu hóa

    $scope.checkInput = function() {
        // Kiểm tra tất cả các trường input
        if ($scope.username && $scope.password) {
            $scope.isDisabled = false; // Bật nút "Đăng ký"
        } else {
            $scope.isDisabled = true; // Tắt nút "Đăng ký"
            // $scope.
        }
    };
});