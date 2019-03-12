<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="Header.jsp"%>


<!-- <div class="container"> -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${images}/banner01.jpg" alt="Image1" style="width:100%;height:100%">
      </div>

      <div class="item">
        <img src="${images}/banner02.jpg" alt="Image2" style="width:100%;height:100%">
      </div>
    
      <div class="item">
        <img src="${images}/banner03.jpg" alt="Image3" style="width:100%;height:100%">
      </div>
      
      <div class="item">
        <img src="${images}/banner04.jpg" alt="Image3" style="width:100%;height:100%">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
<!-- </div> -->

<br/>

	
<div class="container">
  <div class="jumbotron">
    <h1>Pet's Villa</h1> 
    <p class = "a">A pet or companion animal is an animal kept primarily for a person's company, protection, entertainment, or as an act of compassion such as taking in and protecting a hungry stray cat, rather than as a working animal, livestock, or laboratory animal. Popular pets are often noted for their attractive appearances, intelligence, and relatable personalities, or may just be accepted as they are because they need a home. </p> 
  </div>
	<div class="row">
<div class="col-sm-6"><img src="${images}/cat-2536662_640.jpg" style="width:100%;height:100%"></div>
  <div class="col-sm-6"><img src="${images}/dog-2561134_640.jpg" style="width:100%;height:100%"></div>
  
</div>	
</div>

<br/>


<%@include file="Footer.jsp"%>
