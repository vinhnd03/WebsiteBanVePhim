app.controller("product-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};
    $scope.file = null;
    $scope.folder = null;

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
        $scope.folder = null;
        $scope.form = {
            createDate: new Date(),
            poster: '/image/no-image.png',
            available: true,
        }
        console.log($scope.folder);
    }

    //Hiển thị lên form
    $scope.edit = function (item) {
        $scope.folder = "/image/upload/";
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //Thêm sản phẩm mới
    $scope.create = function () {
        // $scope.folder = "/image/upload/";
        var data = new FormData();
        data.append('file', $scope.file);
        $http.post(`/rest/upload`, data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.poster = resp.data.name;

            var item = angular.copy($scope.form);

            $http.post(`/rest/movies`, item).then(resp => {
                resp.data.createDate = new Date(resp.data.createDate)
                $scope.items.push(resp.data);
                alert("Them moi thanh cong");
                $scope.initialize();
            }).catch(error => {
                alert("Loi them moi san pham");
                console.log("Error", error);
            })
            $scope.reset();
            $scope.initialize();
            console.log($scope.form.poster);
        }).catch(error => {
            console.log("Error", error);
        })

        console.log($scope.folder);
    }

    //Cập nhật sản phẩm
    $scope.update = function () {

        var data = new FormData();
        data.append('file', $scope.file);
        $http.post(`/rest/upload`, data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.poster = resp.data.name;


            console.log("form: ", $scope.form);
            var item = angular.copy($scope.form);
            $http.put(`/rest/movies/${item.id}`, item).then(resp => {
                var index = $scope.items.findIndex(p => p.id == item.id);
                $scope.items[index] = item;
                alert("Cập nhật sản phẩm thành công")
            }).catch(error => {
                alert("Lỗi cập nhật sản phẩm");
                console.log("Error", error);
            })

            $scope.reset();
            $scope.initialize();
            console.log($scope.form.poster);
        }).catch(error => {
            console.log("Error", error);
        })

        console.log($scope.folder);



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

    // $scope.imageChanged = function (files) {
    //     $scope.selectedFile = files[0];
    // };

    // //Upload hình
    // $scope.imageChanged = function (files) {
    //     var data = new FormData();
    //     data.append('file', files[0]);
    //     $http.post('/rest/upload/image', data, {
    //         transformRequest: angular.identity,
    //         headers: { 'Content-Type': undefined }
    //     }).then(resp => {
    //         $scope.form.poster = resp.data.name;
    //         console.log($scope.form.poster);
    //     }).catch(error => {
    //         console.log("Error", error);
    //     })
    // }


    $scope.imageChanged = function (input) {
        $scope.folder = null;
        $scope.file = input.files[0];
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $scope.$apply(function () {
                    $scope.form.poster = e.target.result;
                });
            };
            reader.readAsDataURL(input.files[0]);

        }
    };

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