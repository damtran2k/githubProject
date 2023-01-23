"use strict";
const loginModal = document.getElementById("login-modal");
const mainContent = document.getElementById("main-content");
const welcomeMessage = document.getElementById("welcome-message");
const btnLogout = document.getElementById("btn-logout");

//  hàm hiển thị nội dung web dựa trên trạng thái người dùng đăng nhập hay chưa đăng nhập

displayHome();
function displayHome() {
  // Nếu có người dùng đăng nhập thì ẩn loginModal và hiển thị mainContent
  // nếu chưa đăng nhập thì hiển thị ngược lại
  if (currentUser) {
    loginModal.style.display = "none";
    mainContent.style.display = "block";
    // Hiển thị Message
    welcomeMessage.textContent = `Welcome ${currentUser.firstName}`;
  } else {
    loginModal.style.display = "block";
    mainContent.style.display = "none";
  }
}
// bắt sự kiện khi nhấn nút Logout
btnLogout.addEventListener("click", function () {
  const isLogout = confirm("Bạn đã chắc chắn muốn đăng xuất");
  if (isLogout) {
    currentUser = null;
    savetoStorage("currentUser", currentUser);
    displayHome();
  }
});
