var app = angular.module("myApp", ["ngRoute"]);

app.controller('username-ctrl', function ($scope, $window) {
    // Lấy tên từ session.name
    var name = $(".getname").text();
    // alert(name)
    console.log(name)

    // Lưu tên vào local storage
    $window.localStorage.setItem('name', name);

    
});

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
            
        }
    };
});

app.controller("seatSelectCtrl", function($scope, $http) {
    $scope.showtimes = [];
    $scope.selectedShowtime = "";
    $scope.currentMovie = {};

    // Define rows and seats with labels A to J (10 columns)
    $scope.rows = Array.from({ length: 10}, (v, k) => k + 1);
    $scope.columns = Array.from({ length: 14 }, (v, k) => String.fromCharCode(65 + k)); // A to J
    $scope.seats = generateSeats($scope.rows, $scope.columns);

    $scope.selectedSeats = [];
    $scope.availableSeats = $scope.rows.length * $scope.columns.length;
    $scope.pricePerSeat = 50000;

    // Replace "URL_OF_MOVIE_LIST" with the actual URL to fetch movie list from the server
    // $http.get("URL_OF_MOVIE_LIST")
    //     .then(function(response) {
    //         $scope.movies = response.data;
    //     })
    //     .catch(function(error) {
    //         console.error("Error fetching movie list: " + error);
    //     });

    $scope.initialize = function(){
        var movieIdSelected = $("#movie_selected").text();
        console.log(movieIdSelected);

        $http.get("/rest/movie/"+ movieIdSelected).then(resp => {
            $scope.currentMovie = resp.data;
        }).catch(error =>{
            console.error("Error: " + error)
        })
        
    }

    $scope.selectShowtime = function(showtime) {
        $scope.selectedShowtime = showtime;
    };

    $scope.toggleSeat = function(seat) {
        if ($scope.isSeatAvailable(seat)) {
            $scope.selectedSeats.push(seat);
            $scope.availableSeats--;
        } else if ($scope.isSeatSelected(seat)) {
            var index = $scope.selectedSeats.indexOf(seat);
            $scope.selectedSeats.splice(index, 1);
            $scope.availableSeats++;
        }
    };

    $scope.isSeatAvailable = function(seat) {
        return $scope.selectedSeats.indexOf(seat) === -1;
    };

    $scope.isSeatSelected = function(seat) {
        return $scope.selectedSeats.indexOf(seat) !== -1;
    };

    $scope.goBack = function() {
        $scope.selectedSeats = [];
        $scope.availableSeats = $scope.rows.length * $scope.columns.length;
    };

    $scope.continueBooking = function() {
        if ($scope.selectedShowtime && $scope.selectedSeats.length > 0) {
            alert("Đã chọn suất chiếu: " + $scope.selectedShowtime);
            // Add further processing, e.g., redirecting the user to the ticket booking page
        } else {
            alert("Vui lòng chọn một suất chiếu và ít nhất một ghế trước khi tiếp tục.");
        }
    };

    function generateSeats(rows, columns) {
        var seats = [];
        rows.forEach(function(row) {
            columns.forEach(function(column) {
                seats.push(column + row);
            });
        });
        return seats;
    }
});

app.controller('username-ctrl', function ($scope, $window) {
    // Lấy tên từ session.name
    var username = $(".getusername").text();
    // alert(name)
    // Lưu tên vào local storage
    $window.localStorage.setItem('username', username);
});