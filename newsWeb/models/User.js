"use strict";
//Class User để đại diện cho thông tin của người dùng
// ở pagesize, categogy set mặc định cho chúng
// để người dùng khi mới đăng nhập, chưa cài đặt  bản tin
// vẫn hiển thị tin tức
class User {
  constructor(
    firstName,
    lastName,
    username,
    password,
    passwordConfirm,
    pageSize = 10,
    category = "business"
  ) {
    // Khai báo các thuộc tính
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.passWordConfirm = passwordConfirm;
    // thêm thuộc tính để làm tính năng setting news
    this.pageSize = pageSize;
    this.category = category;
  }
}

//Class Task để chứa các thông tin về Task trong Todo List.
class Task {
  constructor(task, owner, isDone) {
    this.task = task;
    this.owner = owner;
    this.isDone = isDone;
  }
}
