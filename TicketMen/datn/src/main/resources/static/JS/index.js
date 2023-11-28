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
        }).catch(error => {
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
app.controller("register-ctrl", function ($scope) {
    $scope.isDisabled = true; // Mặc định nút sẽ bị vô hiệu hóa

    $scope.checkInput = function () {
        // Kiểm tra tất cả các trường input
        if ($scope.name && $scope.address && $scope.username && $scope.phone
            && $scope.email && $scope.password && $scope.confirmPassword) {
            $scope.isDisabled = false; // Bật nút "Đăng ký"
        } else {
            $scope.isDisabled = true; // Tắt nút "Đăng ký"

        }
    };
});
app.controller("login-ctrl", function ($scope) {
    $scope.isDisabled = true; // Mặc định nút sẽ bị vô hiệu hóa

    $scope.checkInput = function () {
        // Kiểm tra tất cả các trường input
        if ($scope.username && $scope.password) {
            $scope.isDisabled = false; // Bật nút "Đăng ký"
        } else {
            $scope.isDisabled = true; // Tắt nút "Đăng ký"

        }
    };
});

app.controller("ticketSelectCtrl", function ($scope, $http, $window) {
    $scope.tickets = [];
    $scope.dayInWeek = [];
    var movieId = $('#Mid').text();

    $scope.set7Day = function () {
        moment.locale('vi');
        var today = moment();

        $scope.dayInWeek.push(capitalizeFirstLetter("Hôm nay, " + today.format("DD/MM/YYYY")));

        for (var i = 1; i <= 6; i++) {
            today.add(1, 'days');
            $scope.dayInWeek.push(capitalizeFirstLetter(today.format("dddd, DD/MM/YYYY")));
        }

        console.log("day in week: ", $scope.dayInWeek);

        function capitalizeFirstLetter(string) {
            return string.charAt(0).toUpperCase() + string.slice(1);
        }
    }


    $scope.initialize = function () {
        $http.get("/rest/tickets/getTicketByMovie/" + movieId).then(resp => {
            $scope.tickets = resp.data;
            console.log("tickets: ", $scope.tickets);
        }).catch(error => {
            console.log(error);
        })

        $scope.set7Day();
    }
    $scope.initialize();

    $scope.findTime = function(day){
        $scope.time = [];

        var formattedDay = moment(day, "dddd, DD/MM/YYYY").format("MM-DD-YYYY");

        $http.get(`/rest/tickets/findTicketByMovieAndDate/${movieId}/${formattedDay}`).then(resp => {
            $scope.time = resp.data;
            console.log("showtime: ", $scope.time);
        }).catch(error => {
            console.log(error);
        })
    }
    
});

app.controller("seatSelectCtrl", function ($scope, $http, $window) {
    $scope.showtimes = [];
    $scope.selectedShowtime = "";
    $scope.perform = {};
    $scope.ticket = {};
    $scope.username = $window.localStorage.getItem('username');
    $scope.account = {};
    $scope.dseats = [];
    $scope.orderedSeats = [];

    // Define rows and seats with labels A to N (10 columns)
    $scope.rows = Array.from({ length: 10 }, (v, k) => k + 1);
    $scope.columns = Array.from({ length: 14 }, (v, k) => String.fromCharCode(65 + k)); // A to J
    $scope.seats = generateSeats($scope.rows, $scope.columns);

    $scope.selectedSeats = []
    $scope.availableSeats = ($scope.rows.length * $scope.columns.length) - $scope.orderedSeats.length;
    $scope.selectedSeats2 = JSON.parse($window.localStorage.getItem("selectedSeats")) || [];

    //Hiển thị thông báo
    $scope.sweetAlert = function (icon, message) {
        Swal.fire({
            icon: icon,
            title: message,
            theme: 'bootstrap 4',
        });
    }


    var ticketId = $('#Tid').text();

    console.log("tid: ", ticketId);

    $scope.initialize = function () {
        var promise = $http.get("/rest/tickets/" + ticketId);

        promise.then(function (resp) {

            $scope.ticket = resp.data;
            console.log($scope.ticket);
            // $scope.ticket.date = moment($scope.ticket.date).format('MM-DD-YYYY');
            // $scope.ticket.time = moment($scope.ticket.time).format('HH:mm:ss');
            $scope.ticket.date = new Date($scope.ticket.date);

            var formattedDate = moment($scope.ticket.date).format('MM-DD-YYYY');


            $scope.perform = angular.copy($scope.ticket);
            $http.get(`/rest/seats/byDateTimeAndTId/${formattedDate}/${$scope.ticket.time}/${$scope.ticket.id}`).then(resp => {
                $scope.orderedSeats = resp.data;
                console.log("orderedSeats: ", $scope.orderedSeats);
                // Thiết lập trạng thái cho mỗi ghế
                $scope.seats.forEach(seat => {
                    seat.isBooked = $scope.orderedSeats.some(orderedSeat => orderedSeat.name === seat);
                });

                $scope.availableSeats = ($scope.rows.length * $scope.columns.length) - $scope.orderedSeats.length;
                $scope.ticket.time = new Date($scope.ticket.time);
            }).catch(error => {
                console.log(error);
            })


            console.log("test: ", $scope.ticket);
        }).catch(function (error) {
            console.error("Error: " + error)
        })



        $http.get("/rest/accounts/" + $scope.username).then(resp => {
            $scope.account = resp.data;
        })

        $http.get("/rest/seats").then(resp => {
            $scope.dseats = resp.data;
        })


    };

    $scope.initialize();
    var limit = 0;
    $scope.toggleSeat = function (seat) {

        if ($scope.isSeatAvailable(seat)) {
            if (limit < 8) {
                $scope.selectedSeats.push(seat);
                $scope.availableSeats--;
                limit++;
            } else {
                $scope.sweetAlert("info", "Chỉ được chọn tối đa 8 ghế 1 lượt")
            }
        } else if ($scope.isSeatSelected(seat)) {
            var index = $scope.selectedSeats.indexOf(seat);
            $scope.selectedSeats.splice(index, 1);
            $scope.availableSeats++;
            limit--;
        }
    };

    $scope.isSeatAvailable = function (seat) {
        return $scope.selectedSeats.indexOf(seat) === -1;
    };

    $scope.isSeatSelected = function (seat) {
        return $scope.selectedSeats.indexOf(seat) !== -1;
    };

    $scope.isSeatOrdered = function (seat) {
        return $scope.orderedSeats.some(orderedSeat => orderedSeat.name === seat);
    };

    $scope.goBack = function () {
        $scope.selectedSeats = [];
        limit = 0
        $scope.availableSeats = $scope.rows.length * $scope.columns.length - $scope.orderedSeats.length;
    };

    $scope.goToPayment = function () {
        if ($scope.selectedSeats.length === 0) {
            $scope.sweetAlert("info", "Vui lòng chọn ít nhất 1 ghế để tiếp tục!")
        } else {
            $window.localStorage.setItem("selectedSeats", JSON.stringify($scope.selectedSeats));
            // Chuyển trang ở đây nếu điều kiện được đáp ứng
            $window.location.href = "/order/bill/" + ticketId;
        }
    }

    $scope.back = function () {
        $window.history.back();
    }

    // $scope.getSelectedSeatsFromLocalStorage = function () {
    //     var storedSeats = $window.localStorage.getItem("selectedSeats");
    //     return storedSeats ? JSON.parse(storedSeats) : [];
    // }

    $scope.continueBooking = function () {
        $scope.order = {};
        var items = [];
        $scope.selectedSeats = JSON.parse($window.localStorage.getItem("selectedSeats")) || [];
        console.log("selectedSeats: ", $scope.selectedSeats);

        var order = {
            createDate: new Date(),
            account: $scope.account,
            email: null
        }

        $http.post("/rest/orders", order).then(resp => {
            $scope.order = resp.data;
            console.log("order", $scope.order);

            // Duyệt qua mỗi ghế được chọn
            for (var i = 0; i < $scope.selectedSeats.length; i++) {
                var item = {
                    buyDate: new Date(),
                    order: $scope.order,
                    ticket: $scope.ticket,
                    seat: $scope.dseats.find(seat => seat.name === $scope.selectedSeats[i])
                };

                items.push(item);
            }

            // Gửi mỗi đối tượng item lên server
            items.forEach(item => {
                $http.post("/rest/orderDetails", item)
                    .then(resp => {

                    })
                    .catch(error => {
                        console.log("Lỗi khi thêm mới cho ghế", item.seat.name, error);
                    });
            });

            $window.localStorage.setItem("selectedSeats", JSON.stringify([]));
            // alert($scope.selectedSeats[1])
            $scope.sweetAlert("success", "Đặt ghế thành công!")
        }).catch(error => {
            console.log(error);
            $scope.sweetAlert("success", "Đặt ghế thất bại do lỗi!")
        })




    };

    function generateSeats(rows, columns) {
        var seats = [];
        rows.forEach(function (row) {
            columns.forEach(function (column) {
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