"use strict";

//. Lưu dữ liệu dưới LocalStorage
function savetoStorage(key, value) {
  localStorage.setItem(key, JSON.stringify(value));
}
//lấy dữ liệu trong localStorage
const getfromStorage = function (key) {
  return JSON.parse(localStorage.getItem(key));
};
// lấy dữ liệu từ userArr sang LocalStorage
const users = getfromStorage("userArr") ? getfromStorage("userArr") : [];
// chuyển đổi dữ liệu về class intance
const userArr = users.map((user) => parseUser(user));
// lấy dữ liệu  User đăng nhập
let currentUser = getfromStorage("currentUser");
console.log(currentUser);
/////////////////////////////////////////////
// LocalStorage, bạn chỉ có thể lưu được các JS Object chứ không phải Class Instance
// hàm để chuyển từ JS Object sang Class Instance
function parseUser(userData) {
  const user = new User(
    userData.firstName,
    userData.lastName,
    userData.username,
    userData.password,
    // thêm  thuộc tính để làm tính năng số 9 setting news
    userData.category,
    userData.pageSize
  );

  return user;
}
