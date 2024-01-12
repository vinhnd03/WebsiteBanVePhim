app.controller("statistic-ctrl", function ($scope, $http) {
    $scope.thongke = [];

    $scope.initialize = function () {
        // Gọi API để lấy dữ liệu thống kê
        $http.get("/rest/statistic/monthly")
                .then(function (response) {
        console.log("API Response:", response.data);
        $scope.thongke = response.data;
    })
    .catch(function (error) {
        console.error("Error fetching monthly revenue data", error);
    });
    }   

    // Kiểm tra xem phương thức initialize có được gọi khi trang được tải không
    console.log("Initializing statistic controller");
    $scope.initialize();

    // Thêm một số log để kiểm tra giá trị của $scope.thongke
    $scope.$watch('thongke', function(newVal, oldVal) {
        console.log("$scope.thongke changed:", newVal);
    });
});
