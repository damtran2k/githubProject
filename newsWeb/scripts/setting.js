"use strict";

const inputPageSize = document.getElementById("input-page-size");
const inputCategory = document.getElementById("input-category");
const btnSetting = document.getElementById("btn-submit");
// Muốn thiết lập tin tức người dùng phải đăng nhập
// nếu chưa đăng nhập thì hiển thị thông báo và chuyển đến trang đăng nhập
if (currentUser) {
  // Bắt sự kiện khi nhấn vào nút Setting
  btnSetting.addEventListener("click", function () {
    const validate = validatedata();
    if (validate) {
      // cập nhật giá trị cho người dùng hiện tại
      currentUser.pageSize = Number.parseInt(inputPageSize.value);
      currentUser.category = inputCategory.value;
      savetoStorage("currentUser", currentUser);
      // cập nhật giá trị cho mảng userArr
      const index = userArr.findIndex(
        (userItem) => userItem.username === currentUser.username
      );
      userArr[index] = currentUser;
      savetoStorage("userArr", userArr);
      //Reset form setting
      alert("Cài đặt thành công");
      inputPageSize.value = "";
      inputCategory.value = "General";
    }
  });
  // validate dữ liệu setting
  function validatedata() {
    let isvalidate = true;
    if (Number.isNaN(Number.parseInt(inputPageSize.value))) {
      alert("Page không hợp lệ");
      return (isvalidate = false);
    }
    if (inputCategory.value === "General") {
      alert("Vui lòng chọn nội dung tin tức");
      return (isvalidate = false);
    }
    return (isvalidate = true);
  }
} else {
  alert("Bạn phải đăng nhập để thiết lập  trang tin tức");
  // quay lại trang Login
  window.location.href = "../pages/login.html";
}
