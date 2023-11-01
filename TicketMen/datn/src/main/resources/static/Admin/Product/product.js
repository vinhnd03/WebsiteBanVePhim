app.controller("product-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};


    $scope.initialize = function () {
        //load products
        $http.get("/rest/movies").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.releaseDate = new Date(item.releaseDate)
                // Chuyển đổi thời gian thành đúng định dạng "HH:mm a"
                // const timeParts = item.time.split(':');
                // const hours = parseInt(timeParts[0], 10);
                // const minutes = parseInt(timeParts[1], 10);
                // const timeDate = new Date();
                // timeDate.setHours(hours);
                // timeDate.setMinutes(minutes);
                // timeDate.setSeconds(0);
                // timeDate.setMilliseconds(0);
                // item.time = timeDate;
            })
            $scope.reset();
        });

        //load categories
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        })
        console.log($scope.cates);
    }

    //Khởi đầu
    $scope.initialize();

    

    //Xóa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            poster: 'no-image.png',
            available: true,
        }
    }

    //Hiển thị lên form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //Thêm sản phẩm mới
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/movies`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Them moi thanh cong");
            $scope.initialize();
        }).catch(error => {
            alert("Loi them moi san pham");
            console.log("Error", error);
        })
    }

    //Cập nhật sản phẩm
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/movies/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật sản phẩm thành công")
        }).catch(error => {
            alert("Lỗi cập nhật sản phẩm");
            console.log("Error", error);
        })
    }

    //Xóa sản phẩm
    $scope.delete = function (item) {

        $http.delete(`/rest/movies/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa sản phẩm thành công")
        }).catch(error => {
            alert("Lỗi xóa sản phẩm");
            console.log("Error", error);
        })
    }

    //Upload hình
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/image', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.poster = resp.data.name;
        }).catch(error => {
            $scope.showAlertMessage("Lỗi Update ảnh")
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