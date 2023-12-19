app.controller("accountsuser-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};
    $scope.auths = [];
    $scope.roles = [];

    $scope.updateBtn = true;
    $scope.createBtn = true;
    
    // Biến flag để kiểm tra hiển thị thông báo lỗi
    $scope.showInputError = false;

    $scope.sweetAlert = function (icon, message) {
        Swal.fire({
            icon: icon,
            title: message,
            theme: 'bootstrap 4',
        });
    }

    $scope.initialize = function () {
        // Load dữ liệu
        $http.get("/rest/accountsuser").then(resp => {
            $scope.items = resp.data;
            $scope.reset();
        });

        $http.get("/rest/authorities").then(resp => {
            $scope.auths = resp.data;
        })

        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })
    }

    // Khởi đầu
    $scope.initialize();

    // Xóa form và reset các biến flag
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            gender: true
        }
        $scope.updateBtn = true;
        $scope.createBtn = false;
        $scope.showInputError = false; // Reset biến flag
    }

    // Hiển thị lên form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.updateBtn = false;
        $scope.createBtn = true;
    }

    // Hàm cập nhật quyền
    function setAuthority(account) {
        var auth = {
            account: $scope.items.find(item => item.username = account),
            role: $scope.roles.find(ro => ro.id = "STAFF")
        }

        $http.post(`/rest/authorities`, auth).then(resp => {
            console.log("Đã cập nhật quyền cho tài khoản");
        }).catch(error => {
            console.log("Lỗi cập nhật quyền cho tài khoản", error);
        });
    }

    //
    $scope.checkUsernameExistence = function (username) {
        // Gửi yêu cầu kiểm tra tài khoản đến server
        $http.get(`/rest/accountsuser/${username}`).then(resp => {
            // Nếu có kết quả trả về, tài khoản đã tồn tại
            if (resp.data) {
                $scope.sweetAlert("error", "Tài khoản đã tồn tại!");
            } else {
                // Ngược lại, tài khoản chưa tồn tại
                $scope.sweetAlert("success", "Tài khoản có thể sử dụng!");
            }
        }).catch(error => {
            console.log("Error checking username existence", error);
        });
    };
    //
    // Thêm tài khoản mới
    $scope.create = function () {
            
        
        if (
            !$scope.form.username ||
            !$scope.form.password ||
            !$scope.form.name ||
            !$scope.form.email ||
            !$scope.form.sdt ||
            !$scope.form.address
        ) {
            $scope.showInputError = true;
            $scope.sweetAlert("error", "Vui lòng điền đầy đủ và đúng thông tin!");
            return;
        }
    
        $scope.showInputError = false;
    
        // Kiểm tra chiều dài ký tự và hiển thị thông báo
        // if ($scope.checkMaxLength($scope.form.username, 30)) {
        //     $scope.showMaxLengthError = true;
        //     $scope.sweetAlert("error", "Tài Khoản không được nhập quá 30 ký tự!");
        //     return;
        // }
    
        // Kiểm tra chiều dài ký tự và hiển thị thông báo cho các trường khác
        // if ($scope.checkMaxLength($scope.form.password, 30) || $scope.checkMaxLength($scope.form.name, 30) || $scope.checkMaxLength($scope.form.email, 30) || $scope.checkMaxLength($scope.form.address, 120)) {
        //     $scope.showMaxLengthError = true;
        //     $scope.sweetAlert("error", "Một hoặc vài trường đã nhập quá số lượng ký tự cho phép!");
        //     return;
        // }
    
        var item = angular.copy($scope.form);
        $http.post(`/rest/accountsuser`, item).then(resp => {
            $scope.items.push(resp.data);
            setAuthority(resp.data.username);
            $scope.sweetAlert("success", "Thêm mới thành công!");
            $scope.reset();
        }).catch(error => {
            $scope.sweetAlert("error", "Thêm mới thất bại!");
            console.log("Error", error);
        });
    };
    

    // Cập nhật tài khoản
    $scope.update = function () {
        if (
            !$scope.form.username ||
            !$scope.form.password ||
            !$scope.form.name ||
            !$scope.form.email ||
            !$scope.form.sdt ||
            !$scope.form.address
        ) {
            $scope.showInputError = true;
            $scope.sweetAlert("error", "Vui lòng điền đầy đủ và đúng thông tin!");
            return;
        }
    
        $scope.showInputError = false;
        
        var item = angular.copy($scope.form);
        $http.put(`/rest/accountsuser/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.sweetAlert("success","Cập nhật tài khoản thành công!")
            $scope.initialize();
        }).catch(error => {
            $scope.sweetAlert("error","Cập nhật tài khoản thất bại!")
            console.log("Error", error);
        })
    }

    // Xóa tài khoản
    $scope.delete = function (item) {
        $http.delete(`/rest/accountsuser/${item.username}`).then(resp => {
            var index = $scope.items.findIndex(s => s.username == item.username);
            $scope.items.splice(index, 1);
            $scope.reset();
            $scope.sweetAlert("success", "Xóa tài khoản thành công!")
        }).catch(error => {
            $scope.sweetAlert("error", "Xóa tài khoản thất bại!")
            console.log("Error", error);
        })
    }

    $scope.isValidEmail = function (email) {
        // Sử dụng biểu thức chính quy để kiểm tra định dạng email
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    };
    
    // Hàm kiểm tra định dạng số điện thoại (ví dụ: 123-456-7890)
    
    $scope.checkPhoneNumberFormat = function (sdt) {
        var phoneNumberPattern = /^0\d{9}$/;
        return phoneNumberPattern.test(sdt);
    };
    
    $scope.showMaxLengthError = false;

    // Hàm kiểm tra chiều dài ký tự
    $scope.checkMaxLength = function (value, maxLength) {
        return value && value.length > maxLength;
    };
    $scope.checkMinLength = function (value, minLength) {
        return value && value.length < minLength;
    };
    
    

    $scope.pager = {
        page: 0,
        size: 5,
        get items() {
            var start = this.page * this.size;
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
