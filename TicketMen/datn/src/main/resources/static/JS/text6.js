// Lấy các phần tử HTML bạn cần thao tác
const quantityInputs = document.querySelectorAll('.ticket-num input');
const ticketPrices = Array.from(document.querySelectorAll('.ticket-price')).map(ticketPriceElement => parseInt(ticketPriceElement.getAttribute('data-price')));
const ticketTotalElements = document.querySelectorAll('.ticket-total span');
const totalTicketNumElement = document.querySelector('.total-ticket-num span');
const totalTicketAmountElement = document.querySelector('.total-ticket-amount span');
const orderWrapTotalAmountElement = document.querySelector('.order-wrap .about-ticket li:nth-child(4) .value span');

// Khởi tạo mảng lưu trữ số lượng và giá trị tổng
let quantities = [0, 0];

// Hàm cập nhật số lượng và giá trị tổng cho từng loại vé
function updateQuantityAndTotal(index) {
    const quantity = quantities[index];
    const price = ticketPrices[index];
    const totalAmount = quantity * price;

    quantityInputs[index].value = quantity;
    ticketTotalElements[index].textContent = totalAmount + 'đ';
}

// Hàm cập nhật tổng số vé và tổng số tiền
function updateTotalTicket() {
    const totalQuantity = quantities.reduce((acc, current) => acc + current, 0);
    totalTicketNumElement.textContent = totalQuantity;
    const totalAmount = quantities.reduce((acc, current, index) => acc + current * ticketPrices[index], 0);
    totalTicketAmountElement.textContent = totalAmount + ',00';

    // Cập nhật giá ở order-wrap
    orderWrapTotalAmountElement.textContent = totalAmount + 'đ';
}

// Xử lý sự kiện khi tăng số lượng
function handleIncrease(index) {
    quantities[index]++;
    updateQuantityAndTotal(index);
    updateTotalTicket();
}

// Xử lý sự kiện khi giảm số lượng
function handleDecrease(index) {
    if (quantities[index] > 0) {
        quantities[index]--;
        updateQuantityAndTotal(index);
        updateTotalTicket();
    }
}

// Gán sự kiện cho nút tăng và giảm trên cả hai loại vé
document.querySelectorAll('.ticket-num .add').forEach((addButton, index) => {
    addButton.addEventListener('click', () => {
        handleIncrease(index);
        // Kết hợp với mã JavaScript trước đó ở đây để cập nhật ticket-wrap
        const ticketWrapQuantityInput = document.querySelector('.ticket-wrap .ticket-num input');
        const orderWrapQuantityElement = document.querySelector('.order-wrap .about-ticket li:nth-child(3) .value span');
        ticketWrapQuantityInput.value = quantities[index];
        orderWrapQuantityElement.textContent = quantities[index];

        // Cập nhật giá ở order-wrap
        orderWrapTotalAmountElement.textContent = totalTicketAmountElement.textContent;
    });
});

document.querySelectorAll('.ticket-num .minus').forEach((minusButton, index) => {
    minusButton.addEventListener('click', () => {
        handleDecrease(index);
        // Kết hợp với mã JavaScript trước đó ở đây để cập nhật ticket-wrap
        const ticketWrapQuantityInput = document.querySelector('.ticket-wrap .ticket-num input');
        const orderWrapQuantityElement = document.querySelector('.order-wrap .about-ticket li:nth-child(3) .value span');
        ticketWrapQuantityInput.value = quantities[index];
        orderWrapQuantityElement.textContent = quantities[index];

        // Cập nhật giá ở order-wrap
        orderWrapTotalAmountElement.textContent = totalTicketAmountElement.textContent;
    });
});

// Xử lý mặc định khi tải trang
updateTotalTicket();

//đếm ngược 5 phút hi
    function demNguoc() {
        var demNguocElement = document.getElementById("demNguoc");
        var thoiGian = 300;

        var x = setInterval(function () {
            var phut = Math.floor(thoiGian / 60);
            var giay = thoiGian % 60;


            var thoiGianChuoi = phut + ":" + (giay < 10 ? "0" : "") + giay;

            demNguocElement.innerHTML = thoiGianChuoi;

            thoiGian--;

            if (thoiGian < 0) {
                clearInterval(x);
                demNguocElement.innerHTML = "Hết thời gian";
            }
        }, 1000);
    }

    window.onload = demNguoc;
