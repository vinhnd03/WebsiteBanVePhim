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
            $scope.form = angular.copy($scope.user);
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
        $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
            $scope.form = resp.data;
            alert("Cập nhật thông tin thành công");
        }).catch(error => {
            alert("Lỗi cập nhật thông tin");
            console.log("Error", error);
        });
    };

    $scope.confirmDelete = function () {
        var confirmPassword = $scope.passwordToDelete;
    
        // Kiểm tra mật khẩu ở đây
        if (confirmPassword === $scope.user.password) {
            // Sử dụng hộp thoại xác nhận
            var confirmDelete = confirm("Bạn có chắc chắn muốn xóa tài khoản?");
    
            if (confirmDelete) {
                // Nếu người dùng xác nhận, thực hiện xóa tài khoản
                $http.delete(`/rest/accounts/${$scope.username}`).then(resp => {
                    alert("Tài khoản đã được xóa thành công");
                    $window.location.href = '/security/logoff';
                }).catch(error => {
                    alert("Lỗi khi xóa tài khoản");
                    console.log("Error", error);
                });
            } else {
                // Người dùng không xác nhận, không thực hiện xóa tài khoản
                alert("Hủy xóa tài khoản");
            }
        } else {
            // Mật khẩu không hợp lệ, hiển thị thông báo lỗi
            alert("Mật khẩu không đúng. Vui lòng thử lại.");
        }
    };
    $scope.showDeleteForm = false;
    // Hàm hủy bỏ
    $scope.cancelDelete = function () {
        // Ẩn form khi hủy bỏ
        $scope.showDeleteForm = false;
        $scope.passwordToDelete = '';
    };
    $scope.reset = function(){
        $scope.initialize(); 
    }
});



