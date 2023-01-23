"use strict";
const inputUsername = document.getElementById("input-username");
const inputPassword = document.getElementById("input-password");
const btnLogin = document.getElementById("btn-submit");
///////////
// Bắt sự kiện khi người dùng nhấn vào nút login
// kiểm tra người dùng có nhập thông tin hay chưa
//Nếu ok => thì tiến hành so sánh
//giá trị username,pass người dùng nhập vào
//có bằng với giá trị của username,password trong mảng UserArr
// nếu true => Login thành công,
// flase => thông báo alert
btnLogin.addEventListener("click", function () {
  // kiểm tra người dùng có nhập đủ thông tin hay chưa
  const validate = validatedata();
  if (validate) {
    //Tìm trong userArr thông tin người nhập đúng hay không
    // Có trường hợp người dùng đặt password với toàn số => kiểu number
    // khác với kiểu dữ liệu nhập vào là string
    // nên chỉ so sánh giá trị của password, không so sánh kiểu
    const user = userArr.find(
      (item) =>
        item.username === inputUsername.value &&
        item.password == inputPassword.value
    );
    if (user) {
      alert("Đăng nhập thành công");
      //  lưu thông tin người dùng hiện tại xuống dưới LocalStorage
      savetoStorage("currentUser", user);
      // chuyển hướng về trang chủ
      // window.location.assign("../index.html");
      window.location.href = "../index.html";
    } else {
      alert("Thông tin đăng nhập không đúng,vui lòng kiểm tra lại");
    }
  }
});
// Hàm validate dữ liệu của người dùng
function validatedata() {
  let isValidate = true;
  if (inputUsername.value === "") {
    alert("Vui lòng nhập UserName !");
    isValidate = false;
  }
  if (inputPassword.value === "") {
    alert("Vui lòng nhập Password !");
    isValidate = false;
  }

  return (isValidate = true);
}
