app.controller("accounts-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};
    $scope.auths = [];
    $scope.roles = [];

    $scope.initialize = function () {
        //load products
        $http.get("/rest/accounts").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {

            })
            $scope.reset();
        });

        $http.get("/rest/authorities").then(resp => {
            $scope.auths = resp.data;
        })

        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })
    }

    

    //Khởi đầu
    $scope.initialize();

    console.log($scope.roles);
    console.log($scope.items);

    //Xóa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            gender: true
        }
    }

    //Hiển thị lên form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //
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

    //Thêm sản phẩm mới
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/accounts`, item).then(resp => {
            // resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            setAuthority(resp.data.username)
            alert("Them moi thanh cong");  
            
            $scope.reset();
        }).catch(error => {
            alert("Loi them moi san pham");
            console.log("Error", error);
        })

       
    }

    //Cập nhật sản phẩm
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/accounts/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật sản phẩm thành công")
            $scope.initialize();
        }).catch(error => {
            alert("Lỗi cập nhật sản phẩm");
            console.log("Error", error);
        })
    }

    //Xóa sản phẩm
    $scope.delete = function (item) {

        $http.delete(`/rest/accounts/${item.username}`).then(resp => {
            var index = $scope.items.findIndex(s => s.username == item.username);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa sản phẩm thành công")
        }).catch(error => {
            alert("Lỗi xóa sản phẩm");
            console.log("Error", error);
        })
    }


    $scope.pager = {
        page: 0,
        size: 5,
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
