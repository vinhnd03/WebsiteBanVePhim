// app.controller("user_ctrl", function ($scope,$http,$window) {
//     $scope.username = $window.localStorage.getItem('username');
//     // var username = $window.localStorage.getItem('username');
//     // $scope.un = username;
//     $scope.user = {};
//     $scope.initialize = function () {
       
//         //load products
//         $http.get(`/rest/accounts/${$scope.username}`).then(resp => {
//             $scope.user = resp.data;
//             // $scope.items.forEach(item => {
//             // })
//         });
//         console.log($scope.user);
//     }
//  $scope.initialize();

// });


app.controller("user_ctrl", function ($scope, $http, $window) {
    $scope.username = $window.localStorage.getItem('username');
    $scope.user = {};
    $scope.items = [];
    $scope.form = {};

    $scope.initialize = function () {
        // Tạo một Promise để đảm bảo cuộc gọi API hoàn thành trước khi truyền dữ liệu vào $scope.user
        var promise = $http.get('/rest/accounts/' + $scope.username);

        promise.then(function (resp) {
            // Thành công: gán dữ liệu người dùng vào $scope.user
            $scope.user = resp.data;
            // console.log($scope.user); // Dữ liệu người dùng sẽ hiển thị sau khi cuộc gọi hoàn thành.
            $scope.form = angular.copy($scope.user);
            console.log('form:', $scope.form);
        }).catch(function (error) {
            // Xử lý lỗi nếu có
            console.error('Lỗi khi tải dữ liệu người dùng: ', error);
        });
        // $scope.form = angular.copy($scope.user);
        //     console.log('form:', $scope.form);
    };
    $scope.initialize();
    // Hàm cập nhật thông tin người dùng
    $scope.update = function () {
        
        var item = angular.copy($scope.form);
        
        console.log("item.username:", item);
        
        $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
            alert("Cập nhật thông tin thành công");
            console.log('form2:', $scope.form);
            
        }).catch(error => {
            alert("Lỗi cập nhật thông tin");
            console.log("Error", error);
        });
    };
    // Gọi hàm khởi tạo khi trang được nạp
    
});



