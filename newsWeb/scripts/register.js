"use strict";
const inputFirstName = document.getElementById("input-firstname");
const inputLastName = document.getElementById("input-lastname");
const inputUserName = document.getElementById("input-username");
const inputPassword = document.getElementById("input-password");
const inputPasswordConFirm = document.getElementById("input-password-confirm");
const btnRegisterSubmit = document.getElementById("btn-submit");

//Bắt sự kiện khi nhấn nút Register
// nhận được dữ liệu của  người nhập
// tiến hành validate
// nếu ok => thêm vào mảng UserArr
// lưu dữ liệu Local Stogare
// chuyển đến trang login
btnRegisterSubmit.addEventListener("click", function () {
  // lấy dữ liệu từ người dùng
  const user = new User(
    // Lấy dữ liệu nhập vào của người dùng
    inputLastName.value,
    inputFirstName.value,
    inputUserName.value,
    inputPassword.value,
    inputPasswordConFirm.value
  );
  const validate = validateUserData(user);
  if (validate) {
    // thêm user vào mảng UserArr
    userArr.push(user);
    // lưu dữ liệu vào localStorage
    savetoStorage("userArr", userArr);
    alert("Đăng ký thành công");
    //  chuyển sang trang login
    window.location.href = "../pages/login.html";
  }
});
function validateUserData(user) {
  let isValidate = true;
  // kiểm tra  firstName
  if (user.firstName.trim().length === 0) {
    alert("Vui lòng nhập firstName");
    return (isValidate = false);
  }
  // kiểm tra lastName
  if (user.lastName.trim().length === 0) {
    alert("Vui lòng nhập firstName");
    return (isValidate = false);
  }
  // kiểm tra username
  if (user.username.trim().length === 0) {
    alert("Vui lòng nhập UserName");
    return (isValidate = false);
  }
  //Kiểm tra tính duy nhất của id
  for (let i = 0; i < userArr.length; i++) {
    if (userArr[i].username === user.username) {
      alert("User name đã tồn tại!");
      return (isValidate = false);
      break;
    }
  }
  // kiểm tra độ dài của mật khẩu và không được bỏ trống
  // Nếu độ dài password = 0  => <8 ký tự
  // nên chỉ 1 điều kiện < 8
  if (user.password.trim().length < 8) {
    alert("Độ dài của mật khẩu phải hơn 8 ký tự");
    return (isValidate = false);
  }
  // kiểm tra mật khẩu có giống nhau hay không
  // Do  passwword và cofirm password phải giống nhau thì  validate = true
  // mà  độ dài password < 8
  // tránh alert quá nhiều lần nên chỉ cần điều kiện so sánh giữa password và confirm password
  if (user.password !== inputPasswordConFirm.value) {
    alert(" Xác nhận mật khẩu không khớp");
    return (isValidate = false);
  }

  return isValidate;
}
