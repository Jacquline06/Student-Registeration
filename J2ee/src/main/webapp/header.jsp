<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style >
.dropdown {
  display: inline-block;
  position: relative;
        margin: 0 auto;
        text-align: center;  
  
width: 300px;  
height: 200px;  
padding-top: 100px; 
}
.dropdown-content {
  display: none;
  position: absolute;
  width: 100%;
  overflow: auto;
  box-shadow: 0px 10px 10px 0px rgba(0,0,0,0.4);
}
.dropdown:hover .dropdown-content {
  display: block;
}
.dropdown-content a {
  display: block;
  color: #000000;
  padding: 5px;
  text-decoration: none;
}
.dropdown-content a:hover {
  color: #FFFFFF;
  background-color: #00A4BD;
}


</style>


</head>
<body>
<div class="dropdown">
  <button>Menu</button>
  <div class="dropdown-content">
  <a href="https://www.swiggy.com/restaurants/chennai-coffee-adyar-chennai-158213">Coffee</a>
  <a href="https://www.swiggy.com/city/chennai/tea-time">Tea</a>
  <a href="https://www.swiggy.com/restaurants/amul-dairy-t-h-road-thiruvottiyur-chennai-280616">Milk</a>
  </div>
</div>
</body>
</html>