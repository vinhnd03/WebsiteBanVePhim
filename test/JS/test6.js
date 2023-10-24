const seatsContainer = document.querySelector(".seats");
const rows = 12; // Số hàng
const seatsPerRow = 10; // Số ghế trong mỗi hàng
const seatAlphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
const pricePerSeat = 50000; // Giá mỗi ghế là 50,000 VNĐ

let selectedSeats = [];
let availableSeats = rows * seatsPerRow;

const selectedSeatsList = document.getElementById('selected-seats');
const totalAmountElement = document.getElementById('total-amount');

// Tạo ghế và theo dõi trạng thái của ghế
for (let i = 0; i < rows; i++) {
    for (let j = 1; j <= seatsPerRow; j++) {
        const seat = document.createElement("div");
        seat.classList.add("seat");
        seat.textContent = seatAlphabet[i] + j;
        seatsContainer.appendChild(seat);
    }
}

const updateSeatStatus = () => {
    selectedSeatsList.textContent = selectedSeats.length;

    let totalAmount = selectedSeats.length * pricePerSeat;

    totalAmountElement.textContent = totalAmount;
};

seatsContainer.addEventListener("click", (e) => {
    if (e.target.classList.contains("seat")) {
        const seat = e.target;
        if (seat.classList.contains("selected")) {
            seat.classList.remove("selected");
            seat.classList.add("available");
            selectedSeats.pop();
            availableSeats++;
        } else {
            seat.classList.add("selected");
            seat.classList.remove("available");
            selectedSeats.push(seat);
            availableSeats--;
        }
        updateSeatStatus();
    }
});

// Xử lý sự kiện khi nút Quay lại được nhấn
const goBackButton = document.getElementById('back-button');
goBackButton.addEventListener('click', () => {
    // Đặt lại trạng thái ghế đã chọn và số tiền
    selectedSeats.forEach(seat => {
        seat.classList.remove('selected');
        seat.classList.add('available');
    });
    selectedSeats = [];
    availableSeats = rows * seatsPerRow;
    updateSeatStatus();
});

// Xử lý sự kiện khi nút Tiếp tục được nhấn
const continueButton = document.getElementById('continue-button');
continueButton.addEventListener('click', () => {
    // Thêm mã xử lý khi người dùng muốn tiếp tục với việc đặt vé
    // Ở đây, bạn có thể thêm mã JavaScript để chuyển người dùng đến trang đặt vé hoặc thực hiện các thao tác khác.
    alert('Đã chuyển đến trang đặt vé.');

    // Để thay đổi suất chiếu, bạn có thể sử dụng một số hàm hoặc đoạn mã tùy theo cấu trúc trang web của bạn. 
    // Dưới đây là một ví dụ đơn giản về cách thay đổi suất chiếu:
    const showtimeElement = document.querySelector('.showtime-button.selected');
    if (showtimeElement) {
        // Lấy giá trị suất chiếu đã chọn
        const selectedShowtime = showtimeElement.textContent;

        // Thực hiện xử lý tiếp theo với suất chiếu đã chọn
        alert(`Đã chọn suất chiếu: ${selectedShowtime}`);
    } else {
        alert('Vui lòng chọn một suất chiếu trước khi tiếp tục.');
    }
});