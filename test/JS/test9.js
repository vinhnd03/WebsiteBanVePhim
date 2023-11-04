// Lấy các phần tử HTML bạn cần thao tác
const quantityInputs = document.querySelectorAll('.ticket-num input');
const ticketPrices = Array.from(document.querySelectorAll('.ticket-price')).map(ticketPriceElement => parseInt(ticketPriceElement.getAttribute('data-price')));
const ticketTotalElements = document.querySelectorAll('.ticket-total span');
const totalTicketNumElement = document.querySelector('.total-ticket-num span');
const totalTicketAmountElement = document.querySelector('.total-ticket-amount span');
const orderWrapTotalAmountElement = document.querySelector('.order-wrap .about-ticket li:nth-child(4) .value span');
const orderWrapQuantityElement = document.querySelector('.order-wrap .about-ticket li:nth-child(3) .value span');

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
    orderWrapQuantityElement.textContent = totalQuantity;
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
    });
});

document.querySelectorAll('.ticket-num .minus').forEach((minusButton, index) => {
    minusButton.addEventListener('click', () => {
        handleDecrease(index);
    });
});

// Xử lý mặc định khi tải trang
updateTotalTicket();