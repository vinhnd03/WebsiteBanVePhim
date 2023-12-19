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

        $scope.sweetAlert=function(icon,message){
            Swal.fire({
                icon: icon,
                title: message,
                theme: 'bootstrap 4',
            });
        }

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
            $scope.sweetAlert('success','Cập nhật thông tin thành công');
        }).catch(error => {
            $scope.sweetAlert('error','Lỗi cập nhật thông tin');
        });
    };

    $scope.checkForm = function() {
        // Check if the name is provided
        if (!$scope.form.name) {
            $scope.error = "Họ và tên không được để trống!";
            $scope.btn = true;
            return;
        }

        // Check if the phone number is provided and valid
        if (!$scope.form.sdt || !isValidPhoneNumber($scope.form.sdt)) {
            $scope.error = "Số điện thoại không hợp lệ!";
            $scope.btn = true;
            return;
        }

        // Check if the email is provided and valid
        if (!$scope.form.email || !isValidEmail($scope.form.email)) {
            $scope.error = "Email không hợp lệ!";
            $scope.btn = true;
            return;
        }

        // Check if the address is provided
        if (!$scope.form.address) {
            $scope.error = "Địa chỉ không được để trống!";
            $scope.btn = true;
            return;
        }

        // You can add more validation checks for other fields if needed

        // If all checks pass, reset error and enable the button
        $scope.error = "";
        $scope.btn = false;
    };

    // Function to validate phone number (you can customize this based on your requirements)
    function isValidPhoneNumber(phoneNumber) {
        // Add your phone number validation logic here
        // For example, you can use a regular expression to check the format
        // Return true if valid, false otherwise
        return /^[0-9]{10}$/.test(phoneNumber);
    }

    // Function to validate email (you can customize this based on your requirements)
    function isValidEmail(email) {
        // Add your email validation logic here
        // For example, you can use a regular expression to check the format
        // Return true if valid, false otherwise
        return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    }


    $scope.confirmDelete = function () {
        var confirmPassword = $scope.passwordToDelete;
    
        // Kiểm tra mật khẩu ở đây
        if (confirmPassword === $scope.user.password) {
            // Sử dụng hộp thoại xác nhận
            var confirmDelete = confirm("Bạn có chắc chắn muốn xóa tài khoản?");
    
            if (confirmDelete) {
                // Nếu người dùng xác nhận, thực hiện xóa tài khoản
                $http.delete(`/rest/accounts/${$scope.username}`).then(resp => {
                    $scope.sweetAlert('success','Xóa Tài Khoản Thành Công');
                    $window.location.href = '/security/logoff';
                }).catch(error => {
                    $scope.sweetAlert('error','Lỗi');
                });
            } else {
                // Người dùng không xác nhận, không thực hiện xóa tài khoản
                alert("Hủy xóa tài khoản");
            }
        } else {
            // Mật khẩu không hợp lệ, hiển thị thông báo lỗi
            $scope.sweetAlert('error','Sai mật khẩu');
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



