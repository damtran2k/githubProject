"use strict";

const newsContainer = document.getElementById("news-container");
const btnPrev = document.getElementById("btn-prev");
const pageNum = document.getElementById("page-num");
const btnNext = document.getElementById("btn-next");
let totalResults = 0;

// Tin tức chỉ được hiển thị khi người dùng đăng nhập
// Nếu chưa đăng nhập thì chuyển hướng đến trang đăng nhập
if (currentUser) {
  async function getdataNews(country, category, pageSize, page) {
    try {
      // kết nối với API và lấy dữ liệu
      const res = await fetch(
        `https://newsapi.org/v2/top-headlines?country=${country}&category=${currentUser.category}&pageSize=${currentUser.pageSize}&page=${page}&apiKey=5df755cbd90a48d58150a136cb9b9b3c`
      );
      // mã hóa dữ liệu từ api
      const data = await res.json();
      console.log(data);
      displayNews(data);
    } catch (err) {
      alert(`Error + ${err.mesage}`);
    }
  }
  getdataNews("us", currentUser.category, currentUser.pageSize, 1);
  async function getdataNews1(){
    try{
      const res = await fetch(`#`);
      const data = await res.json();
    }catch (err){
        alert(`Err +${err.mesage}`)
    }
  }
  /////////////////////////////
  // Tạo hàm hiển thị các tin tức lên trang News
  function displayNews(data) {
    //tổng số bài viết  =  tổng số kết quả bài viết được  tìm thấy từ web API
    totalResults = data.totalResults;
    // Ẩn nút pre khi tin tức ở trang 1
    pageNum.textContent == 1
      ? (btnPrev.style.display = "none")
      : (btnPrev.style.display = "block");
    // Ẩn nút Next khi tin tức ở trang 20
    pageNum.textContent == Math.ceil(totalResults / currentUser.pageSize)
      ? (btnNext.style.display = "none")
      : (btnNext.style.display = "block");

    // số lượng bài viết hiển thị
    newsContainer.innerHTML = data.articles
      // do các tin tức được lưu dưới mảng Arr
      // dùng map để lặp các phần tử item trong articles
      .map(
        // sử dụng hàm arrow function để return ra nội dung news
        (item) => `<div class="card flex-row flex-wrap">
  <div class="card mb-3" style="">
    <div class="row no-gutters">
      <div class="col-md-4">
        <img
          src= ${item.urlToImage}
          class="card-img"
          alt="img"
        />
      </div>
      <div class="col-md-8">
        <div class="card-body">
          <h5 class="card-title">
            ${item.title}
          </h5>
          <p class="card-text">
            ${item.description}
          </p>
          <a
            href=${item.url} target="_blank"
            class="btn btn-primary"
            >View</a
          >
        </div>
      </div>
     </div>
    </div>
  </div>`
      )
      // dùng join để nối các div không có kí tự nào.
      .join("");
  }

  btnNext.addEventListener("click", function () {
    // console.log(getdataNews("us", "business", 20, 1));
    getdataNews(
      "us",
      currentUser.category,
      currentUser.pageSize,
      ++pageNum.textContent
    );
  });
  btnPrev.addEventListener("click", function () {
    getdataNews(
      "us",
      currentUser.category,
      currentUser.pageSize,
      --pageNum.textContent
    );
  });
} else {
  alert("Bạn phải đăng nhập để xem tin tức");
  // quay lại trang Login
  window.location.href = "../pages/login.html";
}
