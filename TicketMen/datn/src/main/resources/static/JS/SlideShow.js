// table Javascript để điều khiển Slide Show
let slideIndex = 0;

function showSlides() {
  const slides = document.getElementsByClassName("mySlides");
  
  for (let i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  
  slideIndex++;
  
  if (slideIndex > slides.length) {
    slideIndex = 1;
  }
  
  slides[slideIndex - 1].style.display = "block";
  setTimeout(showSlides, 3000); // Change slide every 2 seconds
}

showSlides();


$(document).ready(function() {
  var menu = $(".menu");
  var lastScrollTop = 0;
  
  $(window).scroll(function() {
    var scrollTop = $(this).scrollTop();
    
    if (scrollTop > lastScrollTop) {
      // Cuộn xuống, thu gọn thanh menu
      menu.css("height", "60px"); // Thiết lập kích thước thu gọn
    } else {
      // Cuộn lên trên cùng, mở rộng thanh menu
      menu.css("height", "300px"); // Thiết lập kích thước mở rộng
    }
    
    lastScrollTop = scrollTop;
  });
});





