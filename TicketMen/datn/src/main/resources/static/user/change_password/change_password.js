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

    $scope.sweetAlert=function(icon,message){
        Swal.fire({
            icon: icon,
            title: message,
            theme: 'bootstrap 4',
        });
    }
    $scope.initialize();

    $scope.checkPasswordForm = function() {
        // Check if the entered old password is correct
        if (!$scope.form.oldPassword) {
            $scope.error = "Nhập mật khẩu cũ!";
            return;
        }

        // Check if the new password and confirm password match
        if (!$scope.form.newPassword ) {
            $scope.error = "Nhập mật khẩu mới!";
            return;
        }

        if (!$scope.form.confirmPassword) {
            $scope.error = "Nhập xác nhận mật khẩu mới!";
            return;
        }

        // You can add more complex password validation logic if needed

        // If all checks pass, reset error and enable the button
        $scope.error = "";
    };
    $scope.changePassword = function () {
        if (!$scope.form.newPassword) {
            $scope.sweetAlert('error','Vui Lòng Nhập Mật Khẩu Mới');
            return;
        }
        if (!$scope.form.oldPassword) {
            $scope.sweetAlert('error','Vui Lòng Nhập Mật Khẩu Cũ');
            return;
        }
        if ($scope.form.oldPassword != $scope.user.password){
            $scope.sweetAlert('error','Sai Mật Khẩu Cũ');
            return;
        }
        if ($scope.form.newPassword !== $scope.form.confirmPassword) {
            $scope.sweetAlert('error','Mật Khẩu Xác Nhận Không Đúng');
            return;
        }
        var item = angular.copy($scope.user);

        item.password = $scope.form.newPassword;
        $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
            $scope.sweetAlert('success','Đổi Mật Khẩu Thành Công');
            $scope.initialize();
        }).catch(error => {
            $scope.sweetAlert('error','Lỗi');
        });
    };
    $scope.reset = function(){
        $scope.form = {};
    }
    
});