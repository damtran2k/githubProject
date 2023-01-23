<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<main class="container">
		<header class="row">
			<div class="col">
				<div class="alert alert-sucess">
					<h1>Dang Ky</h1>
				</div>

			</div>
		</header>
		<section class="row">
			<div class="col-7">
				<div class="row">
					<div class="col">
						<form action="RegisterServlet" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="username">Ten dang nhap</label>
								 <input type="text" class="form-control" name="username" id="username">
							</div>

							<div class="form-group">
								<label for="password">Mat khau</label> 
								<input type="password" class="form-control" name="password" id="password">
							</div>
							<div class="form-group">
								<label for="dateOfBirth">Ngay sinh</label>
								<input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth"	>
							</div>
							<div class="custom-file mb4">
								<label for="image" class="custom-file-label">Hinh</label>
								<input type="file" class="custom-file-input" id="image" name="image">
							</div>
							<div class="form-group">
								<label for="gender">Gioi tinh</label>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" id="genderM"
										name="gender" value="true">
										 <label for="gender">Male</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" id="genderF"
										name="gender" value="false">
										 <label for="gender">Female</label>
								</div>
							</div>
							<div class="form-group">
								<div class="form-check"></div>
								<input type="checkbox" class="form-check-input" id="married"
									name="married" value="true">
									 <label for="married"> Da ket hon chua</label>
							</div>
							<div class="form-group">
								<label for="nationality">Quoc tich</label>
								 <select
									name="nationality" id="nationality" class="form-control">
									<option value="vi">Viet Nam</option>
									<option value="us">USA</option>
									<option value="jp">Japan</option>
								</select>
							</div>

							<div class="form-group">
								<label for="favorites">So thich</label>
								<div class="form-check form-check-inline">
									<input type="checkbox" class="form-check-input" id="read"
										name="favorties" value="read"> 
										<label for="read">Doc sach</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="checkbox" class="form-check-input" id="music"
										name="music" value="music"> 
										<label for="favorties">Nghe nhac</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="checkbox" class="form-check-input" id="sport"
										name="favorties" value="sport">
										 <label for="sport">the thao</label>
								</div>
							</div>
							<div class="form-group">
								<label for="note">Ghi chu</label>
								<textarea name="note" id="note" class="form-control" rows="3"></textarea>
							</div>
							<hr>
							<button type="sumit" class="btn btn-primary">Dang ky</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-5">
				<h3>thong tin da duoc dang ky</h3>
				<ul>
					<li>
						<img class="img-fluid" alt=" " src="uploads/${staff.imageName }" width="150">
					</li>
					<li>Ten dang nhap: ${staff.username }</li>
					<li>Password: ${staff.password }</li>
					<li>Gioi tinh ${staff.gender ? 'Nam' : 'Nu' }</li>
					<li>Ket hon: ${staff.married ? 'Da ket hon' : 'Doc Than' }</li>
					<li>Quoc tich: ${staff.nationality }</li>
					<li>So thich: ${staff.favorites }</li>
					<li>Note: ${staff.note }</li>
				</ul>
			</div>
		</section>
	</main>



	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
</body>
</html>