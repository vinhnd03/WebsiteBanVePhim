app.controller('password_ctrl', function($scope,$http, $window){
    $scope.user = {};
    $scope.form = [];
    $scope.username = $window.localStorage.getItem('username');

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
    };

    $scope.initialize();


    $scope.changePassword = function () {

        if ($scope.form.oldPassword !== $scope.user.password){
            alert("Nhập Sai Mật Khẩu Cũ. Vui Lòng Nhập Đúng Mật Khẩu Cũ")
        }
        if ($scope.form.newPassword !== $scope.form.confirmPassword) {
            alert("Xác nhận mật khẩu mới không khớp. Vui lòng kiểm tra lại.");
            return;
        }
        var item = angular.copy($scope.user);

        item.password = $scope.form.newPassword;
        $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
            
            alert("Cập nhật mật khẩu thành công");
            $scope.reset();
        }).catch(error => {
            alert("Lỗi cập nhật mật khẩu");
            console.log("Error", error);
        });
    };
    $scope.reset = function(){
        $scope.form = {};
    }
    
});