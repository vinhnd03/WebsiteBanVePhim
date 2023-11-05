var app = angular.module("seatBookingApp", []);

app.controller("SeatBookingController", function($scope, $http) {
    $scope.showtimes = ["17:00", "18:00", "19:00", "20:00"];
    $scope.selectedShowtime = "";

    // Define rows and seats with labels A to J (10 columns)
    $scope.rows = Array.from({ length: 12 }, (v, k) => k + 1);
    $scope.columns = Array.from({ length: 10 }, (v, k) => String.fromCharCode(65 + k)); // A to J
    $scope.seats = generateSeats($scope.rows, $scope.columns);

    $scope.selectedSeats = [];
    $scope.availableSeats = $scope.rows.length * $scope.columns.length;
    $scope.pricePerSeat = 50000;

    // Replace "URL_OF_MOVIE_LIST" with the actual URL to fetch movie list from the server
    $http.get("URL_OF_MOVIE_LIST")
        .then(function(response) {
            $scope.movies = response.data;
        })
        .catch(function(error) {
            console.error("Error fetching movie list: " + error);
        });

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