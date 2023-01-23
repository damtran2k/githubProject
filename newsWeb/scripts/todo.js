"use strict";
const todoArr = getfromStorage("todoArr") ? getfromStorage("todoArr") : [];
const todoList = document.getElementById("todo-list");
const btnAdd = document.getElementById("btn-add");
const inputTask = document.getElementById("input-task");
// ToDo list
// Người dùng phải đăng nhập mới có thể xem được ToDolist
// Nếu người dùng không đăng nhập thì alert và quay lại trang Login
if (currentUser) {
  function displayTask() {
    let html = "";
    // từ mảng todoArr lọc các Task của người dùng hiện  tại
    // rồi hiển thị ra màn hình
    todoArr
      .filter((todo) => todo.owner === currentUser.username)
      .forEach(function (todo) {
        html += `<li class= ${todo.isDone ? "checked" : ""}>${
          todo.task
        }<span class="close">×</span></li>`;
      });
    todoList.innerHTML = html;
    eventToggle();
    eventDelete();
  }
  // gọi hàm hiển thị ra màn hình
  displayTask();

  //Bắt sự kiện khi ấn vào nút Add
  // nếu có dữ liệu nhập vào thì có thể thêm vào Task
  // ngược lại thì thông báo lỗi
  btnAdd.addEventListener("click", function () {
    if (inputTask.value.trim() == "") {
      alert("Vui lòng nhập Task");
    } else {
      const todo = new Task(inputTask.value, currentUser.username, false);
      todoArr.push(todo);
      savetoStorage("todoArr", todoArr);
      displayTask();
      inputTask.value = "";
    }
  });
  ///////////
  //Toggle Task
  //có thể đánh dấu là Task đó đã hoàn thành hoặc chưa hoàn thành,
  function eventToggle() {
    document.querySelectorAll("#todo-list li").forEach(function (liEl) {
      liEl.addEventListener("click", function (e) {
        // tránh nhấn vào nút Delete
        if (e.target !== liEl.children[0]) {
          liEl.classList.toggle("checked");
          const todo = todoArr.find(
            (item) =>
              item.owner === currentUser.username &&
              item.task === liEl.textContent.slice(0, -1)
          );
          // thay đổi thuộc tính isDone của task
          todo.isDone = liEl.classList.contains("checked") ? true : false;
          // Cập nhật xuống localStoge
          savetoStorage("todoArr", todoArr);
        }
      });
    });
  }
  // Delete Task
  // xóa task tương ứng ra khỏi danh sách.
  function eventDelete() {
    document.querySelectorAll("#todo-list .close").forEach(function (closeEl) {
      closeEl.addEventListener("click", function () {
        const isConfirm = confirm("Bạn muốn xóa List này");
        if (isConfirm) {
          // Tìm vị trí phần tử muốn xóa
          const index = todoArr.findIndex(
            (item) =>
              item.owner === currentUser.username &&
              item.task === closeEl.parentElement.textContent.slice(0, -1)
          );
          // xóa list ra khỏi mảng Arr
          todoArr.splice(index, 1);
          savetoStorage("todoArr", todoArr);
          displayTask();
        }
      });
    });
  }
} else {
  alert("Bạn phải đăng nhập tài khoản để xem Todo List!");
  // chuyển đến trang đăng nhập
  window.location.href = "../pages/login.html";
}
